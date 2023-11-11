package by.nata.data.dao;

import by.nata.data.HibernateUtilTest;
import by.nata.data.pojo.Expenses;
import by.nata.data.pojo.Receivers;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class HibernateRunTest {
        private static SessionFactory sessionFactory;

        @Before
        public void setUp() throws Exception {

            sessionFactory = HibernateUtilTest.getSessionFactory();
            sessionFactory.openSession();


        }

        @After
        public void tearDown() throws Exception {

            if (sessionFactory == null) {
                sessionFactory.close();
            }
        }


        @Test
        public void save() {
            Session session = null;
            Transaction transaction = null;


            try {
                session = sessionFactory.openSession();
                transaction = session.beginTransaction();

                Receivers receiver = new Receivers(null, "SAT-TV");


                session.save(receiver);
                Expenses expenses = new Expenses(null, LocalDate.now(), new Receivers(null, "DANA-MOLL"), 3000.00);
                session.save(expenses);

                transaction.commit();

                assertNotNull(receiver);

                assertEquals("SAT-TV", receiver.getName());
                assertNotNull(expenses);
                assertEquals(LocalDate.now(), expenses.getPaymentDate());
                assertEquals("DANA-MOLL", expenses.getReceivers().getName());
                assertEquals(3000.00, expenses.getAmount(), 0.001);

            } catch (Exception e) {
                if (transaction != null) transaction.rollback();
                throw new RuntimeException(e);
            }


        }

        @Test
        public void findById() {

            Session session = null;
            Transaction transaction = null;
            try {
                session = sessionFactory.openSession();
                transaction = session.beginTransaction();
                Receivers receiverLoaded = session.get(Receivers.class, 1L);

                transaction.commit();
                assertNotNull(receiverLoaded);
                assertEquals("MTC", receiverLoaded.getName());

            } catch (Exception e) {
                if (transaction != null) transaction.rollback();
                throw new RuntimeException(e);
            }

        }


        @Test
        public void delete() {

            Session session = null;
            Transaction transaction = null;

            try {
                session = sessionFactory.openSession();
                transaction = session.beginTransaction();

                Expenses expensesDelete = session.get(Expenses.class, 5L);
                if (expensesDelete != null)
                    session.delete(expensesDelete);


                transaction.commit();

                assertEquals(null, session.get(Expenses.class, 5L));

            } catch (Exception e) {
                if (transaction != null) transaction.rollback();
                throw new RuntimeException(e);


            }
        }

        @Test
        public void get() {
            Session session = null;
            Transaction transaction = null;


            try {
                session = sessionFactory.openSession();
                transaction = session.beginTransaction();
                Receivers receiverLoaded = session.get(Receivers.class, 4L);


                transaction.commit();

                assertNotNull(receiverLoaded);
                assertEquals("Telekom", receiverLoaded.getName());

            } catch (Exception e) {
                if (transaction != null) transaction.rollback();
                throw new RuntimeException(e);

            }
        }

        @Test
        public void load() {
            Session session = null;
            Transaction transaction = null;


            try {
                session = sessionFactory.openSession();
                transaction = session.beginTransaction();

                Receivers receiverLoaded = session.load(Receivers.class, new Long(1L));
                String name = receiverLoaded.getName();
                System.out.println(name);
                session.refresh(receiverLoaded);

                transaction.commit();

                assertNotNull(receiverLoaded);
                assertEquals("MTC", receiverLoaded.getName());

            } catch (Exception e) {
                if (transaction != null) transaction.rollback();
                throw new RuntimeException(e);

            }

        }


        @Test
        public void deleteExpense() {
            Session session = null;
            Transaction transaction = null;

            try {
                session = sessionFactory.openSession();
                transaction = session.beginTransaction();

                Expenses expense = new Expenses(null, LocalDate.now(), new Receivers(null, "OMO"), 5000.00);
                session.save(expense);
                session.flush();


                Expenses expenseDelete = session.find(Expenses.class, expense.getId());

                session.remove(expenseDelete);
                session.flush();

                transaction.commit();

                assertNotNull(expense);
                assertEquals(LocalDate.now(), expense.getPaymentDate());
                assertEquals("OMO", expense.getReceivers().getName());
                assertEquals(5000.00, expense.getAmount(), 0.001);



            } catch (Exception e) {
                if (transaction != null) transaction.rollback();
                throw new RuntimeException(e);
            }
        }

}
