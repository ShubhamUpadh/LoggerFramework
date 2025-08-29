package org.logger;

import java.util.ArrayList;
import java.util.List;

public class Logger {
    private final String className;
    private List<LogMessage> logMessageList = new ArrayList<>();

    public Logger(String simpleName) {
        this.className = simpleName;
    }

    public void log(LogLevel logLevel, String message){
        try {
            LogMessage logMessage = new LogMessage(logLevel, message, className, Thread.currentThread().getName(), true);
            System.out.println(logMessage);
            logMessageList.add(logMessage);
        } catch (Exception e) {
            System.err.println("Logging error : " + e.getMessage());
        }
    }

    public void info(String message){
        log(LogLevel.INFO, message);
    }

    public void debug(String message){
        log(LogLevel.DEBUG, message);
    }

    public void warn(String message){
        log(LogLevel.WARN, message);
    }

    public void err(String message){
        log(LogLevel.ERROR, message);
    }
}