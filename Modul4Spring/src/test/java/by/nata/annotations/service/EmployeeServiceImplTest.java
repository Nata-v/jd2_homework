package by.nata.annotations.service;

import by.nata.annotations.config.ApplicationConfiguration;
import by.nata.annotations.database.dao.CompanyDao;
import by.nata.annotations.database.dao.EmployeeDao;
import by.nata.annotations.database.entity.Company1;
import by.nata.annotations.database.entity.CompanyAddress1;
import by.nata.annotations.database.entity.ContactEmployee1;
import by.nata.annotations.database.entity.Employee1;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ContextConfiguration(classes = ApplicationConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeServiceImplTest {


    private static final String EMPLOYEE_ID = "1";
    @Mock
    private EmployeeDao employeeDao;

    @InjectMocks
    //@Autowired
    private EmployeeServiceImpl employeeServiceImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveCompany() {
        Employee1 employee = new Employee1();
        employee.setFirst_name("Natali");
        employee.setLast_name("Volkova");
        employee.setSalary(5000);
        employee.setCompany(new Company1(EMPLOYEE_ID, "Google", LocalDate.of(2023, 12, 22),
                new CompanyAddress1("Minsk", "Nemiga", "7777")));
        employee.setContactEmployee1(new ContactEmployee1("375296183716", "Рабочий"));

        System.out.println(employee);

        when(employeeDao.save(employee)).thenReturn(employee);

        Employee1 savedEmployee = employeeServiceImpl.saveEmployee(employee);
        assertEquals(employee, savedEmployee);

        verify(employeeDao, times(1)).save(employee);
    }

    @Test
    public void testFindCompanyById() {

        Employee1 employee = new Employee1();
        employee.setId(EMPLOYEE_ID);
        employee.setFirst_name("Natali");
        employee.setLast_name("Volkova");
        System.out.println(employee);


        when(employeeDao.findById(EMPLOYEE_ID)).thenReturn(Optional.of(employee));


        Optional<Employee1> foundCompany = employeeServiceImpl.findEmployeeById(EMPLOYEE_ID);
        assertEquals(Optional.of(employee), foundCompany);

        verify(employeeDao, times(1)).findById(EMPLOYEE_ID);
    }

    @Test
    public void testCreateBeanEmployeeServiceImpl() {
        assertNotNull(employeeServiceImpl);
        System.out.println(employeeServiceImpl.toString());
    }

}