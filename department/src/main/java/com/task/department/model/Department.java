package com.task.department.model;


import lombok.*;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Department {

    @Id
    private int departId;

    private String departName;
    private String departAddress;


}
