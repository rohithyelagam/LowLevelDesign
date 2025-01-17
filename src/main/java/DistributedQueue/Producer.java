package DistributedQueue;

public class Producer {

    private Integer id;

    public Producer(Integer id){
        this.id = id;
    }

    public void publish(Topic topic, String message){
        topic.publish(message);
    }

}
