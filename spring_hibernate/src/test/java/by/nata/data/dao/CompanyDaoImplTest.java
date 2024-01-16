package by.nata.data.dao;

import by.nata.config.ApplicationConfigurationTest;
import by.nata.data.entity.Company;
import by.nata.data.entity.CompanyAddress;
import by.nata.dto.CompanyAddressDto;
import by.nata.dto.CompanyDto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

//@ContextConfiguration(classes = ApplicationConfigurationTest.class)
//@RunWith(SpringJUnit4ClassRunner.class)
//@TestPropertySource(value = "classpath:liquibase_test.properties")
public class CompanyDaoImplTest {
//@Autowired
//CompanyDao companyDao;

//@Autowired
// SessionFactory sessionFactory;
//@Autowired
// Session session;

    private static final String COMPANY_ID = "1";

    @Before
    public void setUp() throws Exception {
      //  MockitoAnnotations.initMocks(this);
//session = sessionFactory.getCurrentSession();
    }

    @After
    public void tearDown() throws Exception {
      //  companyDao = null;
    }

    @Test
    public void save() {
//        CompanyAddressDto companyAddressDto = new CompanyAddressDto("Moscow", "Arbat", "1111");
//        CompanyDto companyDto = new CompanyDto(null, "Microsoft", LocalDate.of(2024, 05, 10),
//new CompanyAddress(companyAddressDto.getCity(),
//        companyAddressDto.getStreet(),
//        companyAddressDto.getPostCode()));
//
////                new CompanyAddress("Moscow", "Arbat", "1111"));
//
//        Company company = new Company(companyDto.getId(),
//                companyDto.getName(),
//                companyDto.getCreated_date(),
//                new CompanyAddress(companyAddressDto.getCity(),
//                        companyAddressDto.getStreet(),
//                        companyAddressDto.getPostCode())
//        );
//
//
////        CompanyDto companyDto = new CompanyDto(null, "Microsoft", LocalDate.of(2024, 05, 10),
////                new CompanyAddress("Moscow", "Arbat", "1111"));
//
//        System.out.println(company);
//
//        // when(companyDao.save(company)).thenReturn(company);
//
//
//
//        Company savedCompany = companyDao.save(companyDto, companyAddressDto);
//
//        System.out.println(savedCompany);
//
//        assertNotNull(savedCompany);
//        assertEquals("Microsoft", savedCompany.getName());
//        assertEquals(LocalDate.of(2024, 05, 10), savedCompany.getCreated_date());
//        assertEquals("Moscow", savedCompany.getCompanyAddress().getCity());
//        assertEquals("Arbat", savedCompany.getCompanyAddress().getStreet());
//        assertEquals("1111", savedCompany.getCompanyAddress().getPostCode());
    }
       // verify(companyDao).save(company);




//
//    @Test
//    public void findAll() {
//        List<Company> companies = new ArrayList<>();
//        companies.add(new Company("1", "Meta", LocalDate.of(2023, 12, 25), new CompanyAddress()));
//        companies.add(new Company("2", "Facebook", LocalDate.of(2023, 11, 27), new CompanyAddress()));
//        companies.add(new Company("3","Amazon", LocalDate.of(2023, 12, 20), new CompanyAddress()));
//
//        System.out.println(companies);
//       // when(companyDao.findAll()).thenReturn(companies);
//
//        List<Company> result = companyDao.findAll();
//        System.out.println(result);
//
//        assertEquals(companies, result);
//
//    }
//
//    @Test
//    public void findById() {
//
//      Company  company = new Company(null, "Microsoft", LocalDate.of(2024, 05, 10),
//                new CompanyAddress("Moscow", "Arbat", "1111"));
////        Company company = new Company();
////        company.setId(COMPANY_ID);
////        company.setName("Meta");
////        company.setCreated_date(LocalDate.of(2023, 12, 22));
////        company.setCompanyAddress(new CompanyAddress("Minsk", "Tyrova", "22222"));
//        System.out.println(company);
//Company savedCompany = companyDao.save(company);
//        System.out.println(savedCompany);
//      //  when(companyDao.findById(COMPANY_ID)).thenReturn(Optional.of(company));
//        Optional<Company> result = companyDao.findById(COMPANY_ID);
//
//        assertTrue(result.isPresent());
//        assertEquals(savedCompany, result.get());
//
//    }
//
//    @Test
//    public void delete() {
//
//        Company company = new Company();
//        company.setId(COMPANY_ID);
//        company.setName("Meta");
//        company.setCreated_date(LocalDate.of(2023, 12, 22));
//        System.out.println(company);
//        when(companyDao.delete(COMPANY_ID)).thenReturn(true);
//
//        boolean result = companyDao.delete(COMPANY_ID);
//        System.out.println(result);
//
//        verify(companyDao).delete(COMPANY_ID);
//        assertTrue(result);
//    }
//
//
//    @Test
//    public void update() {
//
//        Company company = new Company();
//        company.setId(COMPANY_ID);
//        company.setName("Facebook");
//        company.setCreated_date(LocalDate.of(2024, 01, 15));
//        System.out.println(company);
//        when(companyDao.update(company)).thenReturn(true);
//        boolean result = companyDao.update(company);
//
//        assertEquals("1", company.getId());
//        assertEquals("Facebook", company.getName());
//        assertEquals(LocalDate.of(2024, 01, 15), company.getCreated_date());
//        assertTrue(result);
//    }

}