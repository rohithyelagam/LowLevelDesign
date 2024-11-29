package LoggingFramework;

import LoggingFramework.Destination.DataBaseDestFactory;
import LoggingFramework.Destination.FileDestFactory;
import LoggingFramework.LogLevel.ErrorLogLevelFactory;
import LoggingFramework.Models.Message;
import LoggingFramework.Service.Logger;

public class Driver {
    public static void main(String[] args) {

        Message message = new Message("Testing Message 200021");

        Logger logger = Logger.getLogger();

        logger.log(message);

        logger.setDestination(new DataBaseDestFactory());
        logger.log(message);

        logger.setLogLevel(new ErrorLogLevelFactory());
        logger.log(message);

        logger.setDestination(new FileDestFactory("./output.txt"));
        logger.log(message);

    }
}
