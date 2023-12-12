package com.practice.facebook.Repo;

import com.practice.facebook.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long> {
    Optional<Student> findByStudentNameIgnoreCase(String studentName);


    boolean existsByStudentName(String studentName);
    List<Student> findByDateOfBirthAfter(Date dateOfBirth);

}
