package KeyValueStore.Commands;

import KeyValueStore.KeyValueStore;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

public class PutCmd implements Command{

    private KeyValueStore store;
    private String key;
    private List<Pair<String, String>> value;

    public PutCmd(KeyValueStore store, String key, List<Pair<String, String>> value) {
        this.store = store;
        this.key = key;
        this.value = value;
    }

    @Override
    public void execute() {
        try{
            store.put(key, value);
        }catch (Exception e){
            System.out.println("Data Type Error");
        }
    }

}
