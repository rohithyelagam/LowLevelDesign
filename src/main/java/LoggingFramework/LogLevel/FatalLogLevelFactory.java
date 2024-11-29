package LoggingFramework.LogLevel;

public class FatalLogLevelFactory extends LogLevelFactory{
    @Override
    public LogLevel createLogLevel() {
        return new FatalLogLevel();
    }
}
