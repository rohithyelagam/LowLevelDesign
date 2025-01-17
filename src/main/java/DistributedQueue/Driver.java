package DistributedQueue;

public class Driver {


    public static void main(String[] args) {


        Topic topic1 = new Topic("Orders");
        Topic topic2 = new Topic("Payments");

        Producer p1 = new Producer(1);
        Producer p2 = new Producer(2);

        IConsumer c1 = new Consumer(1);
        IConsumer c2 = new Consumer(2);
        IConsumer c3 = new Consumer(3);
        IConsumer c4 = new Consumer(4);
        IConsumer c5 = new Consumer(5);

        topic1.subscribe(c1);
        topic1.subscribe(c2);
        topic1.subscribe(c3);
        topic1.subscribe(c4);
        topic1.subscribe(c5);

        topic2.subscribe(c1);
        topic2.subscribe(c3);
        topic2.subscribe(c5);


        p1.publish(topic1, "Message1");
        p1.publish(topic1, "Message2");

        p2.publish(topic1, "Message3");

        p1.publish(topic2, "Message4");
        p2.publish(topic2, "Message5");


    }
}
