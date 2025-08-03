package case_study.repository;

import case_study.common.ReadAndWrite;
import case_study.entity.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {

    private final String CUSTOMER_FILE = "src/case_study/data/customer.csv";

    @Override
    public List<Customer> findAll() {
        List<Customer> customerList = new ArrayList<>();
        List<String> stringList = ReadAndWrite.readFileCSV(CUSTOMER_FILE);
        for (String s : stringList) {
            String[] array = s.split("\\s*,\\s*");
            customerList.add(new Customer(array[0], array[1], array[2], array[3], array[4]));
        }
        return customerList;
    }

    @Override
    public void add(Customer customer) {
        List<String> stringList = new ArrayList<>();
        stringList.add(customer.getInfoToFIle());
        ReadAndWrite.writeFileCSV(CUSTOMER_FILE, stringList, true);
    }

    @Override
    public boolean delete(String id) {
        List<Customer> customerList = findAll();
        boolean check = false;
        for (int i = 0; i < customerList.size(); i++) {
            if (id.equals(customerList.get(i).getId())) {
                check = true;
                customerList.remove(i);
                break;
            }
        }
        List<String> stringList = new ArrayList<>();
        for (Customer c : customerList) {
            stringList.add(c.getInfoToFIle());
        }
        ReadAndWrite.writeFileCSV(CUSTOMER_FILE, stringList, false);
        return check;
    }

    @Override
    public Customer findById(String id) {
        for (Customer c : findAll()) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public List<Customer> findByName(String name) {
        List<Customer> customers = findAll();
        List<Customer> customerList = new ArrayList<>();
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getName().toLowerCase().contains(name.toLowerCase())) {
                customerList.add(customers.get(i));
            }
        }
        return customerList;
    }

    @Override
    public void updateById(String id, Customer customer) {
        List<Customer> customers = findAll();
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId().equals(customer.getId())) {
                customers.set(i, customer);
                break;
            }
        }
        List<String> stringList = new ArrayList<>();
        for (Customer c : customers) {
            stringList.add(c.getInfoToFIle());
        }
        ReadAndWrite.writeFileCSV(CUSTOMER_FILE, stringList, false);
    }

}
