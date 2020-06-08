package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void shouldMatchAuthor() {
        Book book = new Book(1, "War and Peace", 250, "Leo Tolstoy");
        boolean actual = book.matches("Leo Tolstoy");
        assertTrue(actual);

    }

    @Test
    void shouldNotMatchAuthor() {
        Book book = new Book(1, "War and Peace", 250, "Leo Tolstoy");
        boolean actual = book.matches("Dostoevsky");
        assertFalse(actual);
    }

    @Test
    void shouldMatchName() {
        Book book = new Book(1, "War and Peace", 250, "Leo Tolstoy");
        boolean actual = book.matches("War and Peace");
        assertTrue(actual);
    }

    @Test
    void shouldNotMatchName() {
        Book book = new Book(1, "War and Peace", 250, "Leo Tolstoy");
        boolean actual = book.matches("House");
        assertFalse(actual);
    }
}