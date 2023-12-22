package by.nata.annotations.service;

import by.nata.annotations.database.entity.Company1;


import java.util.Optional;

public interface CompanyService {
    Company1 saveCompany(Company1 company);
    Optional<Company1> findCompanyById(String id);
}
