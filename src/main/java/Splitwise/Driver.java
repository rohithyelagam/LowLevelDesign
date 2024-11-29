package Splitwise;

import Splitwise.models.*;
import Splitwise.services.ExpenseHandler;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args){

        ExpenseHandler expenseHandler = new ExpenseHandler();

        User u1 = new User("u1","rohith@gail.com","9912952141");
        User u2 = new User("u2","supriya@gail.com","9912952141");
        User u3 = new User("u3","venkat@gail.com","9912952141");
        User u4 = new User("u4","raju@gail.com","9912952141");

        expenseHandler.addUser(u1, u2, u3, u4);

        Scanner sc = new Scanner(System.in);

        expenseHandler.start(sc);

//        ExpenseFactory factory = new ExactExpenseFactory();

//        newExpense expense = factory.getExpense();

//        expense.someOperation();

    }
}
