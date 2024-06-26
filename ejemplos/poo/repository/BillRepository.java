package poo.repository;

import poo.entity.Bill;

import java.util.List;

public interface BillRepository {
    void saveBill(Bill bill);
    Bill findById(String id);
    List<Bill> findAll();
    void deleteBill(String id);
}
