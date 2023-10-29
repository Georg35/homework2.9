package pro.sky.homework29.service;

import pro.sky.homework29.model.Employee;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface DepartmentService {
    Employee findEmployeeMaxSalaryInDepartment(int depart);

    Optional<Employee> findEmployeeMinSalaryInDepartment(int depart);

    List<Employee> findAllDepartment(int depart);

    Map<Integer, List<Employee>> findAllDepartmentAll();
}

