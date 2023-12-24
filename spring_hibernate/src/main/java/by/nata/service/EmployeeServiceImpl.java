package by.nata.service;

import by.nata.data.dao.EmployeeDao;
import by.nata.data.entity.Employee;
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
    @Transactional(readOnly = true)
    public Employee saveEmployee(Employee employee) {

        return employeeDao.save(employee);
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
