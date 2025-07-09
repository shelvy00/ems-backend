package net.java.ems.service;

import net.java.ems.dto.DepartmentDto;

public interface DepartmentService {
    DepartmentDto createDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartmentById(Long departmentId);
}
