package by.nata.data;

import by.nata.data.dao.HibernateRunDao;
import by.nata.data.utils.HibernateUtil;
import org.hibernate.SessionFactory;

public class Main {
    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        HibernateRunDao hibernateRunDao = new HibernateRunDao(sessionFactory);

        hibernateRunDao.saveInTablePerClass(new Object());
        hibernateRunDao.findAll();
        hibernateRunDao.getById(5L);
hibernateRunDao.saveInSingleTable(new Object());
hibernateRunDao.saveInJoinedTable(new Object());

        sessionFactory.close();
    }
}
