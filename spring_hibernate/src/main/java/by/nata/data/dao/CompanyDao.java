package by.nata.data.dao;

import by.nata.data.entity.Company;
import by.nata.dto.CompanyAddressDto;
import by.nata.dto.CompanyDto;

import java.util.List;
import java.util.Optional;

public interface CompanyDao {
   // Company save (CompanyDto companyDto, CompanyAddressDto companyAddressDto);
    Optional<Company> findById(String id);

    List<Company> findAll();

    boolean delete (String id);
    boolean update(Company company);
}
