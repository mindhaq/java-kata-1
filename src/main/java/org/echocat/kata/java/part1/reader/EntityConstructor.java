package org.echocat.kata.java.part1.reader;

import java.util.Set;
import java.util.function.Function;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.toSet;

/**
 * @author Rüdiger Schulz &lt;rs@mindhaq.com&gt;
 */
public interface EntityConstructor<E> extends Function<String[], E> {

    static Set<String> parseAuthors(String authors) {
        return Pattern
                .compile(",")
                .splitAsStream(authors)
                .collect(toSet());
    }
}
