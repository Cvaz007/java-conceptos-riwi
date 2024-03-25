package poo.controller;

import poo.entity.Product;
import poo.model.ProductModel;
import poo.service.ProductService;

import java.util.Scanner;

public class ProductController {
    Scanner scanner;
    ProductService service;
    ProductModel model;

    public ProductController() {
        this.scanner = new Scanner(System.in);
        this.service = new ProductService();
        this.model = new ProductModel();
    }

    public ProductController(boolean isProduct) {
    }

    public void addProduct() {
        System.out.print("Product name: ");
        String name = scanner.next();
        System.out.print("Price: ");
        double price = scanner.nextDouble();
        System.out.print("Stock: ");
        int stock = scanner.nextInt();
        String id = String.valueOf(System.currentTimeMillis());

        Product product = new Product(name, price, stock, id);
        product = service.createProductType(product);

        model.saveProduct(product);
    }

    public void updateProduct() {
        System.out.print("Product name: ");
        String name = scanner.next();
        System.out.print("Price: ");
        double price = scanner.nextDouble();
        System.out.print("Stock: ");
        int stock = scanner.nextInt();
        System.out.print("Product id: ");
        String id = scanner.next();

        Product product = new Product(name, price, stock, id);

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
