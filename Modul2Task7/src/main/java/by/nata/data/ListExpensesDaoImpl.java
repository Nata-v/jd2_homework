package by.nata.data;

import by.nata.entity.Expense;
import by.nata.entity.Receiver;
import java.sql.*;
import java.util.ArrayList;


public class ListExpensesDaoImpl implements Dao{
    private final static ListExpensesDaoImpl INSTANCE = new ListExpensesDaoImpl();

        private Connection connection;
        private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/ListExpenses?createDatabaseIfNotExist=true";

        private static final String USERNAME = "user";
        private static final String PASSWORD = "user";


    public static ListExpensesDaoImpl getINSTANCE() {
        return INSTANCE;
    }


        public ListExpensesDaoImpl() {
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

        @Override
        public Receiver getReceiver(int id) {
            Receiver receiver = null;
            try {
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM receivers WHERE id = ?");
                statement.setInt(1, id);
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    String name = resultSet.getString("name");
                    receiver = new Receiver(id, name);
                }

                resultSet.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                closeConnection();
            }

            return receiver;
        }

        @Override
        public ArrayList<Receiver> getReceivers() {
            ArrayList<Receiver> receivers = new ArrayList<>();

            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM receivers");

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    Receiver receiver = new Receiver(id, name);
                    receivers.add(receiver);
                }
                resultSet.close();
                statement.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                closeConnection();
            }

            return receivers;
        }

        @Override
        public Expense getExpense(int id) {
            Expense expense = null;
            try {
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM expenses WHERE id = ?");
                statement.setInt(1, id);
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                  String date = resultSet.getString("payment_date");
                    int receiverId = resultSet.getInt("receivers_id");
                    double amount = resultSet.getDouble("amount");


                    return new Expense(id, date, receiverId, amount);
                }
                resultSet.close();
                statement.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                closeConnection();
            }

            return null;
        }

        @Override
        public ArrayList<Expense> getExpenses() {
            ArrayList<Expense> expenses = new ArrayList<>();

            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM expenses");

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");

                 String date = String.valueOf(resultSet.getDate("payment_date"));
                    int receiverId = resultSet.getInt("receivers_id");
                    double amount = resultSet.getDouble("amount");


                    Expense expense = new Expense(id, date, receiverId, amount);
                    expenses.add(expense);
                }
                resultSet.close();
                statement.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                closeConnection();
            }

            return expenses;
        }

        @Override
        public int addReceiver(Receiver receiver) {

           try {

                PreparedStatement statement = connection.prepareStatement("INSERT INTO receivers(name) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
                statement.setString(1, receiver.getName());
                statement.executeUpdate();

                ResultSet resultSet = statement.getGeneratedKeys();
                if (resultSet.next()) {
                   return resultSet.getInt(1);

                }

                resultSet.close();
                statement.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                closeConnection();
            }

             return receiver.getId();
        }

        @Override
        public int addExpense(Expense expense) {

            try {
                try (PreparedStatement statement = connection.prepareStatement("INSERT INTO expenses(payment_date, receivers_id, amount) VALUES (?, ?, ?)",
                        Statement.RETURN_GENERATED_KEYS)) {

                    statement.setString(1, expense.getPaymentDate());
                    statement.setInt(2, expense.getReceiverId());
                    statement.setDouble(3, expense.getAmount());
                    statement.executeUpdate();

                    ResultSet resultSet = statement.getGeneratedKeys();
                    if (resultSet.next()) {
                        return resultSet.getInt(1);
                    }
                    resultSet.close();

                }

            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                closeConnection();
            }


            return expense.getId();
        }


    }




