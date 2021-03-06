package org.echocat.kata.java.part1;

import lombok.Data;
import org.echocat.kata.java.part1.model.Author;
import org.echocat.kata.java.part1.model.Publication;

import java.util.Map;

/**
 * @author Rüdiger Schulz &lt;rs@mindhaq.com&gt;
 */
@Data
public class Database {

    private Map<String, Author> authorMap;

    private Map<String, Publication> publicationMap;
}
