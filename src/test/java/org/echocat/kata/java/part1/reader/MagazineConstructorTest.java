package org.echocat.kata.java.part1.reader;

import org.echocat.kata.java.part1.model.Magazine;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author Rüdiger Schulz &lt;rs@mindhaq.com&gt;
 */
public class MagazineConstructorTest {

    final MagazineConstructor magazineConstructor = new MagazineConstructor();

    @Test
    public void creates_book_from_strings() {
        // given
        String[] parts = new String[]{
                "Cooking for gourmets",
                "2365-5632-7854",
                "null-lieblich@echocat.org,null-walter@echocat.org",
                "01.05.2012"
        };

        // when
        Magazine magazine = magazineConstructor.createFrom(parts);

        // then
        assertThat(magazine.getTitle()).isEqualTo("Cooking for gourmets");
        assertThat(magazine.getIsbn()).isEqualTo("2365-5632-7854");
        assertThat(magazine.getAuthors()).containsExactlyInAnyOrder(
                "null-lieblich@echocat.org",
                "null-walter@echocat.org"
        );
        assertThat(magazine.getPublishedAt()).isEqualTo("01.05.2012");
    }
}
