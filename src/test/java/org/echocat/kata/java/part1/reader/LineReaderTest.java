package org.echocat.kata.java.part1.reader;

import org.junit.Test;

import java.io.IOException;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Rüdiger Schulz &lt;rs@mindhaq.com&gt;
 */
public class LineReaderTest {

    private final LineReader lineReader = new LineReader("authors.csv");

    @Test
    public void skips_first_line() throws IOException {
        Stream<String> lines = lineReader.read();

        assertThat(lines).startsWith("null-walter@echocat.org;Paul;Walter");
    }

    @Test
    public void streams_all_entries() throws IOException {
        Stream<String> lines = lineReader.read();

        assertThat(lines).hasSize(6);
    }
}
