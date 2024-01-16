package by.nata.service;

import by.nata.config.ApplicationConfigurationTest;
import by.nata.data.dao.EmployeeDao;
import by.nata.data.entity.Company;

import by.nata.data.entity.ContactEmployee;
import by.nata.data.entity.Employee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

//@ContextConfiguration(classes = ApplicationConfigurationTest.class)
//@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeServiceImplTest {
//
//    Employee employee = new Employee();
//@Autowired
//EmployeeService employeeService;
//
////    @PersistenceContext(name = "sessionFactory")
////    SessionFactory sessionFactory;
//    private static final String EMPLOYEE_ID = "1";
//    @Mock
//    private EmployeeDao employeeDao;
//
//    @InjectMocks
//    //@Autowired
//    private EmployeeServiceImpl employeeServiceImpl;
//
//    @Before
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    public void testCreateBeanEmployeeServiceImpl(){
//        assertNotNull(employeeService);
//        System.out.println(employeeService);
//    }
//    @Test
//    public void saveEmployee() {
//
//       employee.setId(EMPLOYEE_ID);
//       employee.setFirst_name("John");
//       employee.setLast_name("Smith");
//       employee.setSalary(2500.00);
//
//        when(employeeDao.save(employee)).thenReturn(employee);
//
//        Employee savedEmployee = employeeServiceImpl.saveEmployee(employee);
//        assertEquals(employee, savedEmployee);
//
//        verify(employeeDao, times(1)).save(employee);
//
//        assertEquals("John", employee.getFirst_name());
//
//    }
//
//    @Test
//    public void findEmployeeById() {
//
//        employee.setId(EMPLOYEE_ID);
//        employee.setFirst_name("Natali");
//        employee.setLast_name("Volkova");
//        System.out.println(employee);
//
//
//        when(employeeDao.findById(EMPLOYEE_ID)).thenReturn(Optional.of(employee));
//
//
//        Optional<Employee> foundCompany = employeeServiceImpl.findEmployeeById(EMPLOYEE_ID);
//        assertEquals(Optional.of(employee), foundCompany);
//
//        verify(employeeDao, times(1)).findById(EMPLOYEE_ID);
//
//    }
//
//    @Test
//    public void findAllEmployee() {
//
//        List<Employee> expectedEmployee = new ArrayList<>();
//        expectedEmployee.add(new Employee("1", "Natali","Volkova", 5000.00,new Company(),new ContactEmployee()));
//        expectedEmployee.add(new Employee("2", "John","Smith", 4000.00,new Company(),new ContactEmployee()));
//        expectedEmployee.add(new Employee("3", "Kate","Ivanova", 3000.00,new Company(),new ContactEmployee()));
//
//        System.out.println(expectedEmployee);
//        when(employeeDao.findAll()).thenReturn(expectedEmployee);
//
//        List<Employee> actualEmployee = employeeServiceImpl.findAllEmployee();
//
//        assertEquals(expectedEmployee, actualEmployee);
//    }
//
//    @Test
//    public void deleteEmployee() {
//
//
//        employee.setId(EMPLOYEE_ID);
//        employee.setFirst_name("Natali");
//        employee.setLast_name("Volkova");
//        System.out.println(employee);
//
//        when(employeeDao.delete(EMPLOYEE_ID)).thenReturn(true);
//
//        boolean result = employeeServiceImpl.deleteEmployee(EMPLOYEE_ID);
//
//        assertTrue(result);
//        verify(employeeDao, times(1)).delete(EMPLOYEE_ID);
//    }
//
//    @Test
//    public void updateEmployee() {
//
//
//        when(employeeDao.update(employee)).thenReturn(true);
//
//        boolean result = employeeServiceImpl.updateEmployee(employee);
//
//        assertTrue(result);
//        verify(employeeDao).update(employee);
//    }
}