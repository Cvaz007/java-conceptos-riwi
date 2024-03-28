package jdbc.repository;

import jdbc.entity.BillDetail;

import java.util.List;

public interface BillDetailRepository {
    void saveBillDetail(BillDetail billDetail);

    void deleteBillDetail(String id);

    void updateBillDetail(BillDetail billDetail);

    BillDetail findById(String id);

    List<BillDetail> findAll();
}
