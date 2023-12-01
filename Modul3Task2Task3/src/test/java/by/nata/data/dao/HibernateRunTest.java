package by.nata.data.dao;

import by.nata.data.HibernateUtilTest;
import by.nata.data.JdbcUtilTest;
import by.nata.data.pojo.Expenses;
import by.nata.data.pojo.Receivers;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class HibernateRunTest {
        private static SessionFactory sessionFactory;
        private static Dao dao;
        private Session session = null;
        private Transaction transaction = null;
        @Before
        public void setUp() throws Exception {

                Connection conn = JdbcUtilTest.getConnection();
                conn.createStatement().executeUpdate("DELETE FROM expenses;");
                conn.createStatement().executeUpdate("DELETE FROM receivers;");


            sessionFactory = HibernateUtilTest.getSessionFactory();
            sessionFactory.openSession();

        }

        @After
        public void tearDown() throws Exception {

            if (sessionFactory == null) {
                sessionFactory.close();
            }
                dao = null;
                Connection conn = JdbcUtilTest.getConnection();
                conn.createStatement().executeUpdate("DELETE FROM expenses;");
                conn.createStatement().executeUpdate("DELETE FROM receivers;");


        }


        @Test
        public void save() throws SQLException, ClassNotFoundException {


                session = sessionFactory.openSession();
                transaction = session.beginTransaction();

                Receivers receiver = new Receivers(null, "SAT-TV");


                session.save(receiver);
                Expenses expenses = new Expenses(null, LocalDate.now(), new Receivers(null, "DANA-MOLL"), 3000.00);
                session.save(expenses);

                transaction.commit();

                assertNotNull(receiver);
                Connection conn = JdbcUtilTest.getConnection();
                ResultSet rs = conn.createStatement().executeQuery("select count(*) from receivers where NAME='SAT-TV'");
                rs.next();

                int actualCount = rs.getInt(1);

                assertEquals(1, actualCount);



        }

        @Test
        public void findById() throws SQLException, ClassNotFoundException {

                session = sessionFactory.openSession();
                transaction = session.beginTransaction();

                Receivers receiver = new Receivers(null, "MTC");
                session.save(receiver);
                transaction.commit();

                assertNotNull(receiver);
                Connection conn = JdbcUtilTest.getConnection();
                ResultSet rs = conn.createStatement().executeQuery("select count(*) from receivers where NAME='MTC'");
                rs.next();

                int actualCount = rs.getInt(1);

                assertEquals(1, actualCount);


        }


        @Test
        public void delete() throws SQLException, ClassNotFoundException {

                session = sessionFactory.openSession();
                transaction = session.beginTransaction();

                Expenses expenses = new Expenses(null, LocalDate.now(), new Receivers(null, "DANA-MOLL"), 3000.00);
                session.save(expenses);
                transaction.commit();

                Connection conn = JdbcUtilTest.getConnection();
                ResultSet rs = conn.createStatement()
                        .executeQuery("select count(*) from expenses where amount=3000.00");
                rs.next();

                int actualCount = rs.getInt(1);

                assertEquals(1, actualCount);


                assertEquals(null, session.get(Expenses.class, 5L));

        }

        @Test
        public void get() throws SQLException, ClassNotFoundException {
                session = sessionFactory.openSession();
                transaction = session.beginTransaction();

                Receivers receiver = new Receivers(null, "Life");
                session.save(receiver);
                transaction.commit();

                assertNotNull(receiver);
                Connection conn = JdbcUtilTest.getConnection();
                ResultSet rs = conn.createStatement().executeQuery("select count(*) from receivers where NAME='Life'");
                rs.next();

                int actualCount = rs.getInt(1);

                assertEquals(1, actualCount);


        }

        @Test
        public void load() throws SQLException, ClassNotFoundException {
                session = sessionFactory.openSession();
                transaction = session.beginTransaction();

                Receivers receiver = new Receivers(null, "A1");
                session.save(receiver);
                transaction.commit();

                assertNotNull(receiver);

                Connection conn = JdbcUtilTest.getConnection();
                ResultSet rs = conn.createStatement().executeQuery("select count(*) from receivers where NAME='A1'");
                rs.next();

                int actualCount = rs.getInt(1);

                assertEquals(1, actualCount);


        }


        @Test
        public void deleteExpense() throws SQLException, ClassNotFoundException {

                session = sessionFactory.openSession();
                transaction = session.beginTransaction();

                Expenses expense = new Expenses(null, LocalDate.now(), new Receivers(null, "OMO"), 5000.00);
                session.save(expense);
                session.flush();

                session = sessionFactory.openSession();

                Expenses expenseDelete = session.find(Expenses.class, expense.getId());
                transaction.commit();
                Connection conn = JdbcUtilTest.getConnection();
                ResultSet rs = conn.createStatement()
                        .executeQuery("select count(*) from expenses where amount=5000.00");
                rs.next();

                int actualCount = rs.getInt(1);

                assertEquals(1, actualCount);



        }

}
