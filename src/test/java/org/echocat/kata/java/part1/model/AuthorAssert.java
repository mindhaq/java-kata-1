package org.echocat.kata.java.part1.model;

import org.assertj.core.api.AbstractAssert;

import java.util.Objects;

/**
 * @author Rüdiger Schulz &lt;rs@mindhaq.com&gt;
 */
public class AuthorAssert extends AbstractAssert<AuthorAssert, Author> {
    public AuthorAssert(Author actual) {
        super(actual, Author.class);
    }

    public static AuthorAssert assertThat(Author author) {
        return new AuthorAssert(author);
    }

    public AuthorAssert hasEmail(String email) {
        isNotNull();

        if (!Objects.equals(email, actual.getEmail())) {
            failWithMessage("Expected author to have email <%s> but was <%s>", email, actual.getEmail());
        }

        return this;
    }

    public AuthorAssert hasFirstName(String firstName) {
        isNotNull();

        if (!Objects.equals(firstName, actual.getFirstName())) {
            failWithMessage("Expected author to have firstName <%s> but was <%s>", firstName, actual.getFirstName());
        }

        return this;
    }

    public AuthorAssert haLastName(String lastName) {
        isNotNull();

        if (!Objects.equals(lastName, actual.getLastName())) {
            failWithMessage("Expected author to have lastName <%s> but was <%s>", lastName, actual.getLastName());
        }

        return this;
    }

}
