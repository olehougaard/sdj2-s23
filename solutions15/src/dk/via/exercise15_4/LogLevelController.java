package dk.via.exercise15_4;

public class LogLevelController implements Logger {
    private final String logLevel;
    private final Logger logger;

    public LogLevelController(String logLevel, Logger logger) {
        this.logLevel = logLevel;
        this.logger = logger;
    }

    public void log(String txt) {
        if ("verbose".equals(logLevel) || txt.toLowerCase().contains("error")) {
            logger.log(txt);
        }
    }
}
