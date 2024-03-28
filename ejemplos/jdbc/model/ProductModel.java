package jdbc.model;

import jdbc.configuration.ConfigurationDB;
import jdbc.entity.Product;
import jdbc.repository.ProductRepository;

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
            String sql = "INSERT INTO product (id,name,price) values (?,?,?);";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);

            statement.setString(1, product.getId());
            statement.setString(2, product.getName());
            statement.setDouble(3, product.getPrice());

            statement.execute();

            System.out.println("Product insertion completed successful");

        } catch (SQLException e) {
            ConfigurationDB.closeConnection();
            System.out.println("Error " + e.getMessage());
        }
        ConfigurationDB.closeConnection();
    }

    @Override
    public Product findById(String id) {
        objConnection = ConfigurationDB.openConnection();
        Product product = new Product();
        try {
            String sql = "SELECT *FROM product WHERE id = ?;";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);

            statement.setString(1, id);

            ResultSet resultSet = statement.executeQuery();

            resultSet.next();

            String productId = resultSet.getString("id");
            String name = resultSet.getString("name");
            double price = resultSet.getDouble("price");

            product = new Product(productId, name, price);

        } catch (SQLException e) {
            ConfigurationDB.closeConnection();
            System.out.println("Error " + e.getMessage());
        }
        ConfigurationDB.closeConnection();
        return product;
    }

    @Override
    public List<Product> findAll() {
        objConnection = ConfigurationDB.openConnection();
        List<Product> products = new ArrayList<>();

        try {
            String sql = "SELECT *FROM product;";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String productId = resultSet.getString("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");

                Product product = new Product(productId, name, price);
                products.add(product);
            }
        } catch (SQLException e) {
            ConfigurationDB.closeConnection();
            System.out.println("Error " + e);
        }
        ConfigurationDB.closeConnection();
        return products;
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


        } catch (SQLException e) {
            ConfigurationDB.closeConnection();
            System.out.println("Error " + e);
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

        } catch (SQLException e) {
            ConfigurationDB.closeConnection();
            System.out.println("Error " + e.getMessage());
        }
        ConfigurationDB.closeConnection();
    }
}
