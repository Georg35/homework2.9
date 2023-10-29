package pro.sky.homework29.service;

import org.springframework.stereotype.Service;
import pro.sky.homework29.exception.EmployeeAlreadyAddedException;
import pro.sky.homework29.exception.EmployeeNotFoundException;
import pro.sky.homework29.model.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    Map<String, Employee> employeeMap = new HashMap<>(Map.of(
            "ИванИванов",
            new Employee(

                    "Иван",
                    "Иванов",
                    24000.0,
                    3),


            "ПетрПетров",
            new Employee(
                    "Петр",
                    "Петров",
                    37000.0,
                    5),

            "СидорСидоров",
            new Employee(
                    "Сидр",
                    "Сидоров",
                    36000.0,
                    2),
            "ТимофейТимофеев",
            new Employee(
                    "Тимофей",
                    "Тимофеев",
                    27000.0,
                    1),
            "СергейСергеев",
            new Employee(
                    "Сергей",
                    "Сергеев",
                    44000.0,
                    1)


    ));

    @Override

    public List<Employee> createList(Map<String, Employee> emplMap) {
        final List<Employee> employees = new ArrayList<>();
        for (Employee employee : employeeMap.values()) {
            employees.add(employee);
        }
        return employees;
    }


    @Override

    public Employee add(String firstName, String lastName, double salary, int deparment) {
        Employee employee = new Employee(firstName, lastName, salary, deparment);
        String s = firstName + lastName;
        if (employeeMap.containsKey(s)) {
            throw new EmployeeAlreadyAddedException();
        }
        employeeMap.put(s, employee);
        return employee;
    }

    @Override

    public Employee remove(String firstName, String lastName) {

        String s = firstName + lastName;
        if (employeeMap.containsKey(s)) {
            employeeMap.remove(s);
            return employeeMap.get(s);
        }
        throw new EmployeeNotFoundException();

    }

    @Override

    public Employee find(String firstName, String lastName) {
        String s = firstName + lastName;
        if (employeeMap.containsKey(s)) {
            return employeeMap.get(s);
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Map<String, Employee> findAll() {
        return employeeMap;
    }
}
