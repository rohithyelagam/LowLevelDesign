package PubSubModel;

public class SubscriberImpl implements Subscriber{

    private String name;

    SubscriberImpl(String name){
        this.name = name;
    }

    @Override
    public void handleMessage(Message message) {
        System.out.print("Message RECD :: "+name+" : ");
        message.printMessage();
    }
}
