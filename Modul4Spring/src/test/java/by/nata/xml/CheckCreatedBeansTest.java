package by.nata.xml;


import by.nata.xml.dao.CompanyDaoImpl;
import by.nata.xml.entity.*;
import by.nata.xml.mapper.CompanyMapper;
import by.nata.xml.service.CompanyServiceImpl;
import org.junit.After;
import org.junit.Test;

import org.springframework.context.support.ClassPathXmlApplicationContext;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;



public class CheckCreatedBeansTest {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");


    @After
    public void tearDown(){
        context.close();
    }

    @Test
    public void testUserBeanCreation() {


        User user = (User) context.getBean("user");
        System.out.println(user);

        assertNotNull(user);
        assertEquals(3, user.getId());
        assertEquals("bob", user.getUsername());
        assertEquals("090909", user.getPassword());


    }
    @Test
    public void testAccountsBeanCreation(){



        Accounts account = (Accounts) context.getBean("accounts");
        System.out.println(account);

        assertNotNull(account);


    }

    @Test
    public void testBeansCreated(){


       CompanyMapper companyMapper = (CompanyMapper) context.getBean("companyMapper");
        System.out.println(companyMapper);
        assertNotNull(companyMapper);

        CompanyServiceImpl companyServiceImpl = (CompanyServiceImpl) context.getBean("companyServiceImpl");
        System.out.println(companyServiceImpl.toString());
        assertNotNull(companyServiceImpl);

        CompanyDaoImpl companyDaoImpl = (CompanyDaoImpl) context.getBean("companyDao");
        System.out.println(companyDaoImpl.toString());
        assertNotNull(companyDaoImpl);
    }


}