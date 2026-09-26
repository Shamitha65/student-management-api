package com.example.studentapi.repository;

import com.example.studentapi.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository
        extends JpaRepository<Student, Long> {

    List<Student> findByNameContainingIgnoreCase(String name);

    @Query("""
           SELECT s
           FROM Student s
           WHERE LOWER(s.department.name) = LOWER(:departmentName)
           """)
    List<Student> findByDepartmentName(
            @Param("departmentName") String departmentName
    );
}