package com.stonebridge.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Emp {
    private Integer empId;
    private String empName;
    private Double empSalary;
}
