package DistributedQueue;

import java.util.HashMap;
import java.util.Map;

public class Consumer implements IConsumer {

    private Integer id;
    private Map<String, Topic> topics;
    private Map<String, Integer> offset;

    public Consumer(Integer id){
        this.id = id;
        this.topics = new HashMap<>();
        this.offset = new HashMap<>();
    }

    @Override
    public void subscribe(Topic newTopic){
        String topicId = newTopic.getId();
        Topic topic = topics.get(topicId);
        if(topic!=null){
            System.out.println("Already subscribed.");
            return;
        }
        topics.put(topicId,newTopic);
        offset.put(topicId, 1);
    }

    @Override
    public void handleMessage(String topicId) {
        if(id == 2){
            try{
                Thread.sleep(3000);
            }catch (Exception e){
                System.out.println("Exception "+e.getMessage());
            }
        }
        Topic topic = topics.get(topicId);
        Integer currOffset = offset.get(topicId);
        System.out.println(id+" received "+topic.getMessage(currOffset));
        offset.put(topicId, currOffset+1);
    }
}
