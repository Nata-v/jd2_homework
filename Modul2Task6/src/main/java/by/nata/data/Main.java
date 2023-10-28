package by.nata.data;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/paymentDB?createDatabaseIfNotExist=true", "user", "user");

            Statement statement = connection.createStatement();


            System.out.println("Список получателей платежей и сумма платежей по каждому из них:");

          String recipientsQuery = "SELECT name, sum(amount) as total_amount FROM recipients " +
                  "JOIN payments ON recipients.id = payments.recipients_id GROUP BY recipients.id";
            ResultSet recipientsResult = statement.executeQuery(recipientsQuery);
            while (recipientsResult.next()) {
                String recipientName = recipientsResult.getString("name");
                BigDecimal totalAmount = recipientsResult.getBigDecimal("total_amount");
                System.out.println("Получатель: " + recipientName + ", Сумма платежей: " + totalAmount);
            }
            recipientsResult.close();


            System.out.println("\nСумма платежей за день с наибольшим платежом:");
            String maxPaymentDayQuery = "SELECT payment_date, SUM(amount) AS total_amount FROM payments " +
                    "GROUP BY payment_date ORDER BY total_amount DESC LIMIT 1";
            ResultSet maxPaymentDayResult = statement.executeQuery(maxPaymentDayQuery);
            if (maxPaymentDayResult.next()) {
                LocalDate paymentDate = maxPaymentDayResult.getDate("payment_date").toLocalDate();
                BigDecimal totalAmount = maxPaymentDayResult.getBigDecimal("total_amount");
                System.out.println("Дата платежа: " + paymentDate + ", Сумма платежей: " + totalAmount);
            }
            maxPaymentDayResult.close();

          
            System.out.println("\nНаибольший платеж за день с наибольшей суммой платежей:");

            String maxPaymentQuery = "SELECT p.* FROM payments p " +
                    "JOIN (SELECT payment_date, SUM(amount) AS total_amount FROM payments GROUP BY payment_date " +
                    "ORDER BY total_amount DESC LIMIT 1) t " +
                    "ON p.payment_date = t.payment_date " +
                    "ORDER BY p.amount DESC LIMIT 1";

            ResultSet maxPaymentResult = statement.executeQuery(maxPaymentQuery);
            if (maxPaymentResult.next()) {
                int paymentId = maxPaymentResult.getInt("id");
                LocalDate paymentDate = maxPaymentResult.getDate("payment_date").toLocalDate();
                int recipientId = maxPaymentResult.getInt("recipients_id");
                BigDecimal amount = maxPaymentResult.getBigDecimal("amount");
                System.out.println("Payment ID: " + paymentId);
                System.out.println("Дата платежа: " + paymentDate);
                System.out.println("Получатель ID: " + recipientId);
                System.out.println("Сумма платежа: " + amount);
            }
            maxPaymentResult.close();

            statement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
