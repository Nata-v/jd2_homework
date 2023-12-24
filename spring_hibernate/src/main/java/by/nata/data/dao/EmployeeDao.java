package by.nata.data.dao;

import by.nata.data.entity.Company;
import by.nata.data.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeDao {
    Employee save (Employee employee);
    Optional<Employee> findById(String id);

    List<Employee> findAll();

    boolean delete (String id);
    boolean update(Employee employee);
}
