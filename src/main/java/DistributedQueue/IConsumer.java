package DistributedQueue;

public interface IConsumer {
    public void subscribe(Topic topic);
    public void handleMessage(String topicId);
}
