package Splitwise.services;

import Splitwise.models.User;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

public class EqualSplit implements SplitStrategy{

    @Override
    public List<Pair<User, Double>> split(List<User> userList, List<String> s,double amount) {
        int n = userList.size();
        List<Pair<User, Double>> splitList = new ArrayList<>();
        if(n==0)return splitList;

        double splitAmount = amount/n;

        double eq1 = (int)(splitAmount*100)/100.0;
        double eq2 = amount - (n-1)*(eq1);
        eq2 = (int)(eq2*100)/100.0;

        for(int i=0;i<n;i++){
            splitList.add(Pair.of(userList.get(i),(i==0)?eq2:eq1));
        }
        return splitList;
    }

}
