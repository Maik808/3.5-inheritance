package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();

    private Product productOne = new Book(1, "War and Peace", 250, "Leo Tolstoy");
    private Product productTwo = new Book(2, "The Colour of Magic", 200, "Terry Pratchett");
    private Product productThree = new Smartphone(3, "510", 7000, "Motorolla");
    private Product productFour = new Smartphone(4, "Galaxy S20", 60000, "Samasung");

    private Product addItem = new Book(5, "Сrime and punishment", 550, "Dostoevsky");

    @BeforeEach
    public void setUp() {
        repository.save(productOne);
        repository.save(productTwo);
        repository.save(productThree);
        repository.save(productFour);
    }

    @Test
    void shouldSave() {
        repository.save(addItem);
        Product[] actual = repository.findAll();
        Product[] expected = {
                productOne,
                productTwo,
                productThree,
                productFour,
                addItem
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindId() {
        Product actual = repository.findById(1);
        Product expected = productOne;
        assertEquals(expected, actual);
    }

    @Test
    void shouldFindIdNotExist() {
        Product actual = repository.findById(52);
        assertNull(actual);
    }

    @Test
    void shouldRemoveId() {
        repository.removeById(1);
        Product[] actual = repository.findAll();
        Product[] expected = {
                productTwo,
                productThree,
                productFour
        };
        assertArrayEquals(expected, actual);
    }
}
