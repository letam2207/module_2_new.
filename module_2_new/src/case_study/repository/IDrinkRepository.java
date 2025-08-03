package case_study.repository;

import case_study.entity.Customer;
import case_study.entity.Drink;

import java.util.List;

public interface IDrinkRepository {
    List<Drink> findAll();

    void add(Drink drink);

    boolean delete(String id);

    Drink findById(String id);

    void updateById(String id, Drink drink);

    List<Drink> findByName(String name);
}
