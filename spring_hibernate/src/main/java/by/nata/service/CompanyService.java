package by.nata.service;

import by.nata.data.entity.Company;
import by.nata.dto.CompanyAddressDto;
import by.nata.dto.CompanyDto;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    //Company saveCompany(CompanyDto companyDto, CompanyAddressDto companyAddressDto);
    Optional<Company> findCompanyById(String id);
    List<Company> findAllCompanies();
    boolean deleteCompany(String id);
    boolean updateCompany(Company company);
}
