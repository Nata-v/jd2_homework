package by.nata.data.dao;

import by.nata.data.entity.Company;
import by.nata.data.entity.CompanyAddress;
import by.nata.data.entity.ContactEmployee;
import by.nata.data.entity.Employee;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Repository
public class EmployeeDaoImpl implements EmployeeDao{
    private final SessionFactory sessionFactory;
     @Autowired
    public EmployeeDaoImpl(SessionFactory sessionFactory) {
        if (sessionFactory == null) {
            throw new IllegalArgumentException("An argument sessionFactory cannot be null");
        }
        this.sessionFactory = sessionFactory;
    }
    @Override
    public Employee save(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("Object can't be null");
        }
        Session session = null;

        session = sessionFactory.getCurrentSession();


        employee = new Employee(null, "Natali", "Volkova", 5000.00,
                new Company(null, "Google", LocalDate.now(),
                        new CompanyAddress("New-York", "Manhattan", "111111")),
                new ContactEmployee("256-44-88", "Домашний"));

        session.saveOrUpdate(employee);

        session.flush();
        return employee;
    }

    @Override
    public Optional<Employee> findById(String id) {
        Session session = null;

        Employee employee;
        session = sessionFactory.getCurrentSession();

        employee = session.get(Employee.class, id);


        return Optional.ofNullable(employee);

    }

    @Override
    public List<Employee> findAll() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Employee> query = builder.createQuery(Employee.class);
        query.from(Employee.class);
        return session.createQuery(query).getResultList();
    }



    @Override
    public boolean delete(String id) {

        Session session = null;
        Employee employee;
        session = sessionFactory.getCurrentSession();

        employee = session.get(Employee.class, id);
        if (employee == null) {
            return false;
        }
        session.delete(employee);

        return true;
    }

    @Override
    public boolean update(Employee employee) {
        if (employee != null) {
            employee.setId("1");
            employee.setFirst_name("Mikl");
            employee.setLast_name("Smith");
            employee.setSalary(3000.00);

            return true;
        }
        return false;
    }
}
