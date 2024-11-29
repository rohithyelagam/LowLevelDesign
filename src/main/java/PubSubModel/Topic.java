package PubSubModel;

import java.util.ArrayList;
import java.util.List;

public class Topic {

    private String name;
    private List<Subscriber> subscribers;

    public Topic(String name){
        this.name = name;
        this.subscribers = new ArrayList<>();
    }

    public void addSubscriber(Subscriber subscriber){
        this.subscribers.add(subscriber);
    }

    public void removeSubscriber(Subscriber subscriber){
        this.subscribers.remove(subscriber);
    }

    protected void notifySubscribers(Message message){
        for(Subscriber s : subscribers){
            s.handleMessage(message);
        }
    }

    public synchronized void sendMessage(Message message){
        System.out.println("------Message received. sending to subscribers------");
        notifySubscribers(message);
    }

}
