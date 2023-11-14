package by.nata.data;

import by.nata.data.dao.HibernateRun;
import by.nata.data.pojo.Company;
import by.nata.data.pojo.CompanyAddress;
import by.nata.data.pojo.Employee;
import by.nata.data.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

public class Main {
        public static void main(String[] args) {

            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            HibernateRun hibernateRun = new HibernateRun(sessionFactory);

            hibernateRun.save(new Object());
            hibernateRun.findAll();


                   sessionFactory.close();
        }
    }



