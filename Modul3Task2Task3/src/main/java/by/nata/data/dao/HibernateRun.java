package by.nata.data.dao;

import by.nata.data.pojo.Expenses;
import by.nata.data.pojo.Receivers;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.time.LocalDate;

public class HibernateRun implements Dao {
    private final SessionFactory sessionFactory;

    public HibernateRun(SessionFactory sessionFactory) {
        if (sessionFactory == null) {
            throw new IllegalArgumentException("An argument sessionFactory cannot be null");
        }
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save() {
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            Receivers receiver = new Receivers(null, "SAT-TV");

            session.save(receiver);
            session.flush();
            Expenses expenses = new Expenses(null, LocalDate.now(), new Receivers(null, "DANA-MOLL"), 3000.00);
            session.save(expenses);

            session.flush();

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);

        } finally {
            if (session != null) session.close();
        }
    }

    @Override
    public Receivers findById(Long id) {

        if (id == null) {
            throw new IllegalArgumentException("ID can't be null");
        }
        Session session = null;
        Transaction transaction = null;


        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Receivers receiverLoaded = session.get(Receivers.class, 1L);

            session.flush();

            transaction.commit();

            return receiverLoaded;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);

        } finally {
            if (session != null) session.close();
        }

    }

    @Override
    public boolean delete(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID can't be null");

        }

        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            Expenses expensesDelete = session.get(Expenses.class, 5L);
session.flush();
if (expensesDelete == null){
    throw new IllegalArgumentException("Expense with ID " + id + "not found");
}


            session.delete(expensesDelete);
            session.flush();
            transaction.commit();


        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            if (session != null) session.close();
        }
        return true;
    }

    @Override
    public Receivers get(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID can't be null");
        }
        Session session = null;
        Transaction transaction = null;


        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Receivers receiverLoaded = session.get(Receivers.class, 1L);
            session.flush();

            transaction.commit();


            return receiverLoaded;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);

        } finally {
            if (session != null) session.close();
        }

    }

    @Override
    public Receivers load(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID can't be null");
        }
        Session session = null;
        Transaction transaction = null;


        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            Receivers receiverLoaded = session.load(Receivers.class, new Long(4L));
            String name = receiverLoaded.getName();
            System.out.println(name);
            session.flush();

            transaction.commit();
            return receiverLoaded;

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);

        } finally {
            if (session != null) session.close();
        }

    }


    @Override
    public void delete(Expenses expense) {
        if (expense == null) {
            throw new IllegalArgumentException("Expense can't be null");
        }
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            expense = new Expenses(null, LocalDate.now(), new Receivers(null, "OMO"), 5000.00);
            session.save(expense);
            session.flush();


            Expenses expenseDelete = session.find(Expenses.class, expense.getId());

            session.remove(expenseDelete);
            session.flush();

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            if (session != null) session.close();
        }

    }

}
