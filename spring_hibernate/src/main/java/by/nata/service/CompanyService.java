package by.nata.service;

import by.nata.data.entity.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    Company saveCompany(Company company);
    Optional<Company> findCompanyById(String id);
    List<Company> findAllCompanies();
    boolean deleteCompany(String id);
    boolean updateCompany(Company company);
}
