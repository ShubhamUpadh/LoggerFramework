package org.logger;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class FileAppender {
    private BufferedWriter fileWriter;
    private OutputFormat outputFormat = OutputFormat.STRING;
    String fileSuffix = new SimpleDateFormat("MMMMdd_HH_mm").format(new Date());


    public void setOutputFormat(OutputFormat outputFormat) {
        this.outputFormat = outputFormat;
    }

    public FileAppender(String fileName) {
        try{
            Path logDir = Paths.get("logs");
            Files.createDirectories(logDir);
            Path logFile = logDir.resolve(fileNameDateTimeSuffixer(fileName));
            fileWriter = Files.newBufferedWriter(logFile, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public FileAppender(String fileName, OutputFormat outputFormat) {
        try{
            Path logDir = Paths.get("logs");
            Files.createDirectories(logDir);
            Path logFile = logDir.resolve(fileNameDateTimeSuffixer(fileName));
            fileWriter = Files.newBufferedWriter(logFile, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        this.outputFormat = outputFormat;
    }

    private String fileNameDateTimeSuffixer(String fileName) {
        String[] splitFileName = fileName.split("\\.");
        return splitFileName[0] + fileSuffix + "." + splitFileName[1];
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
