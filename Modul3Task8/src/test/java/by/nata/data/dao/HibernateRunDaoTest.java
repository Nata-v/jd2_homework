package by.nata.data.dao;


import by.nata.data.HibernateUtilTest;
import by.nata.data.JdbcUtilTest;
import by.nata.data.pojo.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
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
private static Dao dao;

    @Before
    public void setUp() throws Exception {
        Connection conn = JdbcUtilTest.getConnection();

        sessionFactory = HibernateUtilTest.getSessionFactory();
        sessionFactory.openSession();
        conn.createStatement().executeUpdate("DELETE FROM person_employee_student;");
        conn.createStatement().executeUpdate("DELETE FROM student;");
        conn.createStatement().executeUpdate("DELETE FROM employee;");
        conn.createStatement().executeUpdate("DELETE FROM student_join;");
        conn.createStatement().executeUpdate("DELETE FROM employee_join;");
        conn.createStatement().executeUpdate("DELETE FROM person_join;");

    }

    @After
    public void tearDown() throws Exception {

        if (sessionFactory == null) {
            sessionFactory.close();
        }
        dao = null;
        Connection conn = JdbcUtilTest.getConnection();
        conn.createStatement().executeUpdate("DELETE FROM person_employee_student;");
        conn.createStatement().executeUpdate("DELETE FROM student;");
        conn.createStatement().executeUpdate("DELETE FROM employee;");
        conn.createStatement().executeUpdate("DELETE FROM student_join;");
        conn.createStatement().executeUpdate("DELETE FROM employee_join;");
        conn.createStatement().executeUpdate("DELETE FROM person_join;");

    }

    @Test
    public void testSaveInSingleTable() throws SQLException, ClassNotFoundException {

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

        assertNotNull(student1);
        assertNotNull(employee1);

        Connection conn = JdbcUtilTest.getConnection();

        ResultSet rs = conn.createStatement().executeQuery("select count(*) from person_employee_student");
        rs.next();
        int actualCount = rs.getInt(1);
        assertEquals(6, actualCount);
        conn.close();


    }

    @Test
    public void testSaveInJoinedTable() throws SQLException, ClassNotFoundException {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();

        JoinedTableStudent student1 = new JoinedTableStudent(null, "John", "Smith", "Engineer-Programmer", 9.5);
        session.save(student1);

        JoinedTableEmployee employee1 = new JoinedTableEmployee(null, "Natali", "Volkova", "Google", 5000.00);
        session.save(employee1);

        transaction.commit();

        assertNotNull(student1);
        assertNotNull(employee1);

        Connection conn = JdbcUtilTest.getConnection();

        ResultSet rs = conn.createStatement().executeQuery("select count(*) from person_join");
        rs.next();
        int actualCount = rs.getInt(1);
        assertEquals(2, actualCount);
        conn.close();
    }

    @Test
    public void testSaveInTablePerClass()  {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();

        Student student1 = new Student(null, "John", "Smith", "Engineer-Programmer", 9.5);
        session.save(student1);

        Employee employee1 = new Employee(null, "Natali", "Volkova", "Google", 5000.00);
        session.save(employee1);

        transaction.commit();

        assertNotNull(student1);
        assertNotNull(employee1);

        session = sessionFactory.openSession();
        List<Person> people = session.createQuery("SELECT p FROM Person p", Person.class).getResultList();

        assertEquals(2, people.size());

    }

    @Test
    public void testFindAll() {
        List<Student> resultList = new ArrayList<>();

        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        Student student1 = new Student(null, "John", "Smith", "Engineer-Programmer", 9.5);
        session.save(student1);
        transaction.commit();

        session = sessionFactory.openSession();
        List<Student> students = session.createQuery("from Student").list();
        for (Student student : students) {
            resultList.add(student);
            System.out.println(resultList);
        }

        assertNotNull(resultList.size());
        assertEquals(1, resultList.size());

    }

    @Test
    public void testGetById() throws SQLException, ClassNotFoundException {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        Student student = new Student(null, "John", "Smith", "Engineer-Programmer", 9.5);
        session.save(student);
        transaction.commit();

        assertNotNull(student);

        Connection conn = JdbcUtilTest.getConnection();
        ResultSet rs = conn.createStatement().executeQuery("select count(*) from student where NAME='John' AND SURNAME='Smith'");
        rs.next();
        int actualCount =  rs.getInt(1);
        assertEquals(1, actualCount);


        session = sessionFactory.openSession();
        transaction = session.beginTransaction();

        SingleTableEmployee employee1 = new SingleTableEmployee(null, "Natali", "Volkova", "Google", 5000.00);
        session.save(employee1);
        transaction.commit();

        assertNotNull(employee1);


        session = sessionFactory.openSession();
        SingleTableEmployee employee = session.get(SingleTableEmployee.class, 1L);
        System.out.println(employee);


        assertNotNull(employee.getId());
        assertEquals("Natali", employee.getName());
        conn.close();
    }
}