package jm.task.core.jdbc.util;

//import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class Util {
    // настройка соеденения с БД

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL =
            "jdbc:mysql://localhost:3306/usersdb?autoReconnect=true&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public Connection getConnection() {

        Connection connection = null;
//        Driver driver = null;

        try {
            Class.forName(DRIVER);
//            driver = new FabricMySQLDriver();
//            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        return connection;
    }
}
