package com.practice.facebook.Service;


import com.practice.facebook.Entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> getAllList();

    Student createNew(Student student);
    Optional<Student> updateBike(Long rollNo , Student student);
    Optional<Student> getById(Long rollNo);

    void deleteById(Long rollNo);


}
