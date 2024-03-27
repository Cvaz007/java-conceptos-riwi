package jdbc.controller;

import jdbc.entity.BillDetail;
import jdbc.model.BillDetailModel;
import jdbc.service.BillDetailService;

import java.util.Scanner;

public class BillDetailController {
    Scanner scanner;
    BillDetailModel model;
    BillDetailService service;

    public BillDetailController() {
        this.scanner = new Scanner(System.in);
        this.model = new BillDetailModel();
        this.service = new BillDetailService();
    }

    public void createBillDetail() {
        String id = String.valueOf(System.currentTimeMillis());
        System.out.print("Type product id: ");
        String productId = scanner.next();
        System.out.print("Type bill id: ");
        String billId = scanner.next();
        System.out.print("Type quantity: ");
        int quantity = scanner.nextInt();

        double subtotal = service.calculateSubtotal(productId,quantity);

        BillDetail billDetail = new BillDetail(id, productId, billId, quantity, subtotal);
        model.saveBillDetail(billDetail);
    }

    public void listBillDetails() {
        for (BillDetail billDetail : model.findAll()) {
            System.out.println(billDetail.toString());
        }
    }

    public void listBillDetailById() {
        listBillDetails();
        System.out.print("Product id: ");
        String id = scanner.next();

        System.out.println(model.findById(id).toString());
    }

    public void deleteBillDetail() {
        listBillDetails();
        System.out.print("Product id: ");
        String id = scanner.next();

        model.deleteBillDetail(id);
    }
}
