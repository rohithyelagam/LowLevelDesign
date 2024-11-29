package PubSubModel;

public interface Subscriber {
    public void handleMessage(Message message);
}
