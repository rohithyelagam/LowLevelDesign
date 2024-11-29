package LoggingFramework.LogLevel;

public class DebugLogLevelFactory extends LogLevelFactory{
    @Override
    public LogLevel createLogLevel() {
        return new DebugLogLevel();
    }
}
