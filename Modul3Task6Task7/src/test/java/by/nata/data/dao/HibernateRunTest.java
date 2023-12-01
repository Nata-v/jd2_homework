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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
        conn.createStatement().executeUpdate("DELETE FROM employee;");
        conn.createStatement().executeUpdate("DELETE FROM company;");

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
        conn.createStatement().executeUpdate("DELETE FROM employee;");
        conn.createStatement().executeUpdate("DELETE FROM company;");
    }

    @Test
    public void testSave() throws Exception {


        session = sessionFactory.openSession();
        transaction = session.beginTransaction();

        Company company = new Company(null, "Microsoft", LocalDate.of(2024, 05, 10),
                new CompanyAddress("New York", "Rodeo Drive", "3030"));

        session.saveOrUpdate(company);


        Employee employee = new Employee(null, "Natali", "Volkova", 5000.00,
                new Company(null, "Google", LocalDate.now(),
                        new CompanyAddress("London", "Yoll Street", "7777")),
                new ContactEmployee("245-55-55", "Домашний"));

        session.saveOrUpdate(employee);
        transaction.commit();

        assertNotNull(company);
        assertNotNull(employee);

        Connection conn = JdbcUtilTest.getConnection();

        ResultSet rs = conn.createStatement().executeQuery("select count(*) from company where NAME='Microsoft'");
        rs.next();
        int actualCount = rs.getInt(1);
        assertEquals(1, actualCount);

        rs = conn.createStatement().executeQuery("select count(*) from employee where FIRST_NAME='Natali' AND LAST_NAME='Volkova'");
        rs.next();
        actualCount = rs.getInt(1);
        assertEquals(1, actualCount);

        conn.close();


    }

    @Test
    public void testFindAll() throws SQLException, ClassNotFoundException {
        Connection conn = JdbcUtilTest.getConnection();
        List<Company> companies = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String testId = UUID.randomUUID().toString();

            Company company = new Company();
            company.setId(testId);
            company.setName("Natali" + i);
            company.setCreated_date(LocalDate.parse("2020-10-03"));

            companies.add(company);
        }


        assertEquals(10, companies.size());
        assertEquals("Natali0", companies.get(0).getName());
        assertEquals("Natali1", companies.get(1).getName());
        assertEquals("Natali2", companies.get(2).getName());
        conn.close();

    }

    @Test
    public void getIdentifier() throws SQLException, ClassNotFoundException {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();

        Product product = new Product(null, "MacBook", "15");
        Product product2 = new Product(null, "iPhone", "15PRO");
        Product product3 = new Product(null, "Airpods", "8");
        session.saveOrUpdate(product);
        session.saveOrUpdate(product2);
        session.saveOrUpdate(product3);
        transaction.commit();

        assertNotNull(product);
        assertNotNull(product2);
        assertNotNull(product3);
        Connection conn = JdbcUtilTest.getConnection();
        ResultSet rs = conn.createStatement().executeQuery("select count(*) from product where NAME='MacBook' AND model='15'");
        rs.next();
        int actualCount =  rs.getInt(1);
        assertEquals(1, actualCount);

        rs = conn.createStatement().executeQuery("select count(*) from product where NAME='iPhone' AND model='15PRO'");
        rs.next();
         actualCount =  rs.getInt(1);
        assertEquals(1, actualCount);

        rs = conn.createStatement().executeQuery("select count(*) from product where NAME='Airpods' AND model='8'");
        rs.next();
        actualCount =  rs.getInt(1);
        assertEquals(1, actualCount);



        conn.close();


    }

}