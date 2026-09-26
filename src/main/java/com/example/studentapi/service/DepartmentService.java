package com.example.studentapi.service;

import com.example.studentapi.entity.Department;
import com.example.studentapi.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(
            DepartmentRepository departmentRepository) {

        this.departmentRepository = departmentRepository;
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(Long id) {

        return departmentRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Department not found with id: " + id
                        ));
    }

    public Department createDepartment(
            Department department) {

        return departmentRepository.save(department);
    }

    public Department updateDepartment(
            Long id,
            Department department) {

        Department existing =
                getDepartmentById(id);

        existing.setName(department.getName());

        return departmentRepository.save(existing);
    }

    public void deleteDepartment(Long id) {

        if (!departmentRepository.existsById(id)) {
            throw new RuntimeException(
                    "Department not found with id: " + id
            );
        }

        departmentRepository.deleteById(id);
    }
}