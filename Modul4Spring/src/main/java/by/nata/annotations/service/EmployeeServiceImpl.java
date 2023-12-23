package by.nata.annotations.service;

import by.nata.annotations.database.dao.EmployeeDao;
import by.nata.annotations.database.entity.Employee1;

import by.nata.annotations.database.entity.NewEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired

    private final EmployeeDao employeeDao;
    @Autowired
    @Qualifier("createEmployee2")
    private final NewEmployee employee1;

    public EmployeeServiceImpl(EmployeeDao employeeDao, NewEmployee employee1) {
        this.employeeDao = employeeDao;
        this.employee1 = employee1;
    }


    @Override
    public Employee1 saveEmployee(Employee1 employee) {

        return employeeDao.save(employee);
    }

    @Override
    public Optional<Employee1> findEmployeeById(String id) {
        return employeeDao.findById(id);

    }

    @Override
    public String toString() {
        return "EmployeeServiceImpl{" +
                "employeeDao=" + employeeDao +
                ", employee1=" + employee1 +
                '}';
    }
}
