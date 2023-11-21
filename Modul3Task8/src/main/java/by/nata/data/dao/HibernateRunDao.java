package by.nata.data.dao;

import by.nata.data.pojo.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class HibernateRunDao implements Dao {
    private final SessionFactory sessionFactory;

    public HibernateRunDao(SessionFactory sessionFactory) {
        if (sessionFactory == null) {
            throw new IllegalArgumentException("An argument sessionFactory cannot be null");
        }
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveInSingleTable(Object object) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            SingleTableStudent student1 = new SingleTableStudent(null, "John", "Smith", "Engineer-Programmer", 9.5);
            SingleTableStudent student2 = new SingleTableStudent(null, "Max", "Milton", "Computer Science", 7.0);
            SingleTableStudent student3 = new SingleTableStudent(null, "Jack", "Jackson", "Software engineer", 8.0);

            session.save(student1);
            session.save(student2);
            session.save(student3);

            session.flush();

            SingleTableEmployee employee1 = new SingleTableEmployee(null, "Natali", "Volkova", "Google", 5000.00);
            SingleTableEmployee employee2 = new SingleTableEmployee(null, "Tom", "Taylor", "Apple", 4000.00);
            SingleTableEmployee employee3 = new SingleTableEmployee(null, "Mike", "Milton", "Microsoft", 3000.00);

            session.save(employee1);
            session.save(employee2);
            session.save(employee3);

            session.flush();
            session.clear();

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);

        } finally {
            if (session != null) session.close();
        }

    }

    @Override
    public void saveInJoinedTable(Object object) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            JoinedTableStudent student1 = new JoinedTableStudent(null, "John", "Smith", "Engineer-Programmer", 9.5);
            JoinedTableStudent student2 = new JoinedTableStudent(null, "Max", "Milton", "Computer Science", 7.0);
            JoinedTableStudent student3 = new JoinedTableStudent(null, "Jack", "Jackson", "Software engineer", 8.0);

            session.save(student1);
            session.save(student2);
            session.save(student3);

            session.flush();
            JoinedTableEmployee employee1 = new JoinedTableEmployee(null, "Natali", "Volkova", "Google", 5000.00);
            JoinedTableEmployee employee2 = new JoinedTableEmployee(null, "Tom", "Taylor", "Apple", 4000.00);
            JoinedTableEmployee employee3 = new JoinedTableEmployee(null, "Mike", "Milton", "Microsoft", 3000.00);

            session.save(employee1);
            session.save(employee2);
            session.save(employee3);

            session.flush();
            session.clear();

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);

        } finally {
            if (session != null) session.close();
        }

    }

    @Override
    public void saveInTablePerClass(Object object) {

        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            Student student1 = new Student(null, "John", "Smith", "Engineer-Programmer", 9.5);
            Student student2 = new Student(null, "Max", "Milton", "Computer Science", 7.0);
            Student student3 = new Student(null, "Jack", "Jackson", "Software engineer", 8.0);

            session.save(student1);
            session.save(student2);
            session.save(student3);

            session.flush();
            Employee employee1 = new Employee(null, "Natali", "Volkova", "Google", 5000.00);
            Employee employee2 = new Employee(null, "Tom", "Taylor", "Apple", 4000.00);
            Employee employee3 = new Employee(null, "Mike", "Milton", "Microsoft", 3000.00);

            session.save(employee1);
            session.save(employee2);
            session.save(employee3);

            session.flush();
            session.clear();

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);

        } finally {
            if (session != null) session.close();
        }

    }

    @Override
    public List<Person> findAll() {
        Session session = null;
        Transaction transaction = null;

        List<Person> resultList = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            List<Person> persons = session.createQuery("from Person").list();
            transaction.commit();
            for (Person person : persons) {
                resultList.add(person);
                if (person instanceof Student) {
                    Student student = (Student) person;
                    System.out.println(student.getId() + " " + student.getName() + " " +
                            student.getSurname() + " " + student.getFaculty() + " " +
                            student.getMark());
                } else if (person instanceof Employee) {
                    Employee employee = (Employee) person;

                    System.out.println(employee.getId() + " " + employee.getName() + " " +
                            employee.getSurname() + " " + employee.getCompany() + " " +
                            employee.getSalary());
                } else {
                    System.out.println(person.getId() + " " + person.getName() + " " + person.getSurname());
                }

            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);

        } finally {
            if (session != null) session.close();
        }

        return resultList;
    }

    @Override
    public void getById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID can't be null");
        }
        Session session = null;
        Transaction transaction = null;


        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            Student student = session.get(Student.class, 2L);
            Employee employee = session.get(Employee.class, 5L);

            SingleTableEmployee singleTableEmployee = session.get(SingleTableEmployee.class, 2L);

            JoinedTableEmployee joinedTableEmployee = session.get(JoinedTableEmployee.class, 1L);
            session.flush();
            System.out.println(student);
            System.out.println(employee);
            System.out.println(singleTableEmployee);
            System.out.println(joinedTableEmployee);

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);

        } finally {
            if (session != null) session.close();
        }

    }

}

