package micros;

import java.sql.*;

public class DataBaseConnectivity {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/microsData?useSSL=false&serverTimezone=Europe/Warsaw";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "M8!!45678$%!MAa*";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {

        Connection connection;

            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); //todo czy to jest zamkniete connection?!
            System.out.println("Connected database successfully...");
            System.out.println("Connection = " + connection);
            System.out.println("Database name = " + connection.getCatalog());

        return connection;
    }
}




