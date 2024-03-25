package poo.model;

import poo.entity.Product;
import poo.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductModel implements ProductRepository {
    static List<Product> products = new ArrayList<Product>();

    @Override
    public void saveProduct(Product product) {
        products.add(product);
    }

    @Override
    public Product findById(String id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void updateProduct(Product product) {
        Product newProduct = findById(product.getId());
        if (newProduct!= null) {
            newProduct.setName(product.getName());
            newProduct.setPrice(product.getPrice());
            newProduct.setStock(product.getStock());
        }
    }

    @Override
    public void deleteProduct(String id) {
        products.remove(findById(id));
    }
}
