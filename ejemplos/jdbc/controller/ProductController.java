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

    public void saveProduct(){
        System.out.print("Type id product: ");
        String id = scanner.next();
        System.out.print("Type product name: ");
        String customer =  scanner.next();;
        System.out.print("Type price product: ");
        double price = scanner.nextDouble();

        Product product = new Product(id,customer,price);

        model.saveProduct(product);
    }

    public void deleteProduct(){
        System.out.print("Type id product: ");
        String id = scanner.next();

        model.deleteProduct(id);
    }

    public void updateProduct(){
        System.out.print("Type id product: ");
        String id = scanner.next();
        System.out.print("Type customer name: ");
        String customer =  scanner.next();;
        System.out.print("Type price product: ");
        double price = scanner.nextDouble();

        Product product = new Product(id,customer,price);

        model.updateProduct(product);
    }

    public void listProducts(){
        for (Product product : model.findAll()){
            System.out.println(product.toString());
        }
    }

    public void listProductById(){
        System.out.print("Type id product: ");
        String id = scanner.next();

        Product product = model.findById(id);

        System.out.println(product.toString());

    }


}
