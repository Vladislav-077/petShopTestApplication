package ru.petshop.services;

import ru.petshop.model.Employee;

import java.util.Collection;

public interface EmployeeService {

    Boolean add(Employee employee);

    Boolean update(Employee employee);

    Boolean delete(Employee employee);

    Collection<Employee> searchEmployeeByName(String name);

    Collection<Employee> getAllEmployee();

}
