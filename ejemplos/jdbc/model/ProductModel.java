package jdbc.model;

import jdbc.connection.ConfigurationDB;
import jdbc.repository.ProductRepository;
import jdbc.entity.Product;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProductModel implements ProductRepository {
    Connection objConnection;

    @Override
    public void saveProduct(Product product) {
        objConnection = ConfigurationDB.openConnection();
        try {
            String sql = "INSERT INTO product (id,name, price) VALUES (?,?,?);";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
            statement.setString(1, product.getId());
            statement.setString(2, product.getName());
            statement.setDouble(3, product.getPrice());

            statement.execute();

            System.out.println("Product insertion completed successfully");

        } catch (SQLException e) {
            ConfigurationDB.closeConnection();
            throw new RuntimeException(e);
        }
        ConfigurationDB.closeConnection();
    }

    @Override
    public void updateProduct(Product product) {
        objConnection = ConfigurationDB.openConnection();
        try {
            String sql = "UPDATE product SET name = ?, price = ?  WHERE (id = ?);";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setString(3, product.getId());

            statement.executeUpdate();

            System.out.println("Product was update successfully");
        } catch (SQLException e) {
            ConfigurationDB.closeConnection();
            throw new RuntimeException(e);
        }
        ConfigurationDB.closeConnection();
    }

    @Override
    public void deleteProduct(String id) {
        objConnection = ConfigurationDB.openConnection();

        try {
            String sql = "DELETE FROM product WHERE id = ?;";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
            statement.setString(1, id);

            statement.execute();
            System.out.println("The row was deleted successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Product findById(String id) {
        objConnection = ConfigurationDB.openConnection();
        Product product;
        try {
            String sql = "SELECT * FROM product WHERE product.id = " + id + ";";
            try (PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {

                resultSet.next();

                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                String productId = resultSet.getString("id");

                product = new Product(productId, name, price);

            }
        } catch (Exception e) {
            ConfigurationDB.closeConnection();
            throw new RuntimeException(e);
        }
        ConfigurationDB.closeConnection();
        return product;
    }

    @Override
    public List<Product> findAll() {
        objConnection = ConfigurationDB.openConnection();
        List<Product> products = new ArrayList<Product>();

        try {
            String sql = "SELECT * FROM product";
            try (PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String id = resultSet.getString("id");
                    String name = resultSet.getString("name");
                    double price = resultSet.getDouble("price");

                    Product product = new Product(id, name, price);
                    products.add(product);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error: " + e.getMessage(), e);
        }
        ConfigurationDB.closeConnection();
        return products;
    }
}
