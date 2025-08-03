package case_study.repository;

import case_study.common.ReadAndWrite;
import case_study.entity.Drink;

import java.util.ArrayList;
import java.util.List;

public class DrinkRepository implements IDrinkRepository {
    private final String DRINK_FILE = "src/case_study/data/drink.csv";

    @Override
    public List<Drink> findAll() {
        List<Drink> drinkList = new ArrayList<>();
        List<String> stringList = ReadAndWrite.readFileCSV(DRINK_FILE);
        for (String s : stringList) {
            String[] array = s.split("\\s*,\\s*");
            drinkList.add(new Drink(array[0], array[1], array[2], Double.parseDouble(array[3]), Integer.parseInt(array[4])));
        }
        return drinkList;
    }

    @Override
    public void add(Drink drink) {
        List<String> stringList = new ArrayList<>();
        stringList.add(drink.getInfoToFIle());
        ReadAndWrite.writeFileCSV(DRINK_FILE, stringList, true);
    }

    @Override
    public boolean delete(String id) {
        List<Drink> drinkList = findAll();
        boolean check = false;
        for (int i = 0; i < drinkList.size(); i++) {
            if (id.equals(drinkList.get(i).getId())) {
                check = true;
                drinkList.remove(i);
                break;
            }
        }
        List<String> stringList = new ArrayList<>();
        for (Drink d : drinkList) {
            stringList.add(d.getInfoToFIle());
        }
        ReadAndWrite.writeFileCSV(DRINK_FILE, stringList, false);
        return check;
    }

    @Override
    public Drink findById(String id) {
        for (Drink d : findAll()) {
            if (d.getId().equals(id)) {
                return d;
            }
        }
        return null;
    }

    @Override
    public void updateById(String id, Drink drink) {
        List<Drink> drinks = findAll();
        for (int i = 0; i < drinks.size(); i++) {
            if (drinks.get(i).getId().equals(drink.getId())) {
                drinks.set(i, drink);
                break;
            }
        }
        List<String> stringList = new ArrayList<>();
        for (Drink d : drinks) {
            stringList.add(d.getInfoToFIle());
        }
        ReadAndWrite.writeFileCSV(DRINK_FILE, stringList, false);
    }

    @Override
    public List<Drink> findByName(String name) {
        List<Drink> drinks = findAll();
        List<Drink> drinkList = new ArrayList<>();
        for (int i = 0; i < drinks.size(); i++) {
            if (drinks.get(i).getName().toLowerCase().contains(name.toLowerCase())) {
                drinkList.add(drinks.get(i));
            }
        }
        return drinkList;
    }
}
