package org.logger;

import java.io.FileWriter;
import java.io.IOException;

public class FileAppender {
    private FileWriter fileWriter;
    private OutputFormat outputFormat = OutputFormat.STRING;

    public void setOutputFormat(OutputFormat outputFormat) {
        this.outputFormat = outputFormat;
    }

    public FileAppender(String fileName) {
        try{
            fileWriter = new FileWriter(fileName, true);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public FileAppender(String fileName, OutputFormat outputFormat) {
        try{
            fileWriter = new FileWriter(fileName, true);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        this.outputFormat = outputFormat;
    }

    public void append(LogMessage logMessage){
        try {
            if (outputFormat == OutputFormat.STRING) {
                fileWriter.write(logMessage.toString() + "\n");
                fileWriter.flush();
            }
            else{
                fileWriter.write(logMessage.toJson() + "\n");
                fileWriter.flush();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

}
