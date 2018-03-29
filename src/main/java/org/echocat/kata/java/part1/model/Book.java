package org.echocat.kata.java.part1.model;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

/**
 * @author Rüdiger Schulz &lt;rs@mindhaq.com&gt;
 */
@Data
@Builder
public class Book implements IsbnLabeled, Titled {
    private String title;
    private String description;
    private Set<String> authors;
    private String isbn;
}
