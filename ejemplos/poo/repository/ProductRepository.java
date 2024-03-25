package poo.repository;

import poo.entity.Bill;
import poo.entity.Product;

import java.util.List;

public interface ProductRepository {
    void saveProduct(Product product);
    Product findById(String id);
    List<Product> findAll();
    void updateProduct(Product product);
    void deleteProduct(String id);
}
