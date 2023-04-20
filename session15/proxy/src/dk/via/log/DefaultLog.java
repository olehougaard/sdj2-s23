package dk.via.log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DefaultLog {
    private final CurrentTime currentTime;
    private final File logDirectory;

    private static DefaultLog instance;

    private DefaultLog() {
        String homePath = System.getProperty("user.home");
        // Default download dir on Windows. (~/Downloads on other systems).
        logDirectory = new File(homePath, "Downloads");
        currentTime = CurrentTime.getInstance();
    }

    public static DefaultLog getInstance() {
        if (instance == null) {
            synchronized(DefaultLog.class) {
                if (instance == null) {
                    instance = new DefaultLog();
                }
            }
        }
        return instance;
    }

    private File getLogFile() {
        String fileName = "Log-" + currentTime.getFormattedIsoDate() + ".txt";
        return new File(logDirectory, fileName);
    }

    public void log(String message) throws IOException {
        try (FileWriter fileWriter = new FileWriter(getLogFile(), true);
             PrintWriter writer = new PrintWriter(fileWriter)) {
            String logLine = currentTime.getFormattedTime() + " - " + message;
            writer.println(logLine);
        }
    }
}
