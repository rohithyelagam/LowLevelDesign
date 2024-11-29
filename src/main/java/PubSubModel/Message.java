package PubSubModel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message {
    private LocalDateTime localDateTime;
    private String content;

    private DateTimeFormatter formatter;

    public Message(String content){
        this.content = content;
        this.localDateTime = LocalDateTime.now();
        this.formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:MM:SS");
    }

    public void printMessage(){
        System.out.println(formatter.format(localDateTime)+" : "+content);
    }
}
