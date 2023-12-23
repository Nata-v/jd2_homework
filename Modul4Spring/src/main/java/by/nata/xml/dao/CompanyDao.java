package by.nata.xml.dao;

import by.nata.xml.entity.Company;

import java.util.Optional;

public interface CompanyDao {
    Company save (Company company);
    Optional<Company> findById(String id);
}
