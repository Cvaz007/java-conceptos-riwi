package jdbc.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigurationDB {
    public static Connection connection;

    public static Connection openConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://uge4vnzaaj1v6bpb:95uZnRYik2bpf1Mx7ooN@bbnwv8ihldhqodqkctl2-mysql.services.clever-cloud.com:3306/bbnwv8ihldhqodqkctl2";
            String password = "95uZnRYik2bpf1Mx7ooN";
            String user = "uge4vnzaaj1v6bpb";

            connection = (Connection) DriverManager.getConnection(url,user,password);

            System.out.println("Connection was successful");

        }catch (ClassNotFoundException e){
            System.out.println("Error "+e);
        }catch (SQLException e){
            System.out.println("Error in SQL: "+e.getMessage());
        }
        return connection;
    }

    public static void closeConnection(){
        if (connection != null){
            try {
                connection.close();
                System.out.println("Connection was close successful");
            } catch (SQLException e) {
                System.out.println("Error "+e);
            }
        }
    }
}
