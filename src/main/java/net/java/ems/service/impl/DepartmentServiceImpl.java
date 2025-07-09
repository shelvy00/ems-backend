package net.java.ems.service.impl;

import lombok.AllArgsConstructor;
import net.java.ems.dto.DepartmentDto;
import net.java.ems.entity.Department;
import net.java.ems.mapper.DepartmentMapper;
import net.java.ems.repository.DepartmentRepository;
import net.java.ems.service.DepartmentService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;
    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        Department department = DepartmentMapper.mapToDepartment(departmentDto);
        Department savedDepartment = departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }
}
