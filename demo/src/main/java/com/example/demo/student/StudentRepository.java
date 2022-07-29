package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository //as this interface is respnsible for data access
public interface StudentRepository extends JpaRepository<Student,Long> { //here student is type we want to work upon and Long is the id type which is long that we have defined
//    select * from student where email =?

    @Query("SELECT s FROM Student s WHERE s.email=?1") //s is alias
    Optional<Student> findStudentByEmail(String email);
}
