package org.echocat.kata.java.part1;

import org.echocat.kata.java.part1.model.Author;
import org.echocat.kata.java.part1.model.Book;
import org.echocat.kata.java.part1.model.Magazine;
import org.echocat.kata.java.part1.model.Publication;
import org.echocat.kata.java.part1.reader.AuthorConstructor;
import org.echocat.kata.java.part1.reader.BookConstructor;
import org.echocat.kata.java.part1.reader.CsvLineSplitter;
import org.echocat.kata.java.part1.reader.EntityConstructor;
import org.echocat.kata.java.part1.reader.LineReader;
import org.echocat.kata.java.part1.reader.MagazineConstructor;

import java.io.IOException;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

@SuppressWarnings("UseOfSystemOutOrSystemErr")
public class MainApp {

    public static final CsvLineSplitter CSV_LINE_SPLITTER = new CsvLineSplitter(";");

    public static void main(String[] args) throws IOException {
        MainApp mainApp = new MainApp();

        mainApp.getDatabase()
                .getPublicationMap()
                .values()
                .forEach(publication -> System.out.println(publication));
    }

    private final Database database = new Database();

    public MainApp() throws IOException {
        database.setAuthorMap(readAuthors());
        database.setPublicationMap(readPublications());
    }

    private Map<String, Author> readAuthors() throws IOException {
        return readEntitiesToCollection(
                "authors.csv",
                new AuthorConstructor(),
                toMap(Author::getEmail, Function.identity())
        );
    }

    private Map<String, Publication> readPublications() throws IOException {
        try (Stream<Publication> publicationStream = Stream.concat(
                streamBooks(), streamMagazines()
        )) {
            return
                    publicationStream
                            .collect(
                                    toMap(Publication::getIsbn, Function.identity())
                            );
        }
    }

    private Stream<Book> streamBooks() throws IOException {
        return streamEntities(
                "books.csv",
                new BookConstructor()
        );
    }

    private Stream<Magazine> streamMagazines() throws IOException {
        return streamEntities(
                "magazines.csv",
                new MagazineConstructor()
        );
    }

    private <E, C> C readEntitiesToCollection(
            String fileName,
            EntityConstructor<E> constructor,
            Collector<E, ?, C> collector) throws IOException {
        return streamEntities(fileName, constructor).collect(collector);
    }

    private <E> Stream<E> streamEntities(String fileName, EntityConstructor<E> constructor) throws IOException {
        return new LineReader(fileName)
                .read()
                .map(CSV_LINE_SPLITTER)
                .map(constructor);
    }

    public Database getDatabase() {
        return database;
    }
}
