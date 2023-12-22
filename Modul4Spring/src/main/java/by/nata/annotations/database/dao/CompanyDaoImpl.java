package by.nata.annotations.database.dao;

import by.nata.annotations.database.dao.CompanyDao;
import by.nata.annotations.database.entity.Company1;
import by.nata.annotations.database.entity.CompanyAddress1;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public class CompanyDaoImpl implements CompanyDao {

    private final SessionFactory sessionFactory;


@Autowired
    public CompanyDaoImpl(SessionFactory sessionFactory) {
        if (sessionFactory == null) {
            throw new IllegalArgumentException("An argument sessionFactory cannot be null");
        }
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Company1 save(Company1 company) {
        if (company == null) {
            throw new IllegalArgumentException("Object can't be null");
        }
        Session session = null;
        session = sessionFactory.getCurrentSession();

        company = new Company1(null, "Microsoft", LocalDate.of(2024, 05, 10),
                new CompanyAddress1("New-York", "Manhattan", "111111"));


        session.saveOrUpdate(company);

        session.flush();

        return company;
    }



    @Override
    public Optional<Company1> findById(String id) {
        Session session = null;
        Company1 company;

        session = sessionFactory.getCurrentSession();

        company = session.get(Company1.class, id);

        return Optional.ofNullable(company);
    }
}
