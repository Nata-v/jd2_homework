package by.nata.xml.service;

import by.nata.xml.dao.CompanyDao;
import by.nata.xml.entity.Company;
import by.nata.xml.mapper.CompanyMapper;


import java.util.Optional;

public class CompanyServiceImpl implements CompanyService{
    private final CompanyMapper companyMapper;
    private final CompanyDao companyDao;

    public CompanyServiceImpl(CompanyMapper companyMapper, CompanyDao companyDao) {
        this.companyMapper = companyMapper;
        this.companyDao = companyDao;
    }


    @Override
    public Company saveCompany(Company company) {
        return companyDao.save(company);
    }

    @Override
    public Optional<Company> findCompanyById(String id) {

        return companyDao.findById(id);
    }

    @Override
    public String toString() {
        return "CompanyServiceImpl{" +
                "companyMapper=" + companyMapper +
                ", companyDao=" + companyDao +
                '}';
    }
}
