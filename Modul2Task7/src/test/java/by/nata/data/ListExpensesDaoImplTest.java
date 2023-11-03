package by.nata.data;

import by.nata.entity.Expense;
import by.nata.entity.Receiver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;



import static org.junit.Assert.*;

public class ListExpensesDaoImplTest {

private  Connection connection;
Dao dao;

    String DATABASE_URL = "jdbc:mysql://localhost:3306/ListExpenses_test";
    String USERNAME = "user";
    String PASSWORD = "user";

    @Before
    public void setUp() throws Exception {
        dao = new TestListExpenses();

        connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        connection.createStatement().executeUpdate( "truncate table expenses;");


    }

    @After
    public void tearDown() throws Exception {
        dao = null;
        connection.createStatement().executeUpdate( "truncate table expenses;");

        if (connection != null){
            connection.close();

        }
    }


    @Test
    public void getReceiver(){
        TestListExpenses dao = TestListExpenses.getINSTANCE();
        Receiver receiver = dao.getReceiver(1);
        assertNotNull(receiver);
        assertEquals(1, receiver.getId());
        assertEquals("MTC", receiver.getName());
    }



    @Test
    public void getReceivers(){
        TestListExpenses dao = TestListExpenses.getINSTANCE();
        ArrayList<Receiver> receivers = dao.getReceivers();
        assertEquals(5, receivers.size());

        Receiver receiver1 = receivers.get(0);
        assertNotNull(receiver1);
        assertEquals(1, receiver1.getId());
        assertEquals("MTC", receiver1.getName());

        Receiver receiver2 = receivers.get(1);
        assertNotNull(receiver2);
        assertEquals(2, receiver2.getId());
        assertEquals("A1", receiver2.getName());

    }

    @Test
    public void getExpense() {
        TestListExpenses dao = TestListExpenses.getINSTANCE();
        Expense expense = dao.getExpense(1);
        assertNotNull(expense);
        assertEquals(1, expense.getId());
        assertEquals("2022-05-10", expense.getPaymentDate());
        assertEquals(1, expense.getReceiverId());
        assertEquals(20000.0, expense.getAmount(), 0.001);
    }

    @Test
    public void getExpenses() {
        TestListExpenses dao = TestListExpenses.getINSTANCE();
        ArrayList<Expense> expenses = dao.getExpenses();
        assertEquals(5, expenses.size());

        Expense expense1 = expenses.get(0);
        assertNotNull(expense1);
        assertEquals(1, expense1.getId());
        assertEquals("2022-05-10", expense1.getPaymentDate());
        assertEquals(1, expense1.getReceiverId());
        assertEquals(20000.0, expense1.getAmount(), 0.001);

        Expense expense2 = expenses.get(1);
        assertNotNull(expense2);
        assertEquals(2, expense2.getId());
        assertEquals("2022-06-23", expense2.getPaymentDate());
        assertEquals(2, expense2.getReceiverId());
        assertEquals(48000.0, expense2.getAmount(), 0.001);


    }

    @Test
    public void addReceiver() {
        TestListExpenses dao = TestListExpenses.getINSTANCE();
        Receiver receiver = new Receiver(5,"SAT_TV");


        int id = dao.addReceiver(receiver);
        assertNotNull(receiver);

        assertEquals(5, id);

        Receiver addedReceiver = dao.getReceiver(5);
        assertNotNull(addedReceiver);
        assertEquals(5, addedReceiver.getId());
        assertEquals("SAT_TV", addedReceiver.getName());



    }

    @Test
    public void addExpense() {
        TestListExpenses dao = TestListExpenses.getINSTANCE();
        Expense expense = new Expense(6,"2022-07-15", 2, 10000);

        int id = dao.addExpense(expense);
        assertNotNull(expense);

        assertTrue(id > 0);


        assertEquals(6, id);

        Expense addedExpense = dao.getExpense(id);
        assertEquals(id, addedExpense.getId());
        assertEquals("2022-07-15", addedExpense.getPaymentDate());
        assertEquals(2, addedExpense.getReceiverId());
        assertEquals(10000.0, addedExpense.getAmount(), 0.001);


    }



    }