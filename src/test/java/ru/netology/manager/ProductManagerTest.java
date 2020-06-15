package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    private Product productOne = new Book(1, "War and Peace", 250, "Leo Tolstoy");
    private Product productTwo = new Book(2, "The Colour of Magic", 200, "Terry Pratchett");
    private Product productThree = new Smartphone(3, "510", 7000, "Motorolla");
    private Product productFour = new Smartphone(4, "Galaxy S20", 60000, "Samasung");

    @BeforeEach
    public void setUp() {
        manager.add(productOne);
        manager.add(productTwo);
        manager.add(productThree);
        manager.add(productFour);
    }

    @Test
    void shouldSearchByAuthor() {
        Product[] expected = new Product[]{productOne};
        Product[] actual = manager.searchBy("Leo Tolstoy");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByBookName() {
        Product[] expected = new Product[]{productTwo};
        Product[] actual = manager.searchBy("The Colour of Magic");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBySmarthoneName() {
        Product[] expected = new Product[]{productFour};
        Product[] actual = manager.searchBy("Galaxy S20");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByManufacturer() {
        Product[] expected = new Product[]{productThree};
        Product[] actual = manager.searchBy("Motorolla");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotSearchManufacturer() {
        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy("Moto");
        assertArrayEquals(expected, actual);
    }
}
