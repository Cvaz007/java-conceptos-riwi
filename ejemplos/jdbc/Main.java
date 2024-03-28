package jdbc;

import jdbc.configuration.ConfigurationDB;
import jdbc.controller.BillController;
import jdbc.controller.BillDetailController;
import jdbc.controller.ProductController;
import jdbc.entity.Bill;
import jdbc.service.BillService;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main objMain = new Main();
        Scanner scanner = new Scanner(System.in);
        ProductController productController = new ProductController();
        BillController billController = new BillController();
        BillDetailController billDetailController = new BillDetailController();
        BillService billService = new BillService();

        int option = -1;
        do {
            objMain.menu();
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    productController.saveProduct();
                    break;
                case 2:
                    productController.updateProduct();
                    break;
                case 3:
                    productController.listProductById();
                    break;
                case 4:
                    productController.deleteProduct();
                    break;
                case 5:
                    productController.listProducts();
                    break;
                case 6:
                    Bill bill = billController.createBill();
                    billService.saveProduct(bill.getId());
                    billController.updateTotal(bill.getId());
                    break;
                case 7:
                    billController.deleteBill();
                    break;
                case 8:
                    billController.listBillById();
                    break;
                case 9:
                    billController.listbills();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        } while (option != 0);
    }

    public void menu() {
        System.out.println("""
                ---- PRODUCT MENU ----
                1. CREATE PRODUCT
                2. UPDATE PRODUCT
                3. LIST PRODUCT BY ID
                4. DELETE PRODUCT
                5. LIST PRODUCTS
                                
                ---- BILL MENU ----
                6. CREATE BILL
                7. DELETE BILL
                8. LIST BILL BY ID
                9. LIST ALL BILLS
                                
                0. EXIT
                """);
    }

}
