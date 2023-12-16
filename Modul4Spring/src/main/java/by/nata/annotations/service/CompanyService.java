package by.nata.annotations.service;

import by.nata.annotations.database.entity.Company1;
import by.nata.annotations.dto.CompanyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service

public class CompanyService{

    @Autowired
private final CompanyDto companyDto;
    @Autowired
    @Qualifier("createCompany2")
    private final Company1 company1;

    public CompanyService(CompanyDto companyDto, Company1 company1) {

    this.companyDto = companyDto;
        this.company1 = company1;
    }

    @Override
    public String toString() {
        return "CompanyService{" +
                "companyDto=" + companyDto +
                ", company1=" + company1 +
                '}';
    }
}
