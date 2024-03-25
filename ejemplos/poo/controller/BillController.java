package poo.controller;

import poo.model.BillModel;
import poo.entity.Product;
import poo.entity.Bill;
import poo.service.BillService;

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

        ArrayList<Product> products = (ArrayList<Product>) service.addProduct();

        double total = service.calculateTotal(products);

        Bill newBill = new Bill(id, products, total, userName);

        model.saveBill(newBill);
    }

    public void listBillById(){
        listBill();
        System.out.println("Product id: ");
        String id = scanner.next();

        System.out.println(model.findById(id).toString());
    }

    public void listBill(){
        for (Bill bill : model.findAll()){
            System.out.println(bill.toString());
        }
    }

    public void deleteBill(){
        listBill();
        System.out.println("Product id: ");
        String id = scanner.next();

        model.deleteBill(id);
    }
}
