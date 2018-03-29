package org.echocat.kata.java.part1.reader;

import org.echocat.kata.java.part1.model.Book;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author Rüdiger Schulz &lt;rs@mindhaq.com&gt;
 */
public class BookConstructorTest {

    final BookConstructor bookConstructor = new BookConstructor();

    @Test
    public void creates_book_from_strings() {
        // given
        String[] parts = new String[]{
                "Genial italienisch",
                "1024-5245-8584",
                "null-lieblich@echocat.org,null-walter@echocat.org,null-rabe@echocat.org",
                "Starkoch Jamie Oliver war mit seinem VW-Bus in Italien unterwegs."
        };

        // when
        Book book = bookConstructor.createFrom(parts);

        // then
        assertThat(book.getTitle()).isEqualTo("Genial italienisch");
        assertThat(book.getIsbn()).isEqualTo("1024-5245-8584");
        assertThat(book.getDescription()).isEqualTo("Starkoch Jamie Oliver war mit seinem VW-Bus in Italien unterwegs.");
        assertThat(book.getAuthors()).containsExactlyInAnyOrder(
                "null-lieblich@echocat.org",
                "null-walter@echocat.org",
                "null-rabe@echocat.org"
        );
    }
}
