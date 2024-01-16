package by.nata.service;

import by.nata.data.entity.Company;
import by.nata.data.entity.Employee;
import by.nata.dto.CompanyAddressDto;
import by.nata.dto.CompanyDto;
import by.nata.dto.ContactEmployeeDto;
import by.nata.dto.EmployeeDto;

import java.util.List;
import java.util.Optional;


public interface EmployeeService {
    Employee saveEmployee(EmployeeDto employeeDto, CompanyDto companyDto);
    Optional<Employee> findEmployeeById(String id);
    List<Employee> findAllEmployee();
    boolean deleteEmployee(String id);
    boolean updateEmployee(Employee employee);

}
