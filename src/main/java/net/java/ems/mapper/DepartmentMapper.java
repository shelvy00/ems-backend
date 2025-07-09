package net.java.ems.mapper;

import net.java.ems.dto.DepartmentDto;
import net.java.ems.entity.Department;

public class DepartmentMapper {

    // convert department jpa entity into department dto

    public static DepartmentDto mapToDepartmentDto(Department department) {
        return  new DepartmentDto(department.getId(), department.getDepartmentName(), department.getGetDepartmentDescription());
    }

    // convert department dto into department jpa entity
    public static Department mapToDepartment(DepartmentDto departmentDto) {
        return new Department(departmentDto.getId(), departmentDto.getDepartmentName(), departmentDto.getDepartmentDescription());
    }
}
