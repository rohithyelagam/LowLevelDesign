package LoggingFramework.LogLevel;

import LoggingFramework.Models.Message;

public class DebugLogLevel implements LogLevel{
    @Override
    public String getLog(Message message) {
        return "DEBUG : "+message.getContent();
    }
}
