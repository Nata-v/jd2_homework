package by.nata.data;

import by.nata.data.util.HibernateUtil;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtilTest extends HibernateUtil{
        private static SessionFactory sessionFactory;
        public static SessionFactory getSessionFactory() {
            if (sessionFactory == null) {
                try {
                    sessionFactory = new Configuration()
                            .configure("test.hibernate.cfg.xml")
                            .buildSessionFactory();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return sessionFactory;
        }


}
