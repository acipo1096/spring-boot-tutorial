package com.example.demo.student;

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
    // We are now building our Service Layer
    // This is where business logic is hosted
    public List<Student> getStudents() {
        return List.of(
                new Student(
                        1L,
                        "Miriam",
                        "miriam.jamal@test.com",
                        LocalDate.of(2000, Month.JANUARY, 5),
                        21
                )
        );
    }

}
