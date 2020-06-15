package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    Smartphone smartphone = new Smartphone(4, "Galaxy S20", 60000, "Samasung");

    @Test
    void shouldMatchManufacturer() {
        boolean actual = smartphone.matches("Samasung");
        assertTrue(actual);
    }

    @Test
    void shouldNotMatchManufacturer() {
        boolean actual = smartphone.matches("Nokia");
        assertFalse(actual);
    }

    @Test
    void shouldMatchName() {
        boolean actual = smartphone.matches("Galaxy S20");
        assertTrue(actual);
    }

    @Test
    void shouldNotMatchName() {
        boolean actual = smartphone.matches("510");
        assertFalse(actual);
    }
}
