package org.logger;

import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;

public class ConfigLoader {
    private final AppConfig config;

    public ConfigLoader() {
        Yaml yaml = new Yaml(new Constructor(AppConfig.class, new LoaderOptions())); // strongly typed
        String filePath = "config.yml";

        try (InputStream in = getClass().getClassLoader().getResourceAsStream(filePath)) {
            if (in == null) {
                throw new RuntimeException("Config file not found: " + filePath);
            }
            this.config = yaml.load(in);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config: " + e.getMessage(), e);
        }
    }

    public AppConfig getConfig() {
        return config;
    }
}
