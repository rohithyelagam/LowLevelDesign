package PubSubModel;

public class PublisherImpl implements Publisher{

    private String name;
    private Topic topic;

    PublisherImpl(String name, Topic topic){
        this.name = name;
        this.topic = topic;
    }

    @Override
    public void SendMessage(Message message) {
        System.out.print("Message SENT :: "+name+" : ");
        message.printMessage();
        topic.sendMessage(message);
    }
}
