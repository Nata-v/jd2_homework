package by.nata.xml.service;

import by.nata.xml.entity.Company;
import by.nata.xml.mapper.CompanyMapper;

public class CompanyService {
    private final CompanyMapper companyMapper;
    private final Company company;

    public CompanyService(CompanyMapper companyMapper, Company company) {
        this.companyMapper = companyMapper;
        this.company = company;
    }

    @Override
    public String toString() {
        return "CompanyService{" +
                "companyMapper=" + companyMapper +
                ", company=" + company +
                '}';
    }
}
