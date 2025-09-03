package org.logger;

import java.time.LocalDate;

public class LogMessage {

    private final LogLevel logLevel;
    private final String message;
    private final LocalDate timeStamp;
    private final String className;
    private final String threadName;

    public LogMessage(LogLevel logLevel, String message, String className, String threadName) {
        this.logLevel = logLevel;
        this.message = message;
        this.timeStamp = LocalDate.now();
        this.className = className;
        this.threadName = threadName;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    @Override
    public String toString() {
        return timeStamp + " - [" + threadName + "] [" + logLevel + "] " + className + " : " + message;
    }

    public String toJson() {
        return String.format(
                "{\"timeStamp\":\"%s\", \"thread\":\"%s\", \"level\":\"%s\", \"class\":\"%s\", \"message\":\"%s\"}",
                timeStamp, threadName, logLevel, className, message
        );
    }
}