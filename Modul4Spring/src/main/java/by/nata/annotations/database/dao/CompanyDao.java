package by.nata.annotations.database.dao;

import by.nata.annotations.database.entity.Company1;
import by.nata.xml.entity.Company;

import java.util.Optional;

public interface CompanyDao {
    Company1 save (Company1 company);
    Optional<Company1> findById(String id);
}
