package org.logger;

public class Main {
    static final Logger logger = new Logger(Main.class.getSimpleName());
    public static void main(String[] args) {
        logger.log(LogLevel.INFO, "First Log");
        logger.setTargetFile("targetFileString1.log");
        logger.log(LogLevel.INFO,"First log finished");
        for (int i = 1; i <= 5; i++) {
            logger.setTargetFile("targetFileJson1.log", OutputFormat.JSON);
            logger.log(LogLevel.INFO,"This is the value " + i);
        }
    }
}