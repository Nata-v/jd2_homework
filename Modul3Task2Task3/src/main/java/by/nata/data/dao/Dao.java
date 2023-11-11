package by.nata.data.dao;

import by.nata.data.pojo.Expenses;
import by.nata.data.pojo.Receivers;

public interface Dao {
        void save ();

        Receivers findById(Long id);
        boolean delete (Long id);

        Receivers get ( Long id);
        Receivers load(Long id);

        void delete(Expenses expense);




}
