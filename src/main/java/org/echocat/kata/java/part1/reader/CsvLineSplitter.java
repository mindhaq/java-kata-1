package org.echocat.kata.java.part1.reader;

import java.util.function.Function;
import java.util.regex.Pattern;

/**
 * @author Rüdiger Schulz &lt;rs@mindhaq.com&gt;
 */
public class CsvLineSplitter implements Function<String, String[]> {

    private final Pattern pattern;

    public CsvLineSplitter(String splitPattern) {
        pattern = Pattern.compile(splitPattern);
    }

    public String[] apply(String line) {
        return pattern.split(line);
    }
}
