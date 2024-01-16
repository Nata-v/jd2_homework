package by.nata.service;

import by.nata.data.dao.EmployeeDao;
import by.nata.data.entity.Company;
import by.nata.data.entity.CompanyAddress;
import by.nata.data.entity.ContactEmployee;
import by.nata.data.entity.Employee;
import by.nata.dto.CompanyAddressDto;
import by.nata.dto.CompanyDto;
import by.nata.dto.ContactEmployeeDto;
import by.nata.dto.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

private final EmployeeDao employeeDao;
@Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public Employee saveEmployee(EmployeeDto employeeDto, CompanyDto companyDto) {
//CompanyAddress companyAddress = new CompanyAddress(
//       // companyAddressDto.getCity(),
//        companyAddressDto.getStreet(),
//        companyAddressDto.getPostCode()
//);
        Company company = new Company(
                companyDto.getId(),
                companyDto.getName(),
                companyDto.getCreated_date()
               // companyAddress
        );

//        ContactEmployee contactEmployee = new ContactEmployee(
//                contactEmployeeDto.getNumber(),
//                contactEmployeeDto.getType()
//        );

        Employee employee = new Employee(
                employeeDto.getId(),
                employeeDto.getFirst_name(),
                employeeDto.getLast_name(),
                employeeDto.getSalary(),
                company
               // contactEmployee
        );

        employeeDao.save(employee);
        return employee;

    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,
            readOnly = true)
    public Optional<Employee> findEmployeeById(String id) {
       return employeeDao.findById(id);

    }

    @Override
    public List<Employee> findAllEmployee() {
        return employeeDao.findAll();
    }

    @Override
    public boolean deleteEmployee(String id) {
        return employeeDao.delete(id);
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        return employeeDao.update(employee);
    }
}
