package by.nata.data.dao;

import by.nata.data.entity.Company;
import by.nata.data.entity.CompanyAddress;
import by.nata.dto.CompanyAddressDto;
import by.nata.dto.CompanyDto;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class CompanyDaoImpl implements CompanyDao {
    private final SessionFactory sessionFactory;


    @Autowired
    public CompanyDaoImpl(SessionFactory sessionFactory) {
        if (sessionFactory == null) {
            throw new IllegalArgumentException("An argument sessionFactory cannot be null");
        }
        this.sessionFactory = sessionFactory;
    }

//    @Override
//    public Company save(CompanyDto companyDto, CompanyAddressDto companyAddressDto) {
//        if (companyDto == null) {
//            throw new IllegalArgumentException("Object can't be null");
//        }
//
//       Session session = sessionFactory.getCurrentSession();
////        Company company = new Company(null, "Microsoft", LocalDate.of(2024, 05, 10),
////                new CompanyAddress("Moscow", "Arbat", "1111"));
//
//        Company company = new Company(companyDto.getId() == null ? getMaxProductId() + 1 : companyDto.getId(),
//                companyDto.getName(),
//                companyDto.getCreated_date(),
//                new CompanyAddress(companyAddressDto.getCity(),
//                        companyAddressDto.getStreet(),
//                        companyAddressDto.getPostCode())
//                );
//        session.saveOrUpdate(company);
//
//        session.flush();
//
//        return company;
//    }



    @Override
    public List<Company> findAll() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Company> query = builder.createQuery(Company.class);
        query.from(Company.class);
        return session.createQuery(query).getResultList();

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
    public boolean delete(String id) {
        Session session = null;

        Company company;
        session = sessionFactory.getCurrentSession();

        company = session.get(Company.class, id);
        if (company == null) {
            return false;
        }
        session.delete(company);

        return true;

    }

    @Override
    public boolean update(Company company) {
        if (company != null) {
            company.setId("1");
            company.setName("Facebook");
            company.setCreated_date(LocalDate.of(2024, 01, 15));
            return true;
        }
        return false;
    }
}

