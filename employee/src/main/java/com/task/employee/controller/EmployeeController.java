package com.task.employee.controller;


import com.task.employee.model.Department;
import com.task.employee.model.Employee;
import com.task.employee.service.DepartmentService;
import com.task.employee.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/emp")
public class EmployeeController {

    Logger logger= LoggerFactory.getLogger(EmployeeController.class);


    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/addemp")
    public Employee addEmpl(@RequestBody Employee employee) {
        logger.info("[addemp] info message added");
        return employeeService.addEmpl(employee);
    }

    @GetMapping("/listempl")
    public List<Employee> getEmpl() {
        logger.info("[listempl] info message added");
        return employeeService.getempl();
    }

    @GetMapping("/viewbyid/{employeeId}")
    public Optional<Employee> listById(@PathVariable("employeeId") int employeeId) {
        logger.info("[viewbyid] info message added");
        return employeeService.listById(employeeId);
    }


    @DeleteMapping("/delete/{employeeId}")
    public String deleteEmpl(@PathVariable("employeeId") int employeeId) {
        logger.info("[delete/emplId] info message added");
        employeeService.deleteEmpl(employeeId);
        return "data deleted successfully";
    }

    @PutMapping("/update/{employeeId}")
    public Employee updateEmpl(@RequestBody Employee employee, @PathVariable("employeeId") int employeeId) {
        logger.info("[update/emplId] info message added");
        return employeeService.updateEmpl(employeeId, employee);
    }


    //Department Controller Operation

    @PostMapping("/addDept")

    public ResponseEntity addDept( @RequestBody Department department){
        logger.info("[addDept] info message added");
        return departmentService.addDept(department);
    }


    @GetMapping("/listdepartments")

    public ResponseEntity listdepartments() {
        logger.info("[listdepartments] info message added");
        return departmentService.listdepartments();
    }


    @PutMapping("/update/{departId}")

    public ResponseEntity updateDepart(@RequestBody Department department, @PathVariable(value = "departId") int departId){
        logger.info("[update/departId] info message added");
        return departmentService.updateDepart(department,departId);
    }

}
