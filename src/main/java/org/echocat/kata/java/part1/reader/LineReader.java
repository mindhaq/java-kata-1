package org.echocat.kata.java.part1.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author Rüdiger Schulz &lt;rs@mindhaq.com&gt;
 */
public class LineReader {

    private final String basePath = "src/main/resources/org/echocat/kata/java/part1/data/";
    private final Path path;

    public LineReader(String fileName) {
        path = Paths.get(basePath + fileName);
    }

    public Stream<String> read() throws IOException {
        return Files.lines(path).skip(1);
    }
}
