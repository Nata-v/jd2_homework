package by.nata.xml.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
    private static JdbcConnection jdbcConnection;
    protected JdbcConnection() throws ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");

    }
    protected Connection getJdbcConnection() throws SQLException {
        return   DriverManager.getConnection("jdbc:mysql://localhost:3306/Companies?createDatabaseIfNotExist=true",
                "user",
                "user");
    }
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if (jdbcConnection == null){
            jdbcConnection = new JdbcConnection();
        }
        return jdbcConnection.getJdbcConnection();
    }
}
