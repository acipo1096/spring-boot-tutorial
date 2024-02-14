package com.example.demo.student;

// Now starting the data layer

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // Long corresponds with our declared ID
}
