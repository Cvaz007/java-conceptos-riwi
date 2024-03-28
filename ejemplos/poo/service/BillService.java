package poo.service;

import poo.controller.ProductController;
import poo.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BillService {
    Scanner scanner;
    ProductController controller;

    public BillService() {
        this.scanner = new Scanner(System.in);
        this.controller = new ProductController();
    }

    public List<Product> addProduct(){
        ArrayList<Product> products = new ArrayList<>();
        String flag = "yes";
        while (flag.equals("yes")){
            controller.listAll();
            products.add(controller.listById());
            System.out.print("Do you want to add other product? (yes-no): ");
            flag = scanner.next();
        }
        return products;
    }

    public double calculateTotal(ArrayList<Product> products){
        double total = 0;
        for (Product product : products){
            total += product.getPrice();
        }
        return total;
    }
}
