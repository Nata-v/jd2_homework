package by.nata.annotations.config;


import by.nata.annotations.database.entity.Company1;
import by.nata.annotations.database.entity.Employee1;
import by.nata.annotations.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@ContextConfiguration(classes = ApplicationConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class ApplicationConfigurationTest {

    @Autowired
    EmployeeService employeeService;


    @Test
    public void createBeanEmployeeService() {
        assertNotNull(employeeService);
        System.out.println(employeeService.toString());
    }

    @Autowired
    @Qualifier("createCompany")
    Company1 createCompany;

    @Autowired
    @Qualifier("createCompany2")
    Company1 createCompany2;

    @Test
    public void testCreateCompany() {
        assertNotNull(createCompany);
        System.out.println(createCompany.hashCode());
        assertNotNull(createCompany2);
        System.out.println(createCompany2.hashCode());
    }


    @Autowired
    @Qualifier("createEmployee")
    Employee1 createEmployee;
    @Autowired
    @Qualifier("createEmployee2")
    Employee1 createEmployee2;

    @Test
    public void testCreateEmployee() {
        assertNotNull(createEmployee);
        System.out.println(createEmployee.hashCode());
        System.out.println(createEmployee.toString());
        assertNotNull(createEmployee2);
        System.out.println(createEmployee2.hashCode());
        System.out.println(createEmployee2.toString());
    }


}