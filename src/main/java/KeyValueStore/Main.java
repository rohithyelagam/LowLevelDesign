package KeyValueStore;

import KeyValueStore.Commands.*;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        KeyValueStore store = KeyValueStore.getInstance();
        KeyValueStoreHandler handler = new KeyValueStoreHandler();

        Scanner sc = new Scanner(System.in);

        String cmd = sc.next().trim();

        while(!cmd.equals("exit")){
            switch (cmd) {
                case "get" -> {
                    String key = sc.nextLine().trim();
                    handler.setCommand(new GetCmd(store, key));
                }
                case "search" -> {
                    String key = sc.next().trim();
                    String value = sc.nextLine().trim();
                    handler.setCommand(new SearchCmd(store, key, value));
                }
                case "put" -> {
                    List<String> valueList = Arrays.stream(sc.nextLine().trim().split(" ")).toList();
                    List<Pair<String, String>> attributes = new ArrayList<>();
                    for (int i = 1; i < valueList.size(); i += 2) {
                        attributes.add(Pair.of(valueList.get(i), valueList.get(i + 1)));
                    }
                    handler.setCommand(new PutCmd(store, valueList.get(0), attributes));
                }
                case "delete" -> {
                    String key = sc.nextLine().trim();
                    handler.setCommand(new DeleteCmd(store, key));
                }
                case "keys" -> handler.setCommand(new KeysCmd(store));
            }
            handler.execute();
            cmd = sc.next().trim();
        }

    }
}
