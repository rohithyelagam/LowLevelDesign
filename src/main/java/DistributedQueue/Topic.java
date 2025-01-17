package DistributedQueue;

import java.util.HashMap;
import java.util.Map;

public class Topic {

    private String name;
    private Map<Integer, String> messages;
    private Map<Integer, IConsumer> subscribers;
    private Integer messageCount = 0;
    private Integer subscriberCount = 0;

    public Topic(String name){
        this.name = name;
        this.messages = new HashMap<>();
        this.subscribers = new HashMap<>();
    }

    public String getId(){
        return name;
    }

    public String getMessage(Integer id){
        return messages.get(id);
    }

    public synchronized void publish(String message){
        this.messageCount++;
        messages.put(messageCount, message);
    }

    public synchronized void subscribe(IConsumer subscriber){
        this.subscriberCount++;
        this.subscribers.put(subscriberCount, subscriber);
        subscriber.subscribe(this);
    }

}
