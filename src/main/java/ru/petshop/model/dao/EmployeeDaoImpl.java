package ru.petshop.model.dao;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.petshop.mapper.EmployeeMapper;
import ru.petshop.model.Employee;
import ru.petshop.model.PositionEnum;

import java.util.List;

@Repository
@Log4j2
public class EmployeeDaoImpl implements EmployeeDAO {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public Boolean create(Employee employee) {
        Integer positionId = PositionEnum.getPositionIndexByPositionName(employee.getPositionName());
        return employeeMapper.insertEmployee(employee.getName(),employee.getLastName(),employee.getAge(),positionId);
    }

    @Override
    public Boolean delete(Employee employee) {
        Integer positionId = PositionEnum.getPositionIndexByPositionName(employee.getPositionName());
        return employeeMapper.deleteEmployeeByName(employee.getId(),employee.getName(), employee.getLastName(), employee.getAge(), positionId);
    }

    @Override
    public Boolean update(Employee employee) {
        Integer positionId = PositionEnum.getPositionIndexByPositionName(employee.getPositionName());
        return employeeMapper.updateEmployeeById(employee.getName(), employee.getLastName(), employee.getAge(), positionId,employee.getId());
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeMapper.getAllEmployee();
    }

    @Override
    public List<Employee> findEmployeeByName(Employee employee) {
        return employeeMapper.getEmployeeByName(employee.getName());
    }
}
