package by.nata.data.dao;

import by.nata.data.pojo.Expenses;
import by.nata.data.pojo.Receivers;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public interface Dao {
        void save ();

        Receivers findById(Long id);

        boolean delete (Long id);

        Receivers get ( Long id);
        Receivers load(Long id);

        void delete(Expenses expense);




}
