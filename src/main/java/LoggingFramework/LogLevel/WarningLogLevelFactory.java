package LoggingFramework.LogLevel;

public class WarningLogLevelFactory extends LogLevelFactory{
    @Override
    public LogLevel createLogLevel() {
        return new WarningLogLevel();
    }
}
