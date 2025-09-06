package org.logger;

import java.util.ArrayList;
import java.util.List;

public class Logger {
    private final String className;
    private final List<LogMessage> logMessageList = new ArrayList<>();
    private FileAppender fileAppender = null;
    private final LogLevel setLogLevel = LogLevel.INFO;
    private Redacter redacter = null;
    private final ConfigLoader configLoader = new ConfigLoader();
    private final LogQueue logQueue = new LogQueue(100);


    public Logger(String simpleName) {
        this.className = simpleName;
    }

    public void log(LogLevel logLevel, String message){
        try {

            if (!logQueue.isAvailableForDebugInfo() && logLevel.getPrecedence() > LogLevel.WARN.getPrecedence()){
                return;
            }

            if (configLoader.isRedactionEnabled()){
                this.redacter = new Redacter(configLoader.getRedactionPatterns());
                message = redacter.mask(message);
            }

            LogMessage logMessage = new LogMessage(logLevel, message, className, Thread.currentThread().getName());

            logQueue.addLog(logMessage);
            printLogMessage(logMessage);
            logMessageList.add(logMessage); // add logMessage to the list irrespective of logLevel

            if (fileAppender != null){
                fileAppender.append(logMessage, setLogLevel);
            }

        } catch (Exception e) {
            System.err.println("Logging error : " + e.getMessage());
        }
    }

    private void printLogMessage(LogMessage logMessage){
        if (logMessage.getLogLevel().getPrecedence() <= setLogLevel.getPrecedence()) {
            System.out.println(logMessage);
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

//    public void setRedacter(String regex){
//        this.redacter = new Redacter(regex);
//    }

}