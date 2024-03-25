package poo.controller;

import poo.entity.Bill;
import poo.entity.Product;
import poo.model.BillModel;
import poo.model.ProductModel;
import poo.service.BillService;
import poo.service.ProductService;

import java.util.ArrayList;
import java.util.Scanner;

public class BillController {
    Scanner scanner;
    BillModel model;
    BillService service;

    public BillController() {
        this.scanner = new Scanner(System.in);
        this.model = new BillModel();
        this.service = new BillService();
    }

    public void createBill() {
        System.out.print("User name: ");
        String userName = scanner.next();
        String id = String.valueOf(System.currentTimeMillis());
        ArrayList<Product> products = (ArrayList<Product>) service.addProducts();
        double total = service.calculateTotal(products);

        Bill newBill = new Bill(id, products, total, userName);
        model.saveBill(newBill);
    }
    public void listbills(){
        for(Bill bill : model.findAll()){
            System.out.println(bill.toString());
        }
    }

    public void listBillById() {
        listbills();
        System.out.print("Product id: ");
        String id = scanner.next();

        System.out.println(model.findById(id).toString());
    }

    public void deleteBill() {
        listbills();
        System.out.print("Product id: ");
        String id = scanner.next();

        model.deleteBill(id);

    }
}
