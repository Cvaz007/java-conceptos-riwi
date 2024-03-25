package poo.model;

import poo.entity.Bill;
import poo.repository.BillRepository;

import java.util.ArrayList;
import java.util.List;

public class BillModel implements BillRepository {
    static List<Bill> bills = new ArrayList<Bill>();

    @Override
    public void saveBill(Bill bill) {
        bills.add(bill);
    }

    @Override
    public Bill findById(String id) {
        for (Bill bill : bills) {
            if(bill.getId().equals(id)){
                return bill;
            }
        }
        return null;
    }

    @Override
    public List<Bill> findAll() {
        return bills;
    }

    @Override
    public void deleteBill(String id) {
        bills.remove(findById(id));
    }
}
