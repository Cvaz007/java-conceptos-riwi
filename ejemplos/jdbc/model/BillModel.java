package jdbc.model;

import jdbc.connection.ConfigurationDB;
import jdbc.entity.Bill;
import jdbc.entity.Product;
import jdbc.repository.BillRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BillModel implements BillRepository {
    Connection objConnection;

    @Override
    public Bill saveBill(Bill bill) {
        objConnection = ConfigurationDB.openConnection();
        try {
            String sql = "INSERT INTO bill (id,total, customer) VALUES (?,?,?);";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
            statement.setString(1, bill.getId());
            statement.setDouble(2, bill.getTotal());
            statement.setString(3, bill.getCustomer());

            statement.execute();

            System.out.println("Bill insertion completed successfully");

        } catch (SQLException e) {
            ConfigurationDB.closeConnection();
            throw new RuntimeException(e);
        }
        ConfigurationDB.closeConnection();
        return bill;
    }

    @Override
    public void deleteBill(String id) {
        objConnection = ConfigurationDB.openConnection();

        try {
            String sql = "DELETE FROM bill WHERE id = ?;";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
            statement.setString(1, id);

            statement.execute();
            System.out.println("The row was deleted successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Bill findById(String id) {
        objConnection = ConfigurationDB.openConnection();
        Bill bill;
        try {
            String sql = "SELECT * FROM bill WHERE bill.id = ?;";

            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();

            resultSet.next();

            String customer = resultSet.getString("customer");
            double total = resultSet.getDouble("total");
            String billId = resultSet.getString("id");

            bill = new Bill(billId, total, customer);

        } catch (Exception e) {
            ConfigurationDB.closeConnection();
            throw new RuntimeException(e);
        }
        ConfigurationDB.closeConnection();
        return bill;

    }

    @Override
    public List<Bill> findAll() {
        objConnection = ConfigurationDB.openConnection();
        List<Bill> bills = new ArrayList<Bill>();

        try {
            String sql = "SELECT * FROM bill";
            try (PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String id = resultSet.getString("id");
                    String customer = resultSet.getString("customer");
                    double total = resultSet.getDouble("total");

                    Bill bill = new Bill(id, total, customer);
                    bills.add(bill);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error: " + e.getMessage(), e);
        }
        ConfigurationDB.closeConnection();
        return bills;
    }




}
