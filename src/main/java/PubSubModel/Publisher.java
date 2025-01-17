package PubSubModel;

public interface Publisher {
    public void SendMessage(Message message);
    private void display(){
        System.out.println("testing");
    }
}
