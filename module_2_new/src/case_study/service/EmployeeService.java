package case_study.service;

import case_study.entity.Employee;
import case_study.repository.EmployeeRepository;
import case_study.repository.IEmployeeRepository;

import java.util.List;

public class EmployeeService implements IEmployeeService {

    private static final IEmployeeRepository EMPLOYEE_REPOSITORY = new EmployeeRepository();

    @Override
    public List<Employee> findAll() {
        return EMPLOYEE_REPOSITORY.findAll();

    }

    @Override
    public void add(Employee employee) {
        EMPLOYEE_REPOSITORY.add(employee);
    }

    @Override
    public boolean delete(String id) {
        return EMPLOYEE_REPOSITORY.delete(id);
    }

    @Override
    public Employee findById(String id) {
        return EMPLOYEE_REPOSITORY.findById(id);
    }

    @Override
    public List<Employee> findByName(String name) {
        return EMPLOYEE_REPOSITORY.findByName(name);
    }

    @Override
    public void updateById(String id, Employee employee) {
        EMPLOYEE_REPOSITORY.updateById(id, employee);
    }
}
