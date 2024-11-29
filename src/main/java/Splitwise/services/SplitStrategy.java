package Splitwise.services;

import Splitwise.models.User;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

public interface SplitStrategy {
    public List<Pair<User,Double>> split(List<User> userList, List<String> s,double amount);
}
