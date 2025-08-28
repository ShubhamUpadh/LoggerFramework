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
        LogMessage logMessage = new LogMessage(logLevel, message, className);
        System.out.println(logMessage.toString());
        logMessageList.add(logMessage);
    }

}