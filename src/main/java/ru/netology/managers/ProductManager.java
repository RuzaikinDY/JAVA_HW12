package ru.netology.managers;

import ru.netology.products.Product;
import ru.netology.repositories.ProductRepo;


public class ProductManager {
    private ProductRepo repo;

    public ProductManager() {
    }

    public ProductManager(ProductRepo repo) {
        this.repo = repo;
    }


    public void add(Product item) {
        repo.add(item);
    }


    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repo.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}