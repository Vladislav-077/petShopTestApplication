package ru.petshop.mapper;

import org.apache.ibatis.annotations.*;
import ru.petshop.model.Employee;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    /**
     * Получение всех сотрудников
     **/
    @Select("SELECT e.id,e.name,e.lastname,e.age,p.name AS name_position "
            + "FROM employee AS e "
            + "INNER JOIN position AS p "
            + "ON p.positionid = e.positionid "
            + "ORDER BY e.id ASC")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "lastName", column = "lastName"),
            @Result(property = "age", column = "age"),
            @Result(property = "positionName", column = "name_position")})
    List<Employee> getAllEmployee();


    /**
     * Получение сотрудника по имени сотрудника
     *
     * @param name - имя сотрудника
     **/

    @Select("SELECT e.id,e.name,e.lastname,e.age,p.name AS name_position "
            + "FROM employee AS e "
            + "INNER JOIN position AS p "
            + "ON (p.positionid = e.positionid) "
            + "WHERE e.name = #{name}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "lastName", column = "lastName"),
            @Result(property = "age", column = "age"),
            @Result(property = "positionName", column = "name_position")})
    List<Employee> getEmployeeByName(String name);


    /**
     * Добавление сотрудника
     *
     * @param name       - имя сотрудника
     * @param lastname   - фамилия сотрудника
     * @param age        - возраст сотрудника
     * @param positionid - Id должности
     **/

    @Insert("INSERT INTO employee (name,lastName,age,positionId) VALUES(#{name},#{lastname},#{age},#{positionId})")
    Boolean insertEmployee(
            @Param("name") String name,
            @Param("lastname") String lastname,
            @Param("age") Integer age,
            @Param("positionId") Integer positionid);


    /**
     * Обновление информации о сотруднике
     *
     * @param name       - имя сотрудника
     * @param lastName   - фамилия сотрудника
     * @param age        - возраст сотрудника
     * @param positionId - Id должности
     **/
    @Update("UPDATE employee "
            + "SET name = #{name},lastname = #{lastName},age = #{age}, positionid = #{positionId} "
            + "WHERE id = #{employeeId}")
    Boolean updateEmployeeById(
            @Param("name") String name,
            @Param("lastName") String lastName,
            @Param("age") Integer age,
            @Param("positionId") Integer positionId,
            @Param("employeeId") Integer employeeId);


    /**
     * Удаление сотрудника
     *
     * @param name       - имя сотрудника
     * @param lastName   - фамилия сотрудника
     * @param age        - возраст сотрудника
     * @param positionId - ID должности
     **/

    @Delete("DELETE FROM employee AS e " +
            "WHERE e.id =#{id} and e.name = #{name} and e.lastName = #{lastName} and e.age = #{age} and e.positionId = #{positionId}")
    Boolean deleteEmployeeByName(
            @Param("id") Integer id,
            @Param("name") String name,
            @Param("lastName") String lastName,
            @Param("age") Integer age,
            @Param("positionId") Integer positionId);


}
