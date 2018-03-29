package org.echocat.kata.java.part1;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

/**
 * @author Rüdiger Schulz &lt;rs@mindhaq.com&gt;
 */
@Data
@Builder
public class Magazine {
    private String title;
    private Set<String> authors;
    private String publishedAt;
    private String isbn;
}
