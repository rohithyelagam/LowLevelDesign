package PubSubModel;

public class Driver {
    public static void main(String[] args) {

        Topic kafka = new Topic("kafka");

        Publisher p1 = new PublisherImpl("rohith", kafka);

        Subscriber s1 = new SubscriberImpl("supriya");
        Subscriber s2 = new SubscriberImpl("rajesh");

        kafka.addSubscriber(s1);
        kafka.addSubscriber(s2);

        Message m1 = new Message("Hi, I am Rohith Yelagam");

        p1.SendMessage(m1);

        kafka.removeSubscriber(s2);

        p1.SendMessage(m1);


    }
}
