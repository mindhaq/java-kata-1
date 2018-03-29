package org.echocat.kata.java.part1.reader;

import org.echocat.kata.java.part1.model.Magazine;

import static org.echocat.kata.java.part1.reader.EntityConstructor.parseAuthors;

/**
 * @author Rüdiger Schulz &lt;rs@mindhaq.com&gt;
 */
public class MagazineConstructor implements EntityConstructor<Magazine> {
    @Override
    public Magazine apply(String[] parts) {
        return Magazine
                .builder()
                .title(parts[0])
                .isbn(parts[1])
                .authors(parseAuthors(parts[2]))
                .publishedAt(parts[3])
                .build();
    }
}
