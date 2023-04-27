package com.task.department.service;

import com.task.department.model.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    public Department addDept(Department department);

    public List<Department> viewDept();

    public Optional<Department> listById(int departId);

    public void deleteDept(int departId);

    public Department updateDept(int departId, Department department);
}
