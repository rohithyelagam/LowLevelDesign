package LoggingFramework.LogLevel;

import LoggingFramework.Models.Message;

public class WarningLogLevel implements LogLevel{
    @Override
    public String getLog(Message message) {
        return "WARNING : "+message.getContent();
    }
}
