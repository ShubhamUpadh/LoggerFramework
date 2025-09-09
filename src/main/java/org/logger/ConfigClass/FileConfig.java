package org.logger.ConfigClass;

import org.logger.LogLevel;
import org.logger.OutputFormat;

public class FileConfig {
    private boolean enabled;
    private String fileName;
    private OutputFormat format;
    private LogLevel level;

    // getters and setters
    public boolean isEnabled() { return enabled; }
    public void setEnabled(boolean enabled) { this.enabled = enabled; }

    public String getFileName() { return fileName; }
    public void setFileName(String fileName) { this.fileName = fileName; }

    public OutputFormat getFormat() { return format; }
    public void setFormat(OutputFormat format) { this.format = format; }

    public LogLevel getLevel() { return level; }
    public void setLevel(LogLevel level) { this.level = level; }
}
