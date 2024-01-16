package by.nata.data.dao;

import by.nata.config.ApplicationConfigurationTest;
import by.nata.data.entity.Company;
import by.nata.data.entity.ContactEmployee;
import by.nata.data.entity.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//@ContextConfiguration(classes = ApplicationConfigurationTest.class)
//@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeDaoImplTest {
//Employee employee = new Employee();
//    @Mock
//
//    private EmployeeDao employeeDao;
//
//    private static final String EMPLOYEE_ID = "1";
//    @Before
//    public void setUp() throws Exception {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @After
//    public void tearDown() throws Exception {
//    }
//
//    @Test
//    public void save() {
//        employee.setId(EMPLOYEE_ID);
//        employee.setFirst_name("John");
//        employee.setLast_name("Smith");
//        employee.setSalary(2500.00);
//        System.out.println(employee);
//
//        when(employeeDao.save(employee)).thenReturn(employee);
//
//        Employee savedEmployee = employeeDao.save(employee);
//        System.out.println(savedEmployee);
//
//        assertNotNull(savedEmployee);
//        assertEquals("John", savedEmployee.getFirst_name());
//        assertEquals("Smith", savedEmployee.getLast_name());
//        assertEquals(2500.00, savedEmployee.getSalary(), 0.001);
//
//
//        verify(employeeDao).save(employee);
//    }
//
//    @Test
//    public void findById() {
//        employee.setId(EMPLOYEE_ID);
//        employee.setFirst_name("Natali");
//        employee.setLast_name("Volkova");
//        System.out.println(employee);
//
//        when(employeeDao.findById(EMPLOYEE_ID)).thenReturn(Optional.of(employee));
//        Optional<Employee> result = employeeDao.findById(EMPLOYEE_ID);
//
//        assertTrue(result.isPresent());
//        assertEquals(employee, result.get());
//    }
//
//    @Test
//    public void findAll() {
//        List<Employee> expectedEmployee = new ArrayList<>();
//        expectedEmployee.add(new Employee("1", "Natali","Volkova", 5000.00,new Company(),new ContactEmployee()));
//        expectedEmployee.add(new Employee("2", "John","Smith", 4000.00,new Company(),new ContactEmployee()));
//        expectedEmployee.add(new Employee("3", "Kate","Ivanova", 3000.00,new Company(),new ContactEmployee()));
//
//        System.out.println(expectedEmployee);
//        when(employeeDao.findAll()).thenReturn(expectedEmployee);
//
//        List<Employee> result = employeeDao.findAll();
//        System.out.println(result);
//
//        assertEquals(expectedEmployee, result);
//    }
//
//    @Test
//    public void delete() {
//        employee.setId(EMPLOYEE_ID);
//        employee.setFirst_name("Natali");
//        employee.setLast_name("Volkova");
//        System.out.println(employee);
//
//        when(employeeDao.delete(EMPLOYEE_ID)).thenReturn(true);
//
//        boolean result = employeeDao.delete(EMPLOYEE_ID);
//        System.out.println(result);
//
//        verify(employeeDao).delete(EMPLOYEE_ID);
//        assertTrue(result);
//    }
//
//    @Test
//    public void update() {
//        employee.setId(EMPLOYEE_ID);
//        employee.setFirst_name("John");
//        employee.setLast_name("Smith");
//        employee.setSalary(2500.00);
//        System.out.println(employee);
//
//        when(employeeDao.update(employee)).thenReturn(true);
//        boolean result = employeeDao.update(employee);
//
//        assertEquals("John", employee.getFirst_name());
//        assertEquals("Smith", employee.getLast_name());
//        assertEquals(2500.00, employee.getSalary(), 0.001);
//        assertTrue(result);
//    }
}