package by.nata.data.dao;

import by.nata.data.entity.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyDao {
    Company save (Company company);
    Optional<Company> findById(String id);

    List<Company> findAll();

    boolean delete (String id);
    boolean update(Company company);
}
