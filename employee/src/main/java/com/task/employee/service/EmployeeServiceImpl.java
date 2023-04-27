package com.task.employee.service;


import com.task.employee.EmployeeApplication;
import com.task.employee.model.Employee;
import com.task.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public Employee addEmpl(Employee employee){
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getempl()
    {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> listById(int employeeId) {
        return employeeRepository.findById(employeeId);
    }

    @Override
    public void deleteEmpl(int employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    @Override
    public Employee updateEmpl(int employeeId, Employee employee) {
        Optional<Employee> findById = employeeRepository.findById(employeeId);
        if(findById.isPresent()){
            Employee emplUpdate=findById.get();
            if(employee.getEmployeeName()!=null && !employee.getEmployeeName().isEmpty())
                emplUpdate.setEmployeeName(employee.getEmployeeName());
            return employeeRepository.save(emplUpdate);
        }
        return null;
    }



}
