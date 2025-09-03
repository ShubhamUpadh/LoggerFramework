package org.logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Redacter {
    private List<Pattern> patterns = new ArrayList<>();
    public Redacter(List<String> regexps){
        for (String regex : regexps) {
            this.patterns.add(Pattern.compile(regex));
        }
    }
    public String mask(String message){
        String result = message;

        for (Pattern pattern : patterns) {
            Matcher matcher = pattern.matcher(result);
            StringBuffer buffer = new StringBuffer();
            while (matcher.find()) {
                String sensitive = matcher.group(1); // the captured group
                String masked = "*".repeat(sensitive.length());
                matcher.appendReplacement(buffer, matcher.group(0).replace(sensitive, masked));
            }

            matcher.appendTail(buffer);
            result = buffer.toString();
        }
        return result;
    }

    public void setRegex(List<String > regexList) {
        for (String regex : regexList) {
            this.patterns.add(Pattern.compile(regex));
        }
    }
}
