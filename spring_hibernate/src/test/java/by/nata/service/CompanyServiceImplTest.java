package by.nata.service;


import by.nata.config.ApplicationConfigurationTest;
import by.nata.data.dao.CompanyDao;
import by.nata.data.entity.Company;
import by.nata.data.entity.CompanyAddress;

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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = ApplicationConfigurationTest.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class CompanyServiceImplTest {

    private static final String COMPANY_ID = "1";
    @Mock
    private CompanyDao companyDao;

    @InjectMocks
    //@Autowired
    private CompanyServiceImpl companyServiceImpl;

    @Autowired
    CompanyService companyService;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testCreateBeanCompanyServiceImpl() {
        assertNotNull(companyService);
        System.out.println(companyService);
    }

    @Test
    public void saveCompany() {
        Company company = new Company();
        company.setId(COMPANY_ID);
        company.setName("Meta");
        company.setCreated_date(LocalDate.of(2023, 12, 22));
        company.setCompanyAddress(new CompanyAddress("Minsk", "Nemiga", "7777"));

        when(companyDao.save(company)).thenReturn(company);

        Company savedCompany = companyServiceImpl.saveCompany(company);
        assertEquals(company, savedCompany);

        verify(companyDao, times(1)).save(company);

        assertEquals("Meta", company.getName());

    }

    @Test
    public void findCompanyById() {
        Company company = new Company();
        company.setId(COMPANY_ID);
        company.setName("Meta");
        company.setCreated_date(LocalDate.of(2023, 12, 22));
        System.out.println(company);


        when(companyDao.findById(COMPANY_ID)).thenReturn(Optional.of(company));


        Optional<Company> foundCompany = companyServiceImpl.findCompanyById(COMPANY_ID);
        assertEquals(Optional.of(company), foundCompany);

        verify(companyDao, times(1)).findById(COMPANY_ID);
    }

    @Test
    public void findAllCompanies() {

        List<Company> expectedCompanies = new ArrayList<>();
      expectedCompanies.add(new Company("1", "Meta", LocalDate.of(2023, 12, 25), new CompanyAddress()));
      expectedCompanies.add(new Company("2", "Facebook", LocalDate.of(2023, 11, 27), new CompanyAddress()));
      expectedCompanies.add(new Company("3","Amazon", LocalDate.of(2023, 12, 20), new CompanyAddress()));
        System.out.println(expectedCompanies);
        when(companyDao.findAll()).thenReturn(expectedCompanies);

        List<Company> actualCompanies = companyServiceImpl.findAllCompanies();

        assertEquals(expectedCompanies, actualCompanies);
    }




    @Test
    public void deleteCompany() {

        Company company = new Company();
        company.setId(COMPANY_ID);
        company.setName("Meta");
        company.setCreated_date(LocalDate.of(2023, 12, 22));
        System.out.println(company);

            when(companyDao.delete(COMPANY_ID)).thenReturn(true);

            boolean result = companyServiceImpl.deleteCompany(COMPANY_ID);

            assertTrue(result);
            verify(companyDao, times(1)).delete(COMPANY_ID);


    }

    @Test
    public void updateCompany() {

        Company company = new Company();
        when(companyDao.update(company)).thenReturn(true);

        boolean result = companyServiceImpl.updateCompany(company);

        assertTrue(result);
        verify(companyDao).update(company);

    }
}