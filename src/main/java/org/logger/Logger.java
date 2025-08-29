package org.logger;

import java.util.ArrayList;
import java.util.List;

public class Logger {
    private final String className;
    private ConcurrentL<LogMessage> logMessageList = new ArrayList<>();

    public Logger(String simpleName) {
        this.className = simpleName;
    }

    public void log(LogLevel logLevel, String message){
        try {
            LogMessage logMessage = new LogMessage(logLevel, message, className);
            System.out.println(logMessage);
            logMessageList.add(logMessage);
        } catch (Exception e) {
            System.err.println("Logging error : " + e.getMessage());
        }
    }

}