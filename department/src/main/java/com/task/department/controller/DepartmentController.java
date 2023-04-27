package com.task.department.controller;

import com.task.department.model.Department;
import com.task.department.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dept")
public class DepartmentController {

    Logger logger= LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/addDept")
    public Department addDept(@RequestBody Department department){
        logger.info("[addDept] info message added");
        return departmentService.addDept(department);
    }

    @GetMapping("/viewdept")
    public List<Department> viewDept(){
        logger.info("[viewdept] info message added");
        return departmentService.viewDept();
    }

    @GetMapping("/viewbyid/{departId}")
    public Optional<Department> listById(@PathVariable("departId") int departId) {
        logger.info("[viewbyid/{departId}] info message added");
        return departmentService.listById(departId);
    }


    @DeleteMapping("/delete/{departId}")
    public String deleteDept(@PathVariable("departId") int departId) {
        logger.info("[delete/{departId] info message added");

        departmentService.deleteDept(departId);
        return "data deleted successfully";
    }

    @PutMapping("/update/{departId}")
    public Department updateDept(@RequestBody Department department, @PathVariable("departId") int departId) {
        logger.info("[update/{departId}] info message added");
        return departmentService.updateDept(departId, department);
    }



}
