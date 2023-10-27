package by.nata.data;

import java.math.BigDecimal;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/paymentDB", "user", "user");


            Statement statement = connection.createStatement();
            String payment_date = String.valueOf(args[0]);


            int recipients_id = Integer.parseInt(args[1]);
            BigDecimal amount = new BigDecimal(args[2]);
            String query = "INSERT INTO payments (payment_date, recipients_id, amount) VALUES ('" + payment_date + "'," +
                    recipients_id + "," + amount + ")";

            statement.executeUpdate(query);


            query = "SELECT * FROM payments";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String paymentDate = resultSet.getString("payment_date");
                int recipientId = resultSet.getInt("recipients_id");
                BigDecimal amountResult = resultSet.getBigDecimal("amount");
                System.out.println("ID: " + id + ", Payment Date: " + paymentDate + ", Recipient ID: " + recipientId + ", Amount: " + amountResult);
            }


            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

}
