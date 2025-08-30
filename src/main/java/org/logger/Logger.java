package org.logger;

import java.util.ArrayList;
import java.util.List;

public class Logger {
    private final String className;
    private final List<LogMessage> logMessageList = new ArrayList<>();
    private FileAppender fileAppender = null;

    public Logger(String simpleName) {
        this.className = simpleName;
    }

    public void log(LogLevel logLevel, String message){
        try {
            LogMessage logMessage = new LogMessage(logLevel, message, className, Thread.currentThread().getName());
            System.out.println(logMessage);
            logMessageList.add(logMessage);

            if (fileAppender != null){
                fileAppender.append(logMessage);
            }

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

    public void setTargetFile(String fileName){
        this.fileAppender = new FileAppender(fileName);
    }

    public void setTargetFile(String fileName, OutputFormat outputFormat){
        this.fileAppender = new FileAppender(fileName, outputFormat);
    }


//    public void

}