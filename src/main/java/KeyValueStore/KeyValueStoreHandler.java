package KeyValueStore;

import KeyValueStore.Commands.Command;

public class KeyValueStoreHandler {

    private Command command;

    public void setCommand(Command command){
        this.command = command;
    }

    public void execute(){
        command.execute();
    }

}
