package org.echocat.kata.java.part1.reader;

import java.util.Set;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.toSet;

/**
 * @author Rüdiger Schulz &lt;rs@mindhaq.com&gt;
 */
public interface EntityConstructor<E> {
    E createFrom(String[] parts);

    static Set<String> parseAuthors(String authors) {
        return Pattern
                .compile(",")
                .splitAsStream(authors)
                .collect(toSet());
    }
}
