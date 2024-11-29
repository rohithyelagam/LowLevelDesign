package Splitwise.models;

import Splitwise.services.EqualSplit;
import Splitwise.services.ExactSplit;
import Splitwise.services.SplitStrategy;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;
import java.util.UUID;

public class newExpense {

    private SplitStrategy splitStrategy;
    private String id;
    private EXPENSETYPE type;
    private double totalAmount;
    private User paidBy;
    private List<Pair<User,Double>> dividedAmong;

    public newExpense(EXPENSETYPE e){
        this.id = UUID.randomUUID().toString();
        this.type = e;
        if(e.equals(EXPENSETYPE.EQUAL)){
            splitStrategy = new EqualSplit();
        }else if(e.equals(EXPENSETYPE.EXACT)){
            splitStrategy = new ExactSplit();
        }
    }

    public  List<Pair<User,Double>> getDividedAmong(List<User> userList,List<String> dividedValues,double totalAmount){
        return splitStrategy.split(userList, dividedValues, totalAmount);
    }
}
