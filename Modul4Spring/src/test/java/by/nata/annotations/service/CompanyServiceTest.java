package by.nata.annotations.service;

import by.nata.annotations.config.ApplicationConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@ContextConfiguration(classes = ApplicationConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class CompanyServiceTest {


    @Autowired
    EmployeeService employeeService;
    @Autowired
    CompanyService companyService;

    @Test
    public void testCreateBeanEmployeeService(){
        assertNotNull(employeeService);
        System.out.println(employeeService);
    }



    @Test
    public void testCreateBeanCompanyService(){
        assertNotNull(companyService);
        System.out.println(companyService);
    }
}