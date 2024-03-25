package poo.controller;

import poo.entity.Product;
import poo.model.ProductModel;

import java.util.Scanner;

public class ProductController {
    Scanner scanner;
    ProductModel model;

    public ProductController() {
        this.scanner = new Scanner(System.in);
        this.model = new ProductModel();
    }

    public void createProduct(){
        System.out.print("Product name: ");
        String name = scanner.next();
        System.out.print("Price: ");
        double price = scanner.nextDouble();
        System.out.print("Stock: ");
        int stock = scanner.nextInt();
        String id = String.valueOf(System.currentTimeMillis());

        Product product = new Product(name,price,stock,id);

        model.saveProduct(product);
    }

    public void updateProduct(){
        listAll();
        System.out.print("Type the product id that you want to update: ");
        String id = scanner.next();
        System.out.print("Product name: ");
        String name = scanner.next();
        System.out.print("Price: ");
        double price = scanner.nextDouble();
        System.out.print("Stock: ");
        int stock = scanner.nextInt();

        Product product = new Product(name,price,stock,id);

        model.updateProduct(product);
    }

    public void listAll(){
        for (Product product : model.findAll()){
            System.out.println(product.toString());
        }
    }

    public Product listById(){
        System.out.print("Type the product id that you see: ");
        String id = scanner.next();
        Product product = model.findById(id);
        System.out.println(product.toString());
        return product;
    }

    public void deleteProduct(){
        listAll();
        System.out.print("Type the product id that you want to delete: ");
        String id = scanner.next();

        model.deleteProduct(id);
    }
}
