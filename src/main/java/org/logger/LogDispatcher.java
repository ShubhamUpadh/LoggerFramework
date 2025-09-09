package org.logger;

public class LogDispatcher implements Runnable{

    private LogQueue logQueue;
    private volatile boolean running = true;
    private FileAppender fileAppender = null;
    private final ConfigLoader configLoader = new ConfigLoader();
    private final AppConfig appConfig = configLoader.getConfig();
    private LogLevel filterLogLevel = null;

    public LogDispatcher(LogQueue logQueue){
        this.logQueue = logQueue;
        if (appConfig.getFile().isEnabled()) {
            this.fileAppender = new FileAppender(appConfig.getFile().getFileName(), appConfig.getFile().getFormat());
            this.filterLogLevel = appConfig.getFile().getLevel();
        }
    }

    @Override
    public void run() {
        while (running){
            try{
                if (!logQueue.isEmpty()){
                    LogMessage logMessage = logQueue.popLog();
                    printLogMessage(logMessage);
                    if (fileAppender != null){
                        fileAppender.append(logMessage, filterLogLevel);
                    }
                }
            }
            catch (Exception e){
                throw new RuntimeException(e);
            }
        }
    }

    public void shutdown(){
        this.running = false;
    }

    private void printLogMessage(LogMessage logMessage) {
        try{
            System.out.println(logMessage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
