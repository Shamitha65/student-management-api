package com.example.studentapi.service;

import com.example.studentapi.entity.Student;
import com.example.studentapi.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(
            StudentRepository studentRepository) {

        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {

        return studentRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Student not found with id: " + id
                        ));
    }

    public Student createStudent(Student student) {

        return studentRepository.save(student);
    }

    public Student updateStudent(
            Long id,
            Student student) {

        Student existing =
                getStudentById(id);

        existing.setName(student.getName());
        existing.setEmail(student.getEmail());
        existing.setDepartment(student.getDepartment());

        return studentRepository.save(existing);
    }

    public void deleteStudent(Long id) {

        if (!studentRepository.existsById(id)) {
            throw new RuntimeException(
                    "Student not found with id: " + id
            );
        }

        studentRepository.deleteById(id);
    }

    public List<Student> searchStudents(String name) {

        return studentRepository
                .findByNameContainingIgnoreCase(name);
    }

    public List<Student> findByDepartment(
            String departmentName) {

        return studentRepository
                .findByDepartmentName(departmentName);
    }
}