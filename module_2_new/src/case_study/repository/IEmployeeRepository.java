package case_study.repository;

import case_study.entity.Customer;
import case_study.entity.Employee;

import java.util.List;

public interface IEmployeeRepository {
    List<Employee> findAll();

    void add(Employee employee);

    boolean delete(String id);

    Employee findById(String id);

    List<Employee> findByName(String name);

    void updateById(String id, Employee employee);
}
