package LoggingFramework.LogLevel;

import LoggingFramework.Models.Message;

public class InfoLogLevel implements LogLevel{
    @Override
    public String getLog(Message message) {
        return "INFO : "+message.getContent();
    }
}
