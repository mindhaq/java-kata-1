package org.echocat.kata.java.part1;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Rüdiger Schulz &lt;rs@mindhaq.com&gt;
 */
public class CsvLineSplitterTest {

    private final CsvLineSplitter splitter = new CsvLineSplitter(";");

    @Test
    public void splits_thres_columns_into_three_strings() {
        // given
        String line = "null-walter@echocat.org;Paul;Walter";

        // when
        String[] strings = splitter.split(line);

        // then
        assertThat(strings).hasSize(3);
        assertThat(strings).containsExactly(
                "null-walter@echocat.org",
                "Paul",
                "Walter"
        );
    }
}
