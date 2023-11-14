package by.nata.data.dao;


import java.util.List;


public interface Dao {
    void save(Object object);

    List<Object> findAll();


}
