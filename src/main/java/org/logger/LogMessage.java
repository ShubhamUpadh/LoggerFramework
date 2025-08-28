package org.logger;

import java.time.LocalDate;

public class LogMessage {

    private final LogLevel logLevel;
    private final String message;
    private final LocalDate timeStamp;
    private final String className;

    public LogMessage(LogLevel logLevel, String message, String className) {
        this.logLevel = logLevel;
        this.message = message;
        this.timeStamp = LocalDate.now();
        this.className = className;
    }

    @Override
    public String toString() {
        return timeStamp + " - [" + logLevel +"] [" + className + "] : " + message;
    }
}