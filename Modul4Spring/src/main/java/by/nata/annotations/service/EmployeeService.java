package by.nata.annotations.service;

import by.nata.annotations.database.entity.Employee1;

import java.util.Optional;

public interface EmployeeService {

    Employee1 saveEmployee(Employee1 employee);
    Optional<Employee1> findEmployeeById(String id);
}
