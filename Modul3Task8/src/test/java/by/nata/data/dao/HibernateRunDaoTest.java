package by.nata.data.dao;


import by.nata.data.HibernateUtilTest;
import by.nata.data.pojo.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class HibernateRunDaoTest {
    private static SessionFactory sessionFactory;
    private Session session = null;
    private Transaction transaction = null;


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
    public void testSaveInSingleTable() {

        session = sessionFactory.openSession();
        transaction = session.beginTransaction();

        SingleTableStudent student1 = new SingleTableStudent(null, "John", "Smith", "Engineer-Programmer", 9.5);
        SingleTableStudent student2 = new SingleTableStudent(null, "Max", "Milton", "Computer Science", 7.0);
        SingleTableStudent student3 = new SingleTableStudent(null, "Jack", "Jackson", "Software engineer", 8.0);

        session.save(student1);
        session.save(student2);
        session.save(student3);

        SingleTableEmployee employee1 = new SingleTableEmployee(null, "Natali", "Volkova", "Google", 5000.00);
        SingleTableEmployee employee2 = new SingleTableEmployee(null, "Tom", "Taylor", "Apple", 4000.00);
        SingleTableEmployee employee3 = new SingleTableEmployee(null, "Mike", "Milton", "Microsoft", 3000.00);


        session.save(employee1);
        session.save(employee2);
        session.save(employee3);

        transaction.commit();


        assertNotNull(employee1.getId());
        assertEquals("Natali", employee1.getName());
        assertEquals("Volkova", employee1.getSurname());
        assertEquals("Google", employee1.getCompany());
        assertEquals(5000.00, employee1.getSalary(), 0.001);


    }

    @Test
    public void testSaveInJoinedTable() {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();

        JoinedTableStudent student1 = new JoinedTableStudent(null, "John", "Smith", "Engineer-Programmer", 9.5);
        session.save(student1);

        JoinedTableEmployee employee1 = new JoinedTableEmployee(null, "Natali", "Volkova", "Google", 5000.00);
        session.save(employee1);

        transaction.commit();
        assertNotNull(employee1.getId());
        assertEquals("Natali", employee1.getName());
        assertEquals("Volkova", employee1.getSurname());
        assertEquals("Google", employee1.getCompany());
        assertEquals(5000.00, employee1.getSalary(), 0.001);
    }

    @Test
    public void testSaveInTablePerClass() {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();

        Student student1 = new Student(null, "John", "Smith", "Engineer-Programmer", 9.5);
        session.save(student1);

        Employee employee1 = new Employee(null, "Natali", "Volkova", "Google", 5000.00);
        session.save(employee1);

        transaction.commit();
        assertNotNull(employee1.getId());
        assertEquals("Natali", employee1.getName());
        assertEquals("Volkova", employee1.getSurname());
        assertEquals("Google", employee1.getCompany());
        assertEquals(5000.00, employee1.getSalary(), 0.001);
    }

    @Test
    public void testFindAll() {
        List<Student> resultList = new ArrayList<>();

        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        Student student1 = new Student(null, "John", "Smith", "Engineer-Programmer", 9.5);
        session.save(student1);

        List<Student> students = session.createQuery("from Student").list();

        transaction.commit();
        for (Student student : students) {
            resultList.add(student);
            System.out.println(resultList);
        }

        assertNotNull(resultList.size());
        assertEquals(1, resultList.size());

    }

    @Test
    public void testGetById() {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        Student student = new Student(null, "John", "Smith", "Engineer-Programmer", 9.5);
        session.save(student);

        Student studentGet = session.get(Student.class, 1L);
        transaction.commit();
        assertNotNull(studentGet.getId());
        assertEquals("John", studentGet.getName());

        transaction = session.beginTransaction();

        SingleTableEmployee employee1 = new SingleTableEmployee(null, "Natali", "Volkova", "Google", 5000.00);
        session.save(employee1);

        SingleTableEmployee employee = session.get(SingleTableEmployee.class, 1L);
        System.out.println(employee);
        transaction.commit();

        assertNotNull(employee.getId());
        assertEquals("Natali", employee.getName());
    }
}