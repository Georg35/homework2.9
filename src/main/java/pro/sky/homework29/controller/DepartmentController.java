package pro.sky.homework29.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.homework29.exception.EmployeeNotFoundException;
import pro.sky.homework29.model.Employee;
import pro.sky.homework29.service.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @GetMapping("/max-salary")
    public Employee findEmployeeMaxSalaryInDepartment(@RequestParam int dep) {
        return service.findEmployeeMaxSalaryInDepartment(dep);
    }

    @GetMapping("/min-salary")
    public Employee findEmployeeMinSalaryInDepartment(@RequestParam int dep) {
        return service.findEmployeeMinSalaryInDepartment(dep).orElseThrow(EmployeeNotFoundException::new);
    }

    @GetMapping(value = "/all",params = "department")
    public List<Employee> findAllDepartment(@RequestParam("department") int dep) {
        return service.findAllDepartment(dep);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> findAllDepartmentAll() {
        return service.findAllDepartmentAll();
    }
}



