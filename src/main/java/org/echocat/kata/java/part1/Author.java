package org.echocat.kata.java.part1;

import lombok.Builder;
import lombok.Data;

/**
 * @author Rüdiger Schulz &lt;rs@mindhaq.com&gt;
 */
@Data
@Builder
public class Author {
    private String email;
    private String firstname;
    private String lastname;
}
