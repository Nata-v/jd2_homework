package by.nata.data.dao;

import by.nata.data.entity.Company;
import by.nata.data.entity.Employee;
import by.nata.dto.CompanyAddressDto;
import by.nata.dto.CompanyDto;
import by.nata.dto.ContactEmployeeDto;
import by.nata.dto.EmployeeDto;

import java.util.List;
import java.util.Optional;

public interface EmployeeDao {
    Employee save (Employee employee);
    Optional<Employee> findById(String id);

    List<Employee> findAll();

    boolean delete (String id);
    boolean update(Employee employee);
}
