package by.nata.data.dao;

import by.nata.data.pojo.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class HibernateRun implements Dao {
    private final SessionFactory sessionFactory;

    public HibernateRun(SessionFactory sessionFactory) {
        if (sessionFactory == null) {
            throw new IllegalArgumentException("An argument sessionFactory cannot be null");
        }
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Object object) {
        if (object == null) {
            throw new IllegalArgumentException("Object can't be null");
        }
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            Company company = new Company(null, "Microsoft", LocalDate.of(2024, 05, 10),
                    new CompanyAddress("New York", "Rodeo Drive", "3030"));

            session.saveOrUpdate(company);

            session.flush();
            Employee employee = new Employee(null, "Natali", "Volkova", 5000.00,
                    new Company(null, "Google", LocalDate.now(),
                            new CompanyAddress("London", "Yoll Street", "7777")),
                    new ContactEmployee("256-44-88", "Домашний"));

            session.saveOrUpdate(employee);

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
    public List<Object> findAll() {
        Session session = null;
        Transaction transaction = null;
        List<Object> resultList = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            List<Company> companies = session.createQuery("from Company").list();
            for (Company company : companies) {
                resultList.add(company);
                System.out.println("Company id: " + company);
            }


            List<Employee> employees = session.createQuery("from Employee").list();
            for (Employee employee : employees) {
                resultList.add(employee);
                System.out.println("Employee id: " + employee);
            }
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);

        } finally {
            if (session != null) session.close();
        }
        return resultList;
    }


}