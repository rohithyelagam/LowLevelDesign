package LoggingFramework.LogLevel;

public class ErrorLogLevelFactory extends LogLevelFactory{
    @Override
    public LogLevel createLogLevel() {
        return new ErrorLogLevel();
    }
}
