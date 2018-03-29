package org.echocat.kata.java.part1.reader;

import org.echocat.kata.java.part1.model.Author;

/**
 * @author Rüdiger Schulz &lt;rs@mindhaq.com&gt;
 */
public class AuthorConstructor implements EntityConstructor<Author> {
    @Override
    public Author createFrom(String[] parts) {
        return Author
                .builder()
                .email(parts[0])
                .firstName(parts[1])
                .lastName(parts[2])
                .build();
    }
}
