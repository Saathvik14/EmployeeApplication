package com.task.employee.model;


import lombok.*;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    @Id
    private int employeeId;

    private String employeeName;

    private double salary;


}
