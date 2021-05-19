package ru.petshop.model;

import lombok.Data;

@Data
public class Employee {
    private Integer id;
    private String name;
    private String lastName;
    private Integer age;
    private String positionName;
}
