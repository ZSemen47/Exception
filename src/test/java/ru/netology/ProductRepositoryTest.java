package ru.netology;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;
import ru.netology.exception.NotFoundException;
import ru.netology.repository.ProductRepository;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();

    private Product item1 = new Book(1, "The Lord of the Rings: The Fellowship of the Ring", 1000, "J. R. R. Tolkien");
    private Product item2 = new Book(2, "The Lord of the Rings: The Two Towers", 1100, "J. R. R. Tolkien");
    private Product item3 = new TShirt(3, "Viking", 100, "Abibas");
    private Product item4 = new TShirt(4, "King", 200, "Reepok");

    @BeforeEach
    void setUp(){
        repository.save(item1);
        repository.save(item2);
        repository.save(item3);
        repository.save(item4);
    }

    @Test
    void shouldRemoveIfExist() {
        repository.removeById(1);
        Product[] actual = repository.findAll();
        Product[] expected = {
                item2,
                item3,
                item4
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveIfNotExist(){
        assertThrows(NotFoundException.class, () -> repository.removeById(42));
    }
}