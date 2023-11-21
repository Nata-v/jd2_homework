package by.nata.data.dao;


import by.nata.data.HibernateUtilTest;
import by.nata.data.pojo.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class HibernateRunTest {

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
    public void testSave() throws Exception {


        session = sessionFactory.openSession();
        transaction = session.beginTransaction();

        Company company = new Company(null, "Microsoft", LocalDate.of(2024, 05, 10),
                new CompanyAddress("New York", "Rodeo Drive", "3030"));

        session.saveOrUpdate(company);

        session.flush();
        assertNotNull(company.getId());

        assertEquals("Microsoft", company.getName());
        assertEquals(LocalDate.of(2024,05,10), company.getCreated_date());
        assertEquals("New York", company.getCompanyAddress().getCity());
        assertEquals("Rodeo Drive", company.getCompanyAddress().getStreet());
        assertEquals("3030", company.getCompanyAddress().getPostCode());


        Employee employee = new Employee(null, "Natali", "Volkova", 5000.00,
                new Company(null, "Google", LocalDate.now(),
                        new CompanyAddress("London", "Yoll Street", "7777")),
                new ContactEmployee("245-55-55", "Домашний"));

        session.saveOrUpdate(employee);

        session.flush();

        assertNotNull(employee.getId());
        assertEquals("Natali", employee.getFirst_name());
        assertEquals("Volkova", employee.getLast_name());
        assertEquals(5000.00, employee.getSalary(), 0.001);


        transaction.commit();
    }

    @Test
    public void testFindAll() {

        List<Object> resultList = new ArrayList<>();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();

        List<Company> companies = session.createQuery("from Company").list();
        for (Company company : companies) {
            resultList.add(company);
            System.out.println("Company id: " + company);
        }
        assertEquals(0, companies.size());


        List<Employee> employees = session.createQuery("from Employee").list();
        for (Employee employee : employees) {
            resultList.add(employee);
            System.out.println("Employee id: " + employee);
        }
        assertEquals(0, employees.size());
        transaction.commit();

    }

}