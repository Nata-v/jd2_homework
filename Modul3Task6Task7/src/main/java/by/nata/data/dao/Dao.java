package by.nata.data.dao;


import by.nata.data.pojo.Product;
import org.hibernate.HibernateException;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;


public interface Dao {
    void save(Object object);

    List<Object> findAll();

    Product getIdentifier(Product product);



}
