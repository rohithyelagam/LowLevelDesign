package LoggingFramework.Service;

import LoggingFramework.Destination.ConsoleDestFactory;
import LoggingFramework.Destination.DestFactory;
import LoggingFramework.Destination.Destination;
import LoggingFramework.LogLevel.DebugLogLevelFactory;
import LoggingFramework.LogLevel.LogLevel;
import LoggingFramework.LogLevel.LogLevelFactory;
import LoggingFramework.Models.Message;

public class Logger {
    private static Logger logger;
    private LogLevelFactory logLevelFactory;
    private DestFactory destFactory;

    private LogLevel logLevel;
    private Destination destination;

    private Logger(){
        this.logLevelFactory = new DebugLogLevelFactory();
        this.destFactory = new ConsoleDestFactory();

        this.logLevel = this.logLevelFactory.createLogLevel();
        this.destination = this.destFactory.getDestination();
    }

    public static synchronized Logger getLogger(){
        if(logger==null){
            logger = new Logger();
        }
        return logger;
    }

    public void setLogLevel(LogLevelFactory logLevelFactory){
        this.logLevelFactory = logLevelFactory;
        this.logLevel = this.logLevelFactory.createLogLevel();
    }

    public void setDestination(DestFactory destFactory){
        this.destFactory = destFactory;
        this.destination = this.destFactory.getDestination();
    }

    public synchronized void log(Message message){
        String mess = this.logLevel.getLog(message);
        this.destination.send(mess);
    }

}
