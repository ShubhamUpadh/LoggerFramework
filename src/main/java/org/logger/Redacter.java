package org.logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Redacter {
    private Pattern pattern;
    public Redacter(String regex){
        this.pattern = Pattern.compile(regex);
    }
    public String mask(String message){
        Matcher matcher = pattern.matcher(message);
        StringBuilder result = new StringBuilder();

        while (matcher.find()) {
            String sensitive = matcher.group(1); // the captured group
            String masked = "*".repeat(sensitive.length());
            matcher.appendReplacement(result, matcher.group(0).replace(sensitive, masked));
        }

        matcher.appendTail(result);
        return result.toString();
    }

    public void setRegex(String regex) {
        this.pattern = Pattern.compile(regex);
    }
}
