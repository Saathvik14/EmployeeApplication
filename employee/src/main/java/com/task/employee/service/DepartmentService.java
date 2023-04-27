package com.task.employee.service;

import com.task.employee.model.Department;
import com.task.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class DepartmentService {

    @Autowired
    private RestTemplate restTemplate;

    //Add department Operation
    public ResponseEntity addDept(Department department)throws HttpClientErrorException {
        try {
            Department addDept = restTemplate.postForObject("http://Department-Service/dept/addDept", department, Department.class);
            return new ResponseEntity<>(addDept, HttpStatus.OK);
        }catch (HttpClientErrorException httpClientErrorException){
            return new ResponseEntity(httpClientErrorException.getResponseBodyAsString(),HttpStatus.CONFLICT );
        }

    }

    //update Department operation
    public ResponseEntity updateDepart(Department department,int departId) throws HttpClientErrorException{
        try {
            restTemplate.put("http://Department-Service/dept/update" + departId, Department.class);
            return new ResponseEntity(HttpStatus.OK);
        }catch(HttpClientErrorException httpClientErrorException){
            return new ResponseEntity(httpClientErrorException.getResponseBodyAsString(),HttpStatus.CONFLICT );
        }
    }


    //View All Department Operation
    public ResponseEntity<Department[]> listdepartments() throws HttpClientErrorException {
        try {
            Department[] response = restTemplate.getForEntity("http://Department-Service/dept/viewdept"
                    , Department[].class).getBody();
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (HttpClientErrorException httpClientErrorException){
            return new ResponseEntity(httpClientErrorException.getResponseBodyAsString(),HttpStatus.CONFLICT );
        }
    }
}
