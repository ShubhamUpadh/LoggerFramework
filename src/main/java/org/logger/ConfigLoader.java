package org.logger;

import org.yaml.snakeyaml.Yaml;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class ConfigLoader {
    private final Map<String, Object> config;

    public ConfigLoader() {
        Yaml yaml = new Yaml();
        String filePath = "config.yml";
        try (InputStream in = getClass().getClassLoader().getResourceAsStream(filePath)) {
            if (in == null) {
                throw new RuntimeException("Config file not found: " + filePath);
            }
            config = yaml.load(in);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config: " + e.getMessage(), e);
        }
        System.out.println(config);
    }

    public Object get(String key) {
        return config.get(key);
    }

    public Map<String, Object> getAll() {
        return config;
    }

    @SuppressWarnings("unchecked")
    public boolean isRedactionEnabled() {
        Map<String, Object> redaction = (Map<String, Object>) config.get("redaction");
        return Boolean.TRUE.equals(redaction.get("enabled"));
    }

    @SuppressWarnings("unchecked")
    public List<String> getRedactionPatterns() {
        Map<String, Object> redaction = (Map<String, Object>) config.get("redaction");
        return (List<String>) redaction.get("patterns");
    }

    @SuppressWarnings("unchecked")
    public boolean isFileAppendEnabled(){
        Map<String, Object> file = (Map<String, Object>) config.get("file");
        return Boolean.TRUE.equals(file.get("enabled"));
    }

    @SuppressWarnings("unchecked")
    public String getFileName(){
        Map<String, Object> file = (Map<String, Object>) config.get("file");
        return (String) file.get("fileName");
    }

    @SuppressWarnings("unchecked")
    public LogLevel getFilterLevel(){
        Map<String, Object> file = (Map<String, Object>) config.get("file");
        return (LogLevel) file.get("level");
    }

    @SuppressWarnings("unchecked")
    public OutputFormat getOutputFormat(){
        Map<String, Object> file = (Map<String, Object>) config.get("file");
        return (OutputFormat) file.get("format");
    }


}
