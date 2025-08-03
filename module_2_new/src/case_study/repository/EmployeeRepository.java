package case_study.repository;

import case_study.common.ReadAndWrite;
import case_study.entity.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {

    private final String EMPLOYEE_FILE = "src/case_study/data/employee.csv";

    @Override
    public List<Employee> findAll() {
        List<Employee> employeeList = new ArrayList<>();
        List<String> stringList = ReadAndWrite.readFileCSV(EMPLOYEE_FILE);
        for (String s : stringList) {
            String[] array = s.split("\\s*,\\s*");
            employeeList.add(new Employee(array[0], array[1], array[2], array[3], array[4]));
        }
        return employeeList;
    }

    @Override
    public void add(Employee employee) {
        List<String> stringList = new ArrayList<>();
        stringList.add(employee.getInfoToFIle());
        ReadAndWrite.writeFileCSV(EMPLOYEE_FILE, stringList, true);
    }

    @Override
    public boolean delete(String id) {
        List<Employee> employeeList = findAll();
        boolean check = false;
        for (int i = 0; i < employeeList.size(); i++) {
            if (id.equals(employeeList.get(i).getId())) {
                check = true;
                employeeList.remove(i);
                break;
            }
        }
        List<String> stringList = new ArrayList<>();
        for (Employee e : employeeList) {
            stringList.add(e.getInfoToFIle());
        }
        ReadAndWrite.writeFileCSV(EMPLOYEE_FILE, stringList, false);
        return check;
    }

    @Override
    public Employee findById(String id) {
        for (Employee e : findAll()) {
            if (e.getId().equals(id)) {
                return e;
            }
        }
        return null;
    }

    @Override
    public List<Employee> findByName(String name) {
        List<Employee> employees = findAll();
        List<Employee> employeeList = new ArrayList<>();
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getName().toLowerCase().contains(name.toLowerCase())) {
                employeeList.add(employees.get(i));
            }
        }
        return employeeList;
    }

    @Override
    public void updateById(String id, Employee employee) {
        List<Employee> employees = findAll();
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId().equals(employee.getId())) {
                employees.set(i, employee);
                break;
            }
        }
        List<String> stringList = new ArrayList<>();
        for (Employee e : employees) {
            stringList.add(e.getInfoToFIle());
        }
        ReadAndWrite.writeFileCSV(EMPLOYEE_FILE, stringList, false);
    }
}
