package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    private Product book1 = new Book(14, "Great Book", 156, "Richard Ow");
    private Product book2 = new Book(32, "Math", 999, "Smart Man");
    private Product smartphone1 = new Smartphone(678123, "Honor 10", 29990, "Huawei");
    private Product smartphone2 = new Smartphone(8912333, "Al202", 14500, "Samsung");
    private Product smartphone3 = new Smartphone(0007, "7610", 2990, "Samsung");
    private Product product1 = new Product(1, "Noname", 1000);

    @BeforeEach
    void SetUp() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(product1);
    }

    @Test
    public void shouldGetAll() {
        Product[] expected = new Product[]{book1, book2, smartphone1, smartphone2, smartphone3, product1};
        Product[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchOneBookByAuthor() {
        Product[] expected = new Product[]{book1};
        Product[] actual = manager.searchBy("richard ow");
        assertArrayEquals(expected, actual);

    }


    @Test
    public void shouldSearchOneBookByName() {
        Product[] expected = new Product[]{book1};
        Product[] actual = manager.searchBy("great book");
        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldSearchOneSmartphoneByName() {
        Product[] expected = new Product[]{smartphone3};
        Product[] actual = manager.searchBy("7610");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchOneSmartphoneByManufacturer() {
        Product[] expected = new Product[]{smartphone1};
        Product[] actual = manager.searchBy("Huawei");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSomeSmartphoneByManufacturer() {
        Product[] expected = new Product[]{smartphone2, smartphone3};
        Product[] actual = manager.searchBy("Samsung");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnNothingIfNotFound() {
        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy("Art");
        assertArrayEquals(expected, actual);
    }
}