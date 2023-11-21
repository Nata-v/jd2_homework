package by.nata.data.dao;

import by.nata.data.pojo.Person;

import java.util.List;

public interface Dao {
    void saveInSingleTable(Object object);
    void saveInJoinedTable(Object object);
    void saveInTablePerClass(Object object);

    List<Person> findAll();
    void getById(Long id);
}
