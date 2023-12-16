package by.nata.xml;

import by.nata.annotations.config.ApplicationConfiguration;
import by.nata.xml.entity.Company;
import by.nata.xml.entity.ContactEmployee;
import by.nata.xml.entity.Employee;
import by.nata.xml.service.CompanyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application.xml")

public class CheckCreatedBeansTest {

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    Company company;
    @Autowired
    Employee employee;
    @Autowired
    ContactEmployee contactEmployee;
    @Autowired
    CompanyService companyService;

    @Test
    public void testBeanCreation() {
        assertNotNull(applicationContext.getBean("company"));
        System.out.println(company.getName());
        assertNotNull(applicationContext.getBean("employee"));
        System.out.println(employee.getFirst_name());
        assertNotNull(applicationContext.getBean("contactEmployee"));
        System.out.println(contactEmployee.getNumber());
        assertNotNull(applicationContext.getBean("companyService"));
        System.out.println(companyService.toString());
        assertNotNull(applicationContext.getBean("companyMapper"));
        assertNotNull(applicationContext.getBean("companyDto"));

    }
}