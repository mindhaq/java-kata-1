package org.echocat.kata.java.part1;

import org.echocat.kata.java.part1.model.Author;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class MainAppUnitTest {

    private final MainApp mainApp = new MainApp();

    public MainAppUnitTest() throws IOException {
    }

    @Test
    public void main_database_contains_all_authors() {
        Map<String, Author> authorMap = mainApp.getDatabase().getAuthorMap();

        assertThat(authorMap).hasSize(6);
    }

}
