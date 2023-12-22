package by.nata.annotations.database.dao;

import by.nata.annotations.database.entity.Company1;
import by.nata.annotations.database.entity.CompanyAddress1;
import by.nata.annotations.database.entity.ContactEmployee1;
import by.nata.annotations.database.entity.Employee1;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
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
    public Employee1 save(Employee1 employee) {
        if (employee == null) {
            throw new IllegalArgumentException("Object can't be null");
        }
        Session session = null;

        session = sessionFactory.getCurrentSession();


        employee = new Employee1(null, "Natali", "Volkova", 5000.00,
                new Company1(null, "Google", LocalDate.now(),
                        new CompanyAddress1("New-York", "Manhattan", "111111")),
                new ContactEmployee1("256-44-88", "Домашний"));

        session.saveOrUpdate(employee);

        session.flush();
        return employee;
    }

    @Override
    public Optional<Employee1> findById(String id) {
        Session session = null;

        Employee1 employee;
        session = sessionFactory.getCurrentSession();

        employee = session.get(Employee1.class, id);


        return Optional.ofNullable(employee);

    }

}
