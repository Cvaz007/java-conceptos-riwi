package poo.service;

import poo.controller.ProductController;
import poo.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BillService {
    Scanner scanner;
    ProductController productController;

    public BillService() {
        this.scanner = new Scanner(System.in);
        this.productController = new ProductController();
    }

    public List<Product> addProducts() {

        ArrayList<Product> products = new ArrayList<Product>();
        String flag = "yes";
        while (flag.equalsIgnoreCase("yes")) {
            productController.listProduct();
            products.add(productController.listProductById());
            System.out.print("Do you want to add other product? (yes-no): ");
            flag = scanner.next();
        }
        return products;
    }

    public double calculateTotal(ArrayList<Product> products) {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }
}
