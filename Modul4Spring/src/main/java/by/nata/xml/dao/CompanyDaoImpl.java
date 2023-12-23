package by.nata.xml.dao;

import by.nata.xml.entity.Company;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.time.LocalDate;
import java.util.Optional;

public class CompanyDaoImpl implements CompanyDao{

    private final SessionFactory sessionFactory;



    public CompanyDaoImpl(SessionFactory sessionFactory) {
        if (sessionFactory == null) {
            throw new IllegalArgumentException("An argument sessionFactory cannot be null");
        }
        this.sessionFactory = sessionFactory;
    }

    public void init(){
        System.out.println("Init CompanyDaoImpl");
    }

    public void destroy(){
        System.out.println("Destroy CompanyDaoImpl");
    }



    @Override
    public Company save(Company company) {
        if (company == null) {
            throw new IllegalArgumentException("Object can't be null");
        }
        Session session = null;
        session = sessionFactory.getCurrentSession();

        company = new Company(null, "Microsoft", LocalDate.of(2024, 05, 10));


        session.saveOrUpdate(company);

        session.flush();

        return company;
    }



    @Override
    public Optional<Company> findById(String id) {
        Session session = null;
        Company company;

        session = sessionFactory.getCurrentSession();

        company = session.get(Company.class, id);

        return Optional.ofNullable(company);
    }

    @Override
    public String toString() {
        return "CompanyDaoImpl{" +
                "sessionFactory=" + sessionFactory +
                '}';
    }
}
