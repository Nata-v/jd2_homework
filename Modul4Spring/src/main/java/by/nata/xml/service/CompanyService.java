package by.nata.xml.service;

import by.nata.xml.entity.Company;

import java.util.Optional;

public interface CompanyService {
    Company saveCompany(Company company);
    Optional<Company> findCompanyById(String id);
}
