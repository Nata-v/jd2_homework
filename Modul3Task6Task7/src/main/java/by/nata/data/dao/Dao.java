package by.nata.data.dao;


import java.util.List;
import java.util.UUID;


public interface Dao {
    void save(Object object);

    List<Object> findAll();



}
