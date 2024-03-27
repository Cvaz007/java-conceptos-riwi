package jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//! This class will be charge of establishing a connection and close the connection with the database.
public class ConfigurationDB {
    public static Connection connection;

    public static Connection openConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://uge4vnzaaj1v6bpb:95uZnRYik2bpf1Mx7ooN@bbnwv8ihldhqodqkctl2-mysql.services.clever-cloud.com:3306/bbnwv8ihldhqodqkctl2";
            String user = "uge4vnzaaj1v6bpb";
            String password = "95uZnRYik2bpf1Mx7ooN";

            connection = (Connection) DriverManager.getConnection(url, user, password);

        } catch (ClassNotFoundException e) {
            System.err.println("Error. Driver not found");
        } catch (SQLException e) {
            System.err.println("Connection failed. " + e.getMessage());
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connection was closed successfully");
            } catch (SQLException e) {
                System.err.println("Connection failed. " + e.getMessage());
            }
        }
    }
}
