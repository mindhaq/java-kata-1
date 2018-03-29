package org.echocat.kata.java.part1.reader;

import org.echocat.kata.java.part1.model.Author;
import org.junit.Test;

import static org.echocat.kata.java.part1.model.AuthorAssert.assertThat;


/**
 * @author Rüdiger Schulz &lt;rs@mindhaq.com&gt;
 */
public class AuthorConstructorTest {

    private final AuthorConstructor authorConstructor = new AuthorConstructor();

    @Test
    public void creates_author_from_strings() {
        // given
        String[] parts = new String[] {
                "null-walter@echocat.org",
                "Paul",
                "Walter"
        };

        // when
        Author author = authorConstructor.createFrom(parts);

        // then
        assertThat(author).isNotNull();
        assertThat(author).hasEmail("null-walter@echocat.org");
        assertThat(author).hasFirstName("Paul");
        assertThat(author).hasLastName("Walter");
    }
}
