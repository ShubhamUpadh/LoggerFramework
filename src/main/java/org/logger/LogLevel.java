package org.logger;

public enum LogLevel {
    INFO(4),
    DEBUG(3),
    WARN(2),
    ERROR(1),
    ;

    private final int precedence;

    LogLevel(int precedence) {
        this.precedence = precedence;
    }

    public int getPrecedence(){
        return this.precedence;
    }
}