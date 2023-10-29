package pro.sky.homework29.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.homework29.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService service;
}

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @GetMapping("/max-salary")
    public Employee findEmployeeMaxSalaryInDepartment(@RequestParam int dep) {
        return service.finddEmployeeMaxSalaryInDepartment(dep);
    }
