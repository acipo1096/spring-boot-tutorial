package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

// StudentService should be a "Spring Bean"
// We can designate this as a "Service" "Component"
// Means the same thing, different semantics
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    // We are now building our Service Layer
    // This is where business logic is hosted
    public List<Student> getStudents() {
        return studentRepository.findAll(); // returns a list
    }

}
