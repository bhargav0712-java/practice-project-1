package com.practice.facebook.Service;

import com.practice.facebook.Entity.Student;
import com.practice.facebook.Repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{
    private final StudentRepo studentRepo;

    @Autowired
    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }
    @Override
    public List<Student> getAllList() {
        return studentRepo.findAll();
    }
    @Override
    public Student createNew(Student student) {
        return studentRepo.save(student);
    }
    @Override
    public Optional<Student> updateBike(Long rollNo, Student student) {
        if(studentRepo.existsById(rollNo)){
            return Optional.of(studentRepo.save(student));
        } else  return
                Optional.empty();
    }
    @Override
    public Optional<Student> getById(Long rollNo) {
        if(studentRepo.existsById(rollNo)){
          return studentRepo.findById(rollNo);
        }
        return Optional.empty();
    }
    @Override
    public void deleteById(Long rollNo) {
     studentRepo.deleteById(rollNo);
    }



    public Optional<Student> findByName(String studentName){
      if (studentRepo.existsByStudentName(studentName)){
          return studentRepo.findByStudentNameIgnoreCase(studentName);
      } return Optional.empty();
    }
    public List<Student> findByDateOfBirthA(Date dateOfBirth){
        return studentRepo.findByDateOfBirthAfter(dateOfBirth);
    }


}
