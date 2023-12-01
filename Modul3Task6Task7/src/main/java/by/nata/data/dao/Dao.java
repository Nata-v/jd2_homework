package by.nata.data.dao;


import by.nata.data.pojo.Company;
import by.nata.data.pojo.Product;
import java.util.List;



public interface Dao {
    void save(Object object);

    List<Company> findAll();

    Product getIdentifier(Product product);



}
