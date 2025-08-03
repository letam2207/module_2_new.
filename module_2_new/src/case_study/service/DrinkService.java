package case_study.service;

import case_study.entity.Drink;
import case_study.entity.OrderItem;
import case_study.repository.DrinkRepository;
import case_study.repository.IDrinkRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DrinkService implements IDrinkService {

    private static final IDrinkRepository DRINK_SERVICE = new DrinkRepository();

    @Override
    public List<Drink> findAll() {
        return DRINK_SERVICE.findAll();
    }

    @Override
    public void add(Drink drink) {
        DRINK_SERVICE.add(drink);
    }

    @Override
    public boolean delete(String id) {
        return DRINK_SERVICE.delete(id);
    }

    @Override
    public Drink findById(String id) {
        return DRINK_SERVICE.findById(id);
    }

    @Override
    public void updateById(String id, Drink drink) {
        DRINK_SERVICE.updateById(id, drink);
    }

    @Override
    public List<Drink> findByName(String name) {
        return DRINK_SERVICE.findByName(name);
    }

    @Override
    public void displayAllGroupedByType() {
        List<Drink> drinks = DRINK_SERVICE.findAll();

        if (drinks.isEmpty()) {
            System.out.println("⚠ Danh sách món nước trống.");
            return;
        }

        Map<String, List<Drink>> groupedMap = new TreeMap<>();
        for (Drink drink : drinks) {
            groupedMap.computeIfAbsent(drink.getType(), k -> new ArrayList<>()).add(drink);
        }

        for (String type : groupedMap.keySet()) {
            System.out.println("\n===== Loại: " + type + " =====");
            System.out.println(Drink.getTableHeader());
            System.out.println(Drink.getTableDivider());

            for (Drink drink : groupedMap.get(type)) {
                System.out.println(drink);
            }
        }
    }

    @Override
    public void updateQuantitiesAfterOrder(List<OrderItem> items) {
        for (OrderItem item : items) {
            Drink orderedDrink = item.getDrink();
            int orderedQuantity = item.getQuantity();

            Drink drinkInStock = DRINK_SERVICE.findById(orderedDrink.getId());
            if (drinkInStock != null) {
                int newQuantity = drinkInStock.getQuantity() - orderedQuantity;

                if (newQuantity < 0) {
                    System.out.println("⚠ Không đủ số lượng tồn kho cho món: " + drinkInStock.getName());
                    continue;
                }

                drinkInStock.setQuantity(newQuantity);
                DRINK_SERVICE.updateById(drinkInStock.getId(), drinkInStock);
            }
        }
    }


}
