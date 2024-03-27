package jdbc.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigurationDB {
    public static Connection connection;

    public static Connection openConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://ujho33ckbewpardu:04MGm3dzdagLmaA8E0wb@bhflp4dcfslvtnmlhshz-mysql.services.clever-cloud.com:3306/bhflp4dcfslvtnmlhshz";
            String password = "04MGm3dzdagLmaA8E0wb";
            String user = "ujho33ckbewpardu";

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
