package Splitwise.services;

import Splitwise.models.EXPENSETYPE;
import Splitwise.models.User;
import Splitwise.models.newEqualExpense;
import Splitwise.models.newExpense;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

public class ExpenseHandler {

    List<User> userList;
    List<newExpense> expenseList;
    Map<User, Map<User,Double>> balances;

    public ExpenseHandler(){
        this.userList = new ArrayList<>();
        expenseList = new ArrayList<>();
        balances = new HashMap<>();
    }

    public void start(Scanner sc){
        while(sc.hasNext()){
            String desc = sc.next();
            String val = sc.nextLine().trim();
            if(desc.equals("EXPENSE")){
                List<String> values = Arrays.asList(val.split(" "));
                this.addExpense(values);
            }else{
                if(val.isEmpty()){
                    this.show();
                }else{
                    this.show(val);
                }
            }
        }
    }

    public void addExpense(List<String> inputParams){

//        ExpenseFactory expenseFactory = new ExactExpenseFactory();

        double totalAmount = Double.parseDouble(inputParams.get(1));
        int count = Integer.parseInt(inputParams.get(2));
        User paidBy = getUser(inputParams.get(0));
        EXPENSETYPE expensetype = EXPENSETYPE.getType(inputParams.get(3+count));
        List<User> userList = inputParams.subList(3,3+count).stream().map(this::getUser).toList();
        List<String> involvedAmounts = inputParams.subList(4+count,inputParams.size());

        if(expensetype.equals(EXPENSETYPE.EQUAL)){
//            expenseFactory = new EqualExpenseFactory();
        }else if(expensetype.equals(EXPENSETYPE.EXACT)){
//            expenseFactory = new ExactExpenseFactory();
        }

        newExpense expense = new newEqualExpense(EXPENSETYPE.EQUAL);

        List<Pair<User,Double>> dividedList = expense.getDividedAmong(userList, involvedAmounts, totalAmount);

        expenseList.add(expense);
        balances.computeIfAbsent(paidBy, k -> new HashMap<>());

        for(Pair<User, Double> p : dividedList){
            User u = p.getKey();
            if(u.getId().equals(paidBy.getId()))continue;

            balances.get(paidBy).putIfAbsent(u, 0.0);

            Double curVal = p.getValue();

            balances.get(paidBy).compute(u, (k, preVal) -> curVal + preVal);
        }

    }

    public void show(){
        int count=0;
        for(Map.Entry<User,Map<User,Double>> e : balances.entrySet()){
            User prev = e.getKey();
            for(Map.Entry<User,Double> f: e.getValue().entrySet()){
                User curr = f.getKey();
                Double val = f.getValue();
                System.out.println(curr.getName()+" owes "+prev.getName()+": "+val);
                count++;
            }
        }
        if(count == 0)System.out.println("No balances");
    }

    public void show(String u){
        int count=0;
        for(Map.Entry<User,Map<User,Double>> e : balances.entrySet()){
            User prev = e.getKey();
            for(Map.Entry<User,Double> f: e.getValue().entrySet()){
                User curr = f.getKey();
                Double val = f.getValue();
                if(getUser(u).getId().equals(prev.getId()) || getUser(u).getId().equals(curr.getId())) {
                    System.out.println(curr.getName() + " owes " + prev.getName() + ": " + val);
                    count++;
                }
            }
        }
        if(count == 0)System.out.println("No balances");
    }

    public void addUser(User ...users){
        userList.addAll(Arrays.asList(users));
    }

    public User getUser(String u){
        return this.userList.stream().filter(e -> e.getName().equals(u)).findFirst().get();
    }

}
