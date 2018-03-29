package org.echocat.kata.java.part1.reader;

/**
 * @author Rüdiger Schulz &lt;rs@mindhaq.com&gt;
 */
public interface EntityConstructor<E> {
    E createFrom(String[] parts);
}
