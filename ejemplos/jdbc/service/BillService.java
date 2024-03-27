package jdbc.service;

import jdbc.entity.Bill;
import jdbc.entity.BillDetail;
import jdbc.model.BillDetailModel;
import jdbc.model.BillModel;

import java.util.List;

public class BillService {
    BillModel billModel;

    BillDetailModel billDetailModel;

    public BillService() {
        this.billModel = new BillModel();
        this.billDetailModel = new BillDetailModel();
    }

    public Bill updateBillTotal(String billId){

        List<BillDetail> billDetailsList = billDetailModel.findAllByBillId(billId);
        double total = 0;

        for (BillDetail billDetail : billDetailsList){
            total += billDetail.getSubtotal();
        }

        Bill bill = billModel.findById(billId);
        bill.setTotal(total);

        return bill;
    }
}
