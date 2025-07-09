package net.java.ems.service.impl;

import lombok.AllArgsConstructor;
import net.java.ems.dto.DepartmentDto;
import net.java.ems.entity.Department;
import net.java.ems.exception.ResourceNotFoundException;
import net.java.ems.mapper.DepartmentMapper;
import net.java.ems.repository.DepartmentRepository;
import net.java.ems.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public DepartmentDto getDepartmentById(Long departmentId) {
      Department department =  departmentRepository.findById(departmentId)
              .orElseThrow(() -> new ResourceNotFoundException("Department is not found with id: " + departmentId));

        return DepartmentMapper.mapToDepartmentDto(department);
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
       List<Department> departments = departmentRepository.findAll();
        return departments.stream().map((department) -> DepartmentMapper.mapToDepartmentDto(department))
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentDto updateDepartment(Long departmentId, DepartmentDto updatedDepartment) {

        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Department is not found with id: " + departmentId));

        department.setDepartmentName(updatedDepartment.getDepartmentName());
        department.setGetDepartmentDescription(updatedDepartment.getDepartmentDescription());

        Department savedDepartment = departmentRepository.save(department);

        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        departmentRepository.findById(departmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Department is not found with id: " + departmentId));
        departmentRepository.deleteById(departmentId);
    }


}
