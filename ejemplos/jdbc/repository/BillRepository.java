package jdbc.repository;

import jdbc.entity.Bill;

import java.util.List;

public interface BillRepository {
    Bill saveBill(Bill bill);
    Bill findById(String id);
    List<Bill> findAll();
    void deleteBill(String id);
    void updateBill(Bill bill);
}
