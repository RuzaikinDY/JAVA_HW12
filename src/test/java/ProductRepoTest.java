import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.repositories.ProductRepo;
import ru.netology.products.Book;
import ru.netology.products.Product;
import ru.netology.products.Smartphone;


public class ProductRepoTest {
    ProductRepo repo = new ProductRepo();
    Product book1 = new Book(1, "Battle Tech", 75, "Kate");
    Product book2 = new Book(2, "Battle Tech 2", 90, "Kate");
    Product smartphone1 = new Smartphone(3, "7", 150, "Techno");
    Product smartphone2 = new Smartphone(4, "2", 250, "Techno");

    @Test
    public void testAdd() {


        repo.add(book1);
        repo.add(book2);
        repo.add(smartphone1);
        repo.add(smartphone2);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, smartphone1, smartphone2};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemove() {


        repo.add(book1);
        repo.add(book2);
        repo.add(smartphone1);
        repo.add(smartphone2);

        Product[] actual = repo.removeById(1);
        Product[] expected = {book2, smartphone1, smartphone2};
        Assertions.assertArrayEquals(expected, actual);
    }
}