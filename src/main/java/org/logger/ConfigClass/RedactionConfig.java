package org.logger.ConfigClass;

import java.util.List;

public class RedactionConfig {
    private boolean enabled;
    private List<String> fields;
    private List<String> patterns;

    // getters and setters
    public boolean isEnabled() { return enabled; }
    public void setEnabled(boolean enabled) { this.enabled = enabled; }

    public List<String> getFields() { return fields; }
    public void setFields(List<String> fields) { this.fields = fields; }

    public List<String> getPatterns() { return patterns; }
    public void setPatterns(List<String> patterns) { this.patterns = patterns; }
}
