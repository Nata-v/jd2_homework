package by.nata.data.dao;

import by.nata.config.ApplicationConfigurationTest;
import by.nata.data.entity.Company;
import by.nata.data.entity.CompanyAddress;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = ApplicationConfigurationTest.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class CompanyDaoImplTest {
@Mock

    private CompanyDao companyDao;

    private static final String COMPANY_ID = "1";

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void save() {

        Company company = new Company(null, "Microsoft", LocalDate.of(2024, 05, 10),
                new CompanyAddress("Moscow", "Arbat", "1111"));

        System.out.println(company);

        when(companyDao.save(company)).thenReturn(company);

        Company savedCompany = companyDao.save(company);
        System.out.println(savedCompany);

        assertNotNull(savedCompany);
        assertEquals("Microsoft", savedCompany.getName());
        assertEquals(LocalDate.of(2024, 05, 10), savedCompany.getCreated_date());
        assertEquals("Moscow", savedCompany.getCompanyAddress().getCity());
        assertEquals("Arbat", savedCompany.getCompanyAddress().getStreet());
        assertEquals("1111", savedCompany.getCompanyAddress().getPostCode());

        verify(companyDao).save(company);


    }

    @Test
    public void findAll() {
        List<Company> companies = new ArrayList<>();
        companies.add(new Company("1", "Meta", LocalDate.of(2023, 12, 25), new CompanyAddress()));
        companies.add(new Company("2", "Facebook", LocalDate.of(2023, 11, 27), new CompanyAddress()));
        companies.add(new Company("3","Amazon", LocalDate.of(2023, 12, 20), new CompanyAddress()));

        System.out.println(companies);
        when(companyDao.findAll()).thenReturn(companies);

        List<Company> result = companyDao.findAll();
        System.out.println(result);

        assertEquals(companies, result);

    }

    @Test
    public void findById() {

        Company company = new Company();
        company.setId(COMPANY_ID);
        company.setName("Meta");
        company.setCreated_date(LocalDate.of(2023, 12, 22));
        System.out.println(company);

        when(companyDao.findById(COMPANY_ID)).thenReturn(Optional.of(company));
        Optional<Company> result = companyDao.findById(COMPANY_ID);

        assertTrue(result.isPresent());
        assertEquals(company, result.get());

    }

    @Test
    public void delete() {

        Company company = new Company();
        company.setId(COMPANY_ID);
        company.setName("Meta");
        company.setCreated_date(LocalDate.of(2023, 12, 22));
        System.out.println(company);
        when(companyDao.delete(COMPANY_ID)).thenReturn(true);

        boolean result = companyDao.delete(COMPANY_ID);
        System.out.println(result);

        verify(companyDao).delete(COMPANY_ID);
        assertTrue(result);
    }


    @Test
    public void update() {

        Company company = new Company();
        company.setId(COMPANY_ID);
        company.setName("Facebook");
        company.setCreated_date(LocalDate.of(2024, 01, 15));
        System.out.println(company);
        when(companyDao.update(company)).thenReturn(true);
        boolean result = companyDao.update(company);

        assertEquals("1", company.getId());
        assertEquals("Facebook", company.getName());
        assertEquals(LocalDate.of(2024, 01, 15), company.getCreated_date());
        assertTrue(result);
    }

}