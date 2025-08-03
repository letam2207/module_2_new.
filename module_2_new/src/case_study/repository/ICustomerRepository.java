package case_study.repository;

import case_study.entity.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> findAll();

    void add(Customer customer);

    boolean delete(String id);

    Customer findById(String id);

    List<Customer> findByName(String name);

    void updateById(String id, Customer customer);
}
