package by.nata.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestListExpenses extends ListExpensesDaoImpl{
    private final static TestListExpenses INSTANCE = new TestListExpenses();

    private Connection connection;
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/ListExpenses_test";

    private static final String USERNAME = "user";
    private static final String PASSWORD = "user";


    public static TestListExpenses getINSTANCE() {
        return INSTANCE;
    }


    public TestListExpenses() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private void closeConnection(){
        try {
            if (connection == null){
                connection.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
