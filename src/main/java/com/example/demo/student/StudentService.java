package com.example.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    public void addNewStudent(Student student) {

        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);
    };

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(()-> new IllegalStateException(
                        "student with id " + studentId + " does not exist"));
                if (name != null && name.length() > 0 && !Objects.equals(student.getName(),name)) {
                    student.setName(name);
                }

                if (email != null &&
                    email.length() > 0 && !Objects.equals(student.getEmail(),email)
                ) {
                    Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
                    if (studentOptional.isPresent()) {
                        throw new IllegalStateException("email taken");
                    }
                    student.setEmail(email);
                }
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if(!exists) {
            throw new IllegalStateException("student with id " + studentId + " does not exist");
        }
        studentRepository.deleteById(studentId);
    }

}
