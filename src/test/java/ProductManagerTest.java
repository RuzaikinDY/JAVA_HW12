import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.repositories.ProductRepo;
import ru.netology.managers.ProductManager;
import ru.netology.products.Book;
import ru.netology.products.Product;
import ru.netology.products.Smartphone;

class ProductManagerTest {
    private ProductRepo repo = new ProductRepo();
    private ProductManager manager = new ProductManager(repo);
    Product book1 = new Book(1, "Battle Tech", 75, "Kate");
    Product book2 = new Book(2, "Battle Tech 2", 90, "Kate");
    Product smartphone1 = new Smartphone(3, "7", 150, "Techno");
    Product smartphone2 = new Smartphone(4, "2", 250, "Techno");

    @Test
    public void testAdd() {


        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, smartphone1, smartphone2};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFind2Elements() {


        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] actual = manager.searchBy("Battle");
        Product[] expected = {book1, book2};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFind1Element() {


        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] actual = manager.searchBy("7");
        Product[] expected = {smartphone1};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindUnknown() {


        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] actual = manager.searchBy("aaasssaa");
        Product[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFind0Because0Added() {


        Product[] actual = manager.searchBy("Battle");
        Product[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }
}