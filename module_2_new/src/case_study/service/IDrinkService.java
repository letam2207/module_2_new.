package case_study.service;

import case_study.entity.Customer;
import case_study.entity.Drink;
import case_study.entity.OrderItem;

import java.util.List;

public interface IDrinkService {
    List<Drink> findAll();

    void add(Drink drink);

    boolean delete(String id);

    Drink findById(String id);

    void updateById(String id, Drink drink);

    List<Drink> findByName(String name);

    void displayAllGroupedByType();

    void updateQuantitiesAfterOrder(List<OrderItem> items);
}
