package LoggingFramework.LogLevel;

public class InfoLogLevelFactory extends LogLevelFactory{
    @Override
    public LogLevel createLogLevel() {
        return new InfoLogLevel();
    }
}
