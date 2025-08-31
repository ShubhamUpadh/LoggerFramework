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

    @Override
    public String toString() {
        return timeStamp + " - [" + threadName + "] [" + logLevel + "] " + className + " : " + message;
    }

    public String toJson() {
        return String.format(
                "{\n\t\"timeStamp\":\"%s\",\n\t\"thread\":\"%s\",\n\t\"level\":\"%s\",\n\t\"class\":\"%s\",\n\t\"message\":\"%s\"\n}",
                timeStamp, threadName, logLevel, className, message
        );
    }
}