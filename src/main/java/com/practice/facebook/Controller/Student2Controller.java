package com.practice.facebook.Controller;

import com.practice.facebook.Entity.Student;
import com.practice.facebook.Service.StudentService;
import com.practice.facebook.Service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student/data")
public class Student2Controller {
    private final StudentService studentService;
    @Autowired
    public Student2Controller(StudentService studentService, StudentServiceImpl studentServiceImpl) {
        this.studentService = studentService;
        this.studentServiceImpl = studentServiceImpl;
    }
    private final StudentServiceImpl studentServiceImpl;

    @PostMapping("/create/new")
    public ResponseEntity<Student> createNew(@RequestBody Student student){
        Student student1 = studentService.createNew(student);
        return new ResponseEntity<>(student1,HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> students = studentService.getAllList();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    @GetMapping("/list/rollNo/{rollNo}")
    public ResponseEntity<Optional<Student>> getById(@PathVariable Long rollNo){
       Optional<Student> studentOptional = studentService.getById(rollNo);
       return new ResponseEntity<>(studentOptional, HttpStatus.OK);
    }
    @GetMapping("/list/studentname/{studentName}")
    public ResponseEntity<Optional<Student>> getByStudentName(@PathVariable String studentName){
        Optional<Student> studentOptional = studentServiceImpl.findByName(studentName);
       if(studentOptional.isPresent()){
           return new ResponseEntity<>(studentOptional, HttpStatus.OK);
       } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    /*public ResponseEntity<Student> getByStudentName(@PathVariable String studentName) {
        Student student = studentServiceImpl.findByName(studentName).orElse(null);
        return new ResponseEntity<>(student, student != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }*/

    @GetMapping("/list/dateOfBirth/{dateOfBirth}")
    public ResponseEntity<List<Student>> findByDateOfBrith(@PathVariable Date dateOfBirth){
        List<Student> students = studentServiceImpl.findByDateOfBirthA(dateOfBirth);
       if(students.isEmpty()){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       } else return new ResponseEntity<>(students, HttpStatus.OK);

    }
    @PutMapping("/update/through/{rollNo}")
    public ResponseEntity<Optional<Student>> updateDetail(@PathVariable Long rollNo, @RequestBody Student student){
        Optional<Student> student1 = studentService.updateBike(rollNo, student);
        if(student1.isPresent()){
            return new ResponseEntity<>(student1, HttpStatus.OK);
        } else return new ResponseEntity<>(student1,HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/delete/{rollNo}")
    public ResponseEntity<Void> deleteById(@PathVariable Long rollNo){
        studentService.deleteById(rollNo);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }


}
