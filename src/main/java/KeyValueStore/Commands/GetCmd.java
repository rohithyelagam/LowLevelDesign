package KeyValueStore.Commands;

import KeyValueStore.Atrributes.Attribute;
import KeyValueStore.KeyValueStore;

import java.util.Map;

public class GetCmd implements Command{

    private KeyValueStore store;
    private String key;

    public GetCmd(KeyValueStore store, String key) {
        this.store = store;
        this.key = key;
    }

    @Override
    public void execute() {
        int idx = 1;
        Map<String, Attribute> values = store.get(key);

        if(values==null || values.isEmpty()){
            System.out.println("No entry found for "+key);
            return;
        }
        for(Map.Entry<String, Attribute> m : values.entrySet()){
            System.out.print(m.getKey()+": "+m.getValue().toString());
            if(idx != values.size()){
                System.out.print(", ");
            }else{
                System.out.println();
            }
            idx++;
        }
    }
}
