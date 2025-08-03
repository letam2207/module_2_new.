package case_study.service;

import case_study.entity.Customer;
import case_study.repository.CustomerRepository;
import case_study.repository.ICustomerRepository;

import java.util.List;

public class CustomerService implements ICustomerService {

    private static final ICustomerRepository CUSTOMER_REPOSITORY = new CustomerRepository();

    @Override
    public List<Customer> findAll() {
        return CUSTOMER_REPOSITORY.findAll();
    }

    @Override
    public void add(Customer customer) {
        CUSTOMER_REPOSITORY.add(customer);
    }

    @Override
    public boolean delete(String id) {
        return CUSTOMER_REPOSITORY.delete(id);
    }

    @Override
    public Customer findById(String id) {
        return CUSTOMER_REPOSITORY.findById(id);
    }

    @Override
    public List<Customer> findByName(String name) {
        return CUSTOMER_REPOSITORY.findByName(name);
    }

    @Override
    public void updateById(String id, Customer customer) {
        CUSTOMER_REPOSITORY.updateById(id, customer);
    }
}
