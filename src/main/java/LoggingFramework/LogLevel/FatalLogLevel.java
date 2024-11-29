package LoggingFramework.LogLevel;

import LoggingFramework.Models.Message;

public class FatalLogLevel implements LogLevel{
    @Override
    public String getLog(Message message) {
        return "FATAL : "+message.getContent();
    }
}
