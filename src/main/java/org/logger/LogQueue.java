package org.logger;

import java.util.ArrayDeque;
import java.util.Queue;

public class LogQueue {

    private Queue<LogMessage> logQueue;
    private int maxSize;
    private int currSize = 0;
    public LogQueue(int size) {
        this.maxSize = size;
        this.logQueue = new ArrayDeque<>();
    }

    public boolean isAvailableForDebugInfo(){
        return ((long)(maxSize - currSize) * 100 / maxSize) > 20L;
    }

    public void addLog(LogMessage message){
        if (currSize < maxSize) {
            logQueue.add(message);
            currSize++;
        }
    }

    public LogMessage popLog(){
        if (currSize > 0) {
            currSize--;
            return logQueue.poll();
        }
        return null;
    }

    public boolean isEmpty(){
        return this.logQueue.isEmpty();
    }


}
