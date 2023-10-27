package by.nata.data;


import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/paymentDB?createDatabaseIfNotExist=true", "user", "user");

           Statement stmt = conn.createStatement();

            LocalDate paymentDate = LocalDate.parse(args[0]);
            int recipientId = Integer.parseInt(args[1]);
            BigDecimal amount = new BigDecimal(args[2]);


            String insertQuery = "INSERT INTO payments (payment_date, recipients_id, amount) VALUES (?, ?, ?)";
            PreparedStatement insertStatement = conn.prepareStatement(insertQuery);
            insertStatement.setObject(1, paymentDate);
            insertStatement.setInt(2, recipientId);
            insertStatement.setBigDecimal(3, amount);
            insertStatement.executeUpdate();
            insertStatement.close();


            String selectQuery = "SELECT * FROM payments";
            ResultSet resultSet = stmt.executeQuery(selectQuery);

            while (resultSet.next()) {
                int paymentId = resultSet.getInt("id");
                LocalDate paymentDateResult = resultSet.getObject("payment_date", LocalDate.class);
                int recipientIdResult = resultSet.getInt("recipients_id");
                BigDecimal amountResult = resultSet.getBigDecimal("amount");

                System.out.println("Payment ID: " + paymentId);
                System.out.println("Payment Date: " + paymentDateResult);
                System.out.println("Recipient ID: " + recipientIdResult);
                System.out.println("Amount: " + amountResult);
                System.out.println();
            }

            resultSet.close();
            stmt.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();

        }
    }


    }




