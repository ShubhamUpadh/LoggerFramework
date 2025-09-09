package org.logger;

public enum OutputFormat {
    STRING ("string"),
    JSON ("json"),
    ;

    private final String outputFormat;

    OutputFormat(String outputFormat) {
        this.outputFormat = outputFormat;
    }

    public String getOutputFormat() {
        return outputFormat;
    }
}
