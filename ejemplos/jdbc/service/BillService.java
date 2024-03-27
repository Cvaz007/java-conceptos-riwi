package jdbc.service;


import jdbc.entity.BillDetail;
import jdbc.model.BillDetailModel;

public class BillService {
    BillDetailModel billDetailModel;

    public BillService() {
        this.billDetailModel = new BillDetailModel();
    }

    public double calculateTotal(String billId) {
        double total=0;
        for (BillDetail billDetail : billDetailModel.findAllByBillId(billId)){
            total += billDetail.getSubtotal();
        }
        return total;
    }
}
