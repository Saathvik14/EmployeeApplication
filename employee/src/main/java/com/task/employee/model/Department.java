package com.task.employee.model;


import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Department {

    private int departId;


    private String departName;
    private String departAddress;


}
