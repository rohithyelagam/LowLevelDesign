package LoggingFramework.LogLevel;

import LoggingFramework.Models.Message;

public abstract class LogLevelFactory {

    private LogLevel logLevel;

    public LogLevelFactory(){
        this.logLevel = createLogLevel();
    }

    public abstract LogLevel createLogLevel();

    public String getLog(Message message){
        return logLevel.getLog(message);
    }

}
