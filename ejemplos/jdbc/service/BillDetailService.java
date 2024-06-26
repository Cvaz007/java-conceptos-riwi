package jdbc.service;

import jdbc.entity.Product;
import jdbc.model.ProductModel;

public class BillDetailService {
    ProductModel model;

    public BillDetailService() {
        this.model = new ProductModel();
    }

    public double calculateSubtotal(String productId, int quantity) {

        Product product = model.findById(productId);

        //double subtotal = product.getPrice() * quantity;

        return  product.getPrice() * quantity;
    }
}
