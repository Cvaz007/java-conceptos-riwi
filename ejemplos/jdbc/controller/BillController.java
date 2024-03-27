package jdbc.controller;

import jdbc.entity.Bill;
import jdbc.model.BillModel;
import jdbc.service.BillService;

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
        System.out.print("Type the customer name: ");
        String customer = scanner.next();
        double total = 0;
        String id = String.valueOf(System.currentTimeMillis());

        Bill newBill = new Bill(id, total, customer);
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
