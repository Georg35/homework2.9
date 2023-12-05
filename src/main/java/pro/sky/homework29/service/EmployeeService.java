package pro.sky.homework29.service;

import pro.sky.homework29.model.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {


    List<Employee> createList();
    Employee add(String firstName, String lastName, double salary, int deparment);

    Employee remove(String firstName, String lastName);
    Employee find(String firstName, String lastName);

    Map<String, Employee> findAll() ;

}
