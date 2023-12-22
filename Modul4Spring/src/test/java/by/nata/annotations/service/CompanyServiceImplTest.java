package by.nata.annotations.service;

import by.nata.annotations.config.ApplicationConfiguration;
import by.nata.annotations.database.dao.CompanyDao;
import by.nata.annotations.database.entity.Company1;
import by.nata.annotations.database.entity.CompanyAddress1;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.Optional;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = ApplicationConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class CompanyServiceImplTest {
    private static final String COMPANY_ID = "1";
    @Mock
    private CompanyDao companyDao;

    @InjectMocks
    //@Autowired
    private CompanyServiceImpl companyServiceImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveCompany() {
        Company1 company = new Company1();
        company.setName("Meta");
        company.setCreated_date(LocalDate.of(2023, 12, 22));
        company.setCompanyAddress1(new CompanyAddress1("Minsk", "Nemiga", "7777"));
        System.out.println(company);

        when(companyDao.save(company)).thenReturn(company);

        Company1 savedCompany = companyServiceImpl.saveCompany(company);
        assertEquals(company, savedCompany);

        verify(companyDao, times(1)).save(company);
    }

    @Test
    public void testFindCompanyById() {

        Company1 company = new Company1();
        company.setId(COMPANY_ID);
        company.setName("Meta");
        company.setCreated_date(LocalDate.of(2023, 12, 22));
        System.out.println(company);


        when(companyDao.findById(COMPANY_ID)).thenReturn(Optional.of(company));


        Optional<Company1> foundCompany = companyServiceImpl.findCompanyById(COMPANY_ID);
        assertEquals(Optional.of(company), foundCompany);

        verify(companyDao, times(1)).findById(COMPANY_ID);
    }


    @Test
    public void testCreateBeanCompanyService(){
        assertNotNull(companyServiceImpl);
        System.out.println(companyServiceImpl.toString());
    }


}