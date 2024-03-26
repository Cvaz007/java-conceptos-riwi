package jdbc.repository;

import jdbc.entity.Product;

import java.util.List;

public interface ProductRepository {
    void saveProduct(Product product);

    Product findById(String id);

    List<Product> findAll();

    void updateProduct(Product product);

    void deleteProduct(String id);
}
