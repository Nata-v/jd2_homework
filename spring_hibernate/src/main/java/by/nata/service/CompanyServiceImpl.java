package by.nata.service;

import by.nata.data.dao.CompanyDao;
import by.nata.data.entity.Company;
import by.nata.data.entity.CompanyAddress;
import by.nata.dto.CompanyAddressDto;
import by.nata.dto.CompanyDto;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service

public class CompanyServiceImpl implements CompanyService{


        private final CompanyDao companyDao;

        @Autowired
        public CompanyServiceImpl(CompanyDao companyDao) {

            this.companyDao = companyDao;
        }

//        @Override
//
//        public Company saveCompany(CompanyDto companyDto, CompanyAddressDto companyAddressDto) {
//
//            return companyDao.save(companyDto, companyAddressDto);
//        }

        @Override
        @Transactional(propagation = Propagation.SUPPORTS,
                readOnly = true)
        public Optional<Company> findCompanyById(String id) {

            return companyDao.findById(id);
        }

        @Override
        @Transactional(readOnly = true)
        public List<Company> findAllCompanies() {
            return companyDao.findAll();
        }

        @Override
        public boolean deleteCompany(String id) {
            return companyDao.delete(id);
        }

        @Override
        public boolean updateCompany(Company company) {
            return companyDao.update(company);
        }

}
