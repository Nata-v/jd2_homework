package by.nata.data;

import by.nata.data.dao.HibernateRun;
import by.nata.data.util.HibernateUtil;
import org.hibernate.SessionFactory;

import java.util.UUID;

public class Main {
        public static void main(String[] args) {

            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            HibernateRun hibernateRun = new HibernateRun(sessionFactory);

            hibernateRun.save(new Object());
            hibernateRun.findAll();



                   sessionFactory.close();
        }
    }



