package jdbc.model;

import jdbc.connection.ConfigurationDB;
import jdbc.entity.BillDetail;
import jdbc.repository.BillDetailRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BillDetailModel implements BillDetailRepository {
    Connection objConnection;

    @Override
    public void saveBillDetail(BillDetail billDetail) {
        objConnection = ConfigurationDB.openConnection();
        try {
            String sql = "INSERT INTO billDetail (id,productId, billId, quantity, subtotal) VALUES (?,?,?,?,?);";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
            statement.setString(1, billDetail.getId());
            statement.setString(2, billDetail.getProductId());
            statement.setString(3, billDetail.getBillId());
            statement.setInt(4, billDetail.getQuantity());
            statement.setDouble(5, billDetail.getSubtotal());

            statement.execute();

            System.out.println("Bill details insertion completed successfully");

        } catch (SQLException e) {
            ConfigurationDB.closeConnection();
            throw new RuntimeException(e);
        }
        ConfigurationDB.closeConnection();
    }

    //Este metodo podria ser general, ya que si le enviamos por parametro la tabla y el id funciona universalmente
    @Override
    public void deleteBillDetail(String id) {
        objConnection = ConfigurationDB.openConnection();

        try {
            String sql = "DELETE FROM billDetail WHERE id = ?;";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
            statement.setString(1, id);

            statement.execute();
            System.out.println("The row was deleted successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateBillDetail(BillDetail billDetail) {
        objConnection = ConfigurationDB.openConnection();
        try {
            String sql = "UPDATE billDetail SET quantity = ?, subtotal = ?  WHERE (id = ?);";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
            statement.setInt(1, billDetail.getQuantity());
            statement.setDouble(2, billDetail.getSubtotal());
            statement.setString(3, billDetail.getId());

            statement.executeUpdate();

            System.out.println("Bill detail was update successfully");
        } catch (SQLException e) {
            ConfigurationDB.closeConnection();
            throw new RuntimeException(e);
        }
        ConfigurationDB.closeConnection();
    }

    @Override
    public BillDetail findById(String id) {
        objConnection = ConfigurationDB.openConnection();
        BillDetail billDetail;
        try {
            String sql = "SELECT * FROM BillDetail WHERE BillDetail.id = ?;";

            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();

            resultSet.next();

            String idBillDetail = resultSet.getString("id");
            String productId = resultSet.getString("productId");
            String billId = resultSet.getString("billId");
            int quantity = resultSet.getInt("quantity");
            double subtotal = resultSet.getDouble("subtotal");

            billDetail = new BillDetail(idBillDetail, productId, billId, quantity, subtotal);

        } catch (Exception e) {
            ConfigurationDB.closeConnection();
            throw new RuntimeException(e);
        }
        ConfigurationDB.closeConnection();
        return billDetail;
    }

    @Override
    public List<BillDetail> findAll() {
        objConnection = ConfigurationDB.openConnection();
        List<BillDetail> billDetails = new ArrayList<BillDetail>();

        try {
            String sql = "SELECT * FROM billDetail";
            try (PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String id = resultSet.getString("id");
                    String productId = resultSet.getString("productId");
                    String billId = resultSet.getString("billId");
                    int quantity = resultSet.getInt("quantity");
                    double subtotal = resultSet.getDouble("subtotal");

                    BillDetail billDetail = new BillDetail(id, productId, billId, quantity, subtotal);
                    billDetails.add(billDetail);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error: " + e.getMessage(), e);
        }
        ConfigurationDB.closeConnection();
        return billDetails;
    }
}
