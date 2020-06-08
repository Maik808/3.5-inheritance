package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {

    @Test
    void shouldMatchManufacturer() {
        Smartphone smartphone = new Smartphone(4, "Galaxy S20", 60000, "Samasung");
        boolean actual = smartphone.matches("Samasung");
        assertTrue(actual);
    }

    @Test
    void shouldNotMatchManufacturer() {
        Smartphone smartphone = new Smartphone(4, "Galaxy S20", 60000, "Samasung");
        boolean actual = smartphone.matches("Nokia");
        assertFalse(actual);
    }

    @Test
    void shouldMatchName() {
        Smartphone smartphone = new Smartphone(4, "Galaxy S20", 60000, "Samasung");
        boolean actual = smartphone.matches("Galaxy S20");
        assertTrue(actual);
    }

    @Test
    void shouldNotMatchName() {
        Smartphone smartphone = new Smartphone(4, "Galaxy S20", 60000, "Samasung");
        boolean actual = smartphone.matches("510");
        assertFalse(actual);
    }
}
