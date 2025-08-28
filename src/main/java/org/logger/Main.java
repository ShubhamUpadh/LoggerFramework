package org.logger;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static final Logger logger = new Logger(Main.class.getSimpleName());
    public static void main(String[] args) {
        logger.log(LogLevel.INFO, "First Log");
        logger.log(LogLevel.INFO,"First log finished");
        for (int i = 1; i <= 5; i++) {
            logger.log(LogLevel.INFO,"This is the value " + i);
        }
    }
}