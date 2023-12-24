package by.nata.service;

import by.nata.data.entity.Company;
import by.nata.data.entity.Employee;

import java.util.List;
import java.util.Optional;


public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    Optional<Employee> findEmployeeById(String id);
    List<Employee> findAllEmployee();
    boolean deleteEmployee(String id);
    boolean updateEmployee(Employee employee);

}
