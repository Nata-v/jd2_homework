package by.nata.annotations.database.dao;

import by.nata.annotations.database.entity.Company1;
import by.nata.annotations.database.entity.Employee1;

import java.util.Optional;

public interface EmployeeDao {

    Employee1 save (Employee1 employee);
    Optional<Employee1> findById(String id);
}
