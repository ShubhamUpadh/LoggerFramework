package org.logger;

public class Main {
    static final Logger logger = new Logger(Main.class.getSimpleName());
    public static void main(String[] args) {
        logger.log(LogLevel.INFO, "First Log");
        logger.setTargetFile("targetFileString.log");
        logger.log(LogLevel.INFO,"First log finished");
        for (int i = 1; i <= 5; i++) {
            logger.setTargetFile("targetFileJson.log", OutputFormat.JSON);
            logger.log(LogLevel.INFO,"This is the value " + i);
        }
    }
}