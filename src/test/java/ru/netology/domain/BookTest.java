package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    private Book book = new Book(1, "War and Peace", 250, "Leo Tolstoy");

    @Test
    void shouldMatchAuthor() {
        boolean actual = book.matches("Leo Tolstoy");
        assertTrue(actual);

    }

    @Test
    void shouldNotMatchAuthor() {
        boolean actual = book.matches("Dostoevsky");
        assertFalse(actual);
    }

    @Test
    void shouldMatchName() {
        boolean actual = book.matches("War and Peace");
        assertTrue(actual);
    }

    @Test
    void shouldNotMatchName() {
        boolean actual = book.matches("House");
        assertFalse(actual);
    }
}