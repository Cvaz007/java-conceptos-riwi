package jdbc.controller;

import jdbc.entity.Product;
import jdbc.model.ProductModel;

import java.util.Scanner;

public class ProductController {
    Scanner scanner;
    ProductModel model;

    public ProductController() {
        this.scanner = new Scanner(System.in);
        this.model = new ProductModel();
    }

    public void addProduct() {
        System.out.print("Product name: ");
        String name = scanner.next();
        System.out.print("Price: ");
        double price = scanner.nextDouble();
        String id = String.valueOf(System.currentTimeMillis());

        Product product = new Product(id,name,price);

        model.saveProduct(product);
    }

    public void updateProduct() {
        System.out.print("Product name: ");
        String name = scanner.next();
        System.out.print("Price: ");
        double price = scanner.nextDouble();

        Product product = new Product(name, price);

        model.updateProduct(product);
    }

    public void deleteProduct() {
        System.out.print("Product id: ");
        String id = scanner.next();

        model.deleteProduct(id);
    }

    public Product listProductById() {
        System.out.print("Product id: ");
        String id = scanner.next();

        Product product = model.findById(id);

        System.out.println(product.toString());
        return  product;
    }

    public void listProduct() {
        for (Product product : model.findAll()){
            System.out.println(product.toString());
        }
    }
}
