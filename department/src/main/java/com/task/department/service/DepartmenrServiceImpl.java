package com.task.department.service;


import com.task.department.model.Department;
import com.task.department.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmenrServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;


    @Override
    public Department addDept(Department department){
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> viewDept()
    {
        return departmentRepository.findAll();
    }

    @Override
    public Optional<Department> listById(int departId) {
        return departmentRepository.findById(departId);
    }

    @Override
    public void deleteDept(int departId) {
        departmentRepository.deleteById(departId);
    }

    @Override
    public Department updateDept(int departId, Department department) {
        Optional<Department> findById = departmentRepository.findById(departId);
        if(findById.isPresent()){
            Department DepartUpdate=findById.get();
            if(department.getDepartName()!=null && !department.getDepartName().isEmpty())
                DepartUpdate.setDepartName(department.getDepartName());
            return departmentRepository.save(DepartUpdate);
        }
        return null;
    }
}
