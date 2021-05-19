package ru.petshop.services;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.petshop.model.Employee;
import ru.petshop.model.dao.EmployeeDAO;

import java.util.Collection;

@Log4j2
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Transactional
    @Override
    public Boolean add(Employee employee) {
        return employeeDAO.create(employee);
    }

    @Transactional
    @Override
    public Boolean update(Employee employee) {
        return employeeDAO.update(employee);
    }

    @Transactional
    @Override
    public Boolean delete(Employee employee) {
        return employeeDAO.delete(employee);
    }

    @Transactional
    @Override
    public Collection<Employee> searchEmployeeByName(String name) {
        Employee employee = new Employee();
        employee.setName(name);
        return employeeDAO.findEmployeeByName(employee);
    }

    @Transactional
    @Override
    public Collection<Employee> getAllEmployee() {
        return employeeDAO.getAllEmployee();
    }
}
