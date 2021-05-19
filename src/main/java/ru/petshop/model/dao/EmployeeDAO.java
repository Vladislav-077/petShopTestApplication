package ru.petshop.model.dao;

import ru.petshop.model.Employee;

import java.util.List;

public interface EmployeeDAO {

    Boolean create(Employee employee);
    Boolean delete(Employee employee);
    Boolean update(Employee employee);

    List<Employee> getAllEmployee();
    List<Employee> findEmployeeByName(Employee employee);
}
