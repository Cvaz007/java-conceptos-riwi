package jdbc.service;

import jdbc.controller.BillDetailController;
import jdbc.controller.ProductController;
import jdbc.entity.Bill;
import jdbc.entity.BillDetail;
import jdbc.model.BillDetailModel;
import jdbc.model.BillModel;

import java.util.List;
import java.util.Scanner;

public class BillService {
    BillModel billModel;

    Scanner scanner;
    BillDetailModel billDetailModel;
    ProductController productController;
    BillDetailController billDetailController;

    public BillService() {
        this.billModel = new BillModel();
        this.billDetailModel = new BillDetailModel();
        this.productController = new ProductController();
        this.scanner = new Scanner(System.in);
        this.billDetailController = new BillDetailController();
    }

    public Bill calculateBillTotal(String billId){

        List<BillDetail> billDetailsList = billDetailModel.findAllByBillId(billId);
        double total = 0;

        for (BillDetail billDetail : billDetailsList){
            total += billDetail.getSubtotal();
        }

        Bill bill = billModel.findById(billId);
        bill.setTotal(total);

        return bill;
    }

    public void saveProduct(String billId){
        int flag = 1;
        while (flag != 0){
            productController.listProducts();
            System.out.print("Which product do you want to add?: ");
            String productId = scanner.next();

            billDetailController.createBillDetail(billId,productId);

            System.out.println("""
                                1. Add more.
                                0. Exit.
                                """);
            flag = scanner.nextInt();
        }
    }
}
