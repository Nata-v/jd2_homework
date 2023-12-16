package by.nata.annotations.mapper;

import by.nata.annotations.dto.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {


    private  EmployeeDto employeeDto;
    @Autowired
    public EmployeeMapper(EmployeeDto employeeDto) {
        this.employeeDto = employeeDto;
    }

    @Override
    public String toString() {
        return "EmployeeMapper{" +
                "employeeDto=" + employeeDto +
                '}';
    }
}
