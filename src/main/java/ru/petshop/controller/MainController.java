package ru.petshop.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.petshop.model.Employee;
import ru.petshop.services.EmployeeService;

import java.util.Collection;

@Log4j2
@RestController
public class MainController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping(path = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Employee> getEmployee() {
        log.info("GET запрос на получение всех пользователей");
        return employeeService.getAllEmployee();
    }

    @GetMapping(path = "/employee", produces = MediaType.APPLICATION_JSON_VALUE, params = "name")
    public Collection<Employee> getEmployeeByName(@RequestParam("name") String name) {
        log.info("GET запрос на получение пользователя по имени {}", name);
        return employeeService.searchEmployeeByName(name);
    }

    @DeleteMapping(path = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
    public Boolean deleteEmployeeByName(@RequestBody Employee employee) {
        log.info("DELETE запрос на удаление пользователя имя: {}, фамилия: {}, возраст: {}, должность: {}", employee.getName(), employee.getLastName(), employee.getAge(), employee.getPositionName());
        return employeeService.delete(employee);
    }

    @PostMapping(path = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
    public Boolean addedEmployee(@RequestBody Employee employee) {
        log.info("POST запрос на добавление пользователя имя: {}, фамилия: {}, возраст: {}", employee.getName(), employee.getLastName(), employee.getAge(), employee.getPositionName());
        return employeeService.add(employee);

    }

    @PutMapping(path = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
    public Boolean updateEmployee(@RequestBody Employee employee) {
        log.info("PUT запрос на изменение пользователя имя: {}, фамилия: {}, возраст: {}", employee.getName(), employee.getLastName(), employee.getAge(), employee.getPositionName());
        return employeeService.update(employee);
    }

}
