package KeyValueStore.Commands;

import KeyValueStore.KeyValueStore;

public class DeleteCmd implements Command{

    private KeyValueStore store;
    private String key;

    public DeleteCmd(KeyValueStore store, String key) {
        this.store = store;
        this.key = key;
    }

    @Override
    public void execute() {
        store.delete(key);
    }


}
