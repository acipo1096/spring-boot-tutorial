package com.example.demo.student;

// Now starting the data layer

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // Long corresponds with our declared ID

    // Transforms into SQL
    // SELECT * FROM student WHERE...
    // OR - the below is "JPQL"
    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);
}

