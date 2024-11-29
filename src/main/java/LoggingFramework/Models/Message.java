package LoggingFramework.Models;

import java.time.LocalDateTime;

public class Message {
    private LocalDateTime localDateTime;
    private String content;

    public Message(String content){
        this.content = content;
        this.localDateTime = LocalDateTime.now();
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
