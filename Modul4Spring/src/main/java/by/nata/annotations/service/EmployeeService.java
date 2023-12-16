package by.nata.annotations.service;

import by.nata.annotations.database.entity.Employee1;
import by.nata.annotations.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired

    private final EmployeeMapper employeeMapper;
    @Autowired
    @Qualifier("createEmployee2")
    private final Employee1 employee1;

    public EmployeeService(EmployeeMapper employeeMapper, Employee1 employee1) {
        this.employeeMapper = employeeMapper;
        this.employee1 = employee1;
    }



    @Override
    public String toString() {
        return "EmployeeService{" +
                "employeeMapper=" + employeeMapper +
                ", employee1=" + employee1 +
                '}';
    }
}
