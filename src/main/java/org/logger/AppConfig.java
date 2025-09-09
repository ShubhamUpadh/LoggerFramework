package org.logger;

import org.logger.ConfigClass.ConsoleConfig;
import org.logger.ConfigClass.FileConfig;
import org.logger.ConfigClass.RedactionConfig;

public class AppConfig {
    private FileConfig file;
    private ConsoleConfig console;
    private RedactionConfig redaction;

    // getters and setters
    public FileConfig getFile() { return file; }
    public void setFile(FileConfig file) { this.file = file; }

    public ConsoleConfig getConsole() { return console; }
    public void setConsole(ConsoleConfig console) { this.console = console; }

    public RedactionConfig getRedaction() { return redaction; }
    public void setRedaction(RedactionConfig redaction) { this.redaction = redaction; }
}

