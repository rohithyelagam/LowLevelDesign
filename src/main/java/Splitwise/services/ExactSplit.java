package Splitwise.services;

import Splitwise.models.User;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

public class ExactSplit implements SplitStrategy{

    @Override
    public List<Pair<User, Double>> split(List<User> userList, List<String> s, double amount) {
        int n = userList.size();
        List<Pair<User, Double>> splitList = new ArrayList<>();
        if(n==0)return splitList;
        List<Double> exactAmounts = s.stream().map(e->Double.parseDouble(e)).toList();
        for(int i=0;i<n;i++){
            splitList.add(Pair.of(userList.get(0), exactAmounts.get(0)));
        }
        return splitList;
    }

}
