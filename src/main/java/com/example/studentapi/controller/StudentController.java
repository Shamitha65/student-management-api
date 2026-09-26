package com.example.studentapi.controller;

import com.example.studentapi.entity.Student;
import com.example.studentapi.service.StudentService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(
            StudentService studentService) {

        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<Student>>
    getAllStudents() {

        return ResponseEntity.ok(
                studentService.getAllStudents()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student>
    getStudentById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                studentService.getStudentById(id)
        );
    }

    @PostMapping
    public ResponseEntity<Student>
    createStudent(
            @Valid @RequestBody Student student) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        studentService
                                .createStudent(student)
                );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student>
    updateStudent(
            @PathVariable Long id,
            @Valid @RequestBody Student student) {

        return ResponseEntity.ok(
                studentService
                        .updateStudent(id, student)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>
    deleteStudent(
            @PathVariable Long id) {

        studentService.deleteStudent(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Student>>
    searchStudents(
            @RequestParam String name) {

        return ResponseEntity.ok(
                studentService.searchStudents(name)
        );
    }

    @GetMapping("/department/{departmentName}")
    public ResponseEntity<List<Student>>
    findByDepartment(
            @PathVariable String departmentName) {

        return ResponseEntity.ok(
                studentService.findByDepartment(
                        departmentName
                )
        );
    }
}