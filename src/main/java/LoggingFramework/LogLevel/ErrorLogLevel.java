package LoggingFramework.LogLevel;

import LoggingFramework.Models.Message;

public class ErrorLogLevel implements LogLevel{
    @Override
    public String getLog(Message message) {
        return "ERROR : "+message.getContent();
    }
}
