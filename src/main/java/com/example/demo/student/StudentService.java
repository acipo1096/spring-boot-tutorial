package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

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
