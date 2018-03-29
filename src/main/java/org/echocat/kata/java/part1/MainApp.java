package org.echocat.kata.java.part1;

import org.echocat.kata.java.part1.model.Author;
import org.echocat.kata.java.part1.reader.AuthorConstructor;
import org.echocat.kata.java.part1.reader.CsvLineSplitter;
import org.echocat.kata.java.part1.reader.EntityConstructor;
import org.echocat.kata.java.part1.reader.LineReader;

import java.io.IOException;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;

import static java.util.stream.Collectors.toMap;

@SuppressWarnings("UseOfSystemOutOrSystemErr")
public class MainApp {

    public static final CsvLineSplitter CSV_LINE_SPLITTER = new CsvLineSplitter(";");

    public static void main(String[] args) throws IOException {
        MainApp mainApp = new MainApp();


    }

    private final Database database = new Database();

    public MainApp() throws IOException {
        database.setAuthorMap(readAuthors());
    }

    private Map<String, Author> readAuthors() throws IOException {

        return readEntities(
                "authors.csv",
                new AuthorConstructor(),
                toMap(Author::getEmail, Function.identity())
        );
    }

    private <E, C> C readEntities(
            String fileName,
            EntityConstructor<E> constructor,
            Collector<E, ?, C> collector) throws IOException {
        return new LineReader(fileName)
                .read()
                .map(CSV_LINE_SPLITTER)
                .map(constructor)
                .collect(collector);
    }

    public Database getDatabase() {
        return database;
    }
}
