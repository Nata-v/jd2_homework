package by.nata.annotations.service;

import by.nata.annotations.database.dao.CompanyDao;
import by.nata.annotations.database.entity.Company1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class CompanyServiceImpl implements CompanyService{
@Autowired
    private final CompanyDao companyDao;



    @Autowired
    @Qualifier("createCompany2")
    private final Company1 company;


    public CompanyServiceImpl(CompanyDao companyDao, Company1 company) {
        this.companyDao = companyDao;
        this.company = company;
    }

    @Override
    public Company1 saveCompany(Company1 company) {
        return companyDao.save(company);
    }

    @Override
    public Optional<Company1> findCompanyById(String id) {

        return companyDao.findById(id);
    }

    @Override
    public String toString() {
        return "CompanyServiceImpl{" +
                "companyDao=" + companyDao +
                ", company=" + company +
                '}';
    }
}
