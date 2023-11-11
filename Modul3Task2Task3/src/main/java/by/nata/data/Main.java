package by.nata.data;

import by.nata.data.dao.HibernateRun;
import by.nata.data.pojo.Receivers;
import by.nata.data.util.HibernateUtil;
import org.hibernate.SessionFactory;

public class Main {
    public static void main(String[] args) {

            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            HibernateRun hibernateRun = new HibernateRun(sessionFactory);


            hibernateRun.save();
            Receivers receiver = hibernateRun.findById(1L);
            System.out.println("Receiver name: " + receiver.getName());
            hibernateRun.delete(5L);
            Receivers receiver2 = hibernateRun.get(1L);
            System.out.println("Receiver name: " + receiver2.getName());
            Receivers receiver3 = hibernateRun.load(4L);
            System.out.println("Receiver name: " + receiver3.getName());



            sessionFactory.close();

    }
}