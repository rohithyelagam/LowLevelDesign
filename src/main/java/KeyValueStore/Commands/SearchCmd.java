package KeyValueStore.Commands;

import KeyValueStore.KeyValueStore;

import java.util.List;

public class SearchCmd implements Command{

    private KeyValueStore store;
    private String key;
    private String value;

    public SearchCmd(KeyValueStore store, String key, String value) {
        this.store = store;
        this.key = key;
        this.value = value;
    }

    @Override
    public void execute() {
        int idx = 1;
        List<String> keys = store.search(key, value);
        for (String s : keys){
            System.out.print(s);
            if(idx!=keys.size()){
                System.out.print(",");
            }else{
                System.out.println();
            }
            idx++;
        }
    }
}
