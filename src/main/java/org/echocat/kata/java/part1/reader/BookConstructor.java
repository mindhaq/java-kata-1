package org.echocat.kata.java.part1.reader;

import org.echocat.kata.java.part1.model.Book;

import static org.echocat.kata.java.part1.reader.EntityConstructor.parseAuthors;

/**
 * @author Rüdiger Schulz &lt;rs@mindhaq.com&gt;
 */
public class BookConstructor implements EntityConstructor<Book> {
    @Override
    public Book apply(String[] parts) {
        return Book
                .builder()
                .title(parts[0])
                .isbn(parts[1])
                .authors(parseAuthors(parts[2]))
                .description(parts[3])
                .build();
    }

}
