package jdbc;

import jdbc.configuration.ConfigurationDB;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection obj = ConfigurationDB.openConnection();
    }
}
