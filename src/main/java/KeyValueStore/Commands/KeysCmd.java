package KeyValueStore.Commands;

import KeyValueStore.KeyValueStore;

import java.util.List;

public class KeysCmd implements Command{

    private KeyValueStore store;

    public KeysCmd(KeyValueStore store) {
        this.store = store;
    }

    @Override
    public void execute() {
        int idx = 1;
        List<String> keys = store.keys();
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
