import ru.netology.managers.ProductManager;
import ru.netology.products.Book;
import ru.netology.products.Product;
import ru.netology.products.Smartphone;
import ru.netology.repositories.ProductRepo;

public class Main {
    public static void main(String[] args) {
        ProductRepo repo = new ProductRepo();
        ProductManager manager = new ProductManager(repo);

        manager.add(new Book(1, "Battle Tech", 75, "Kate"));
        manager.add(new Book(2, "Battle Tech 2", 90, "Kate"));
        manager.add(new Smartphone(3, "7", 150, "Techno"));
        manager.add(new Smartphone(4, "2", 250, "Techno"));

        Product[] result = manager.searchBy("Battle");
    }
}