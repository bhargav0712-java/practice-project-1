package com.practice.facebook.Controller;

import com.practice.facebook.Entity.Result;
import com.practice.facebook.Service.ResultService;
import com.practice.facebook.Service.ResultServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class ResultController {
    private final ResultService resultService;
    @Autowired
    public ResultController(ResultService resultService, ResultServiceImpl resultServiceimpl) {
        this.resultService = resultService;
        this.resultServiceimpl = resultServiceimpl;
    }
    private final ResultServiceImpl resultServiceimpl;


    @GetMapping("/result")
    public ResponseEntity<List<Result>> gelResult(){
        List<Result> results = resultService.getAllList();
        return new ResponseEntity<>(results, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Result> createNew(@RequestBody Result result){
        Result result1 = resultService.createNew(result);
        return new ResponseEntity<>(result1, HttpStatus.CREATED);
    }
   @PutMapping("/update/{rollNo}")
    public ResponseEntity<Result> updateOld(@PathVariable Long rollNo, @RequestBody Result result){
      Result result1 = resultService.updateOld(rollNo, result);
      if(result1 != null){
          return new ResponseEntity<>(result1, HttpStatus.OK);
      } else {
          return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    }
    @GetMapping("/result/no/{rollNo}")
    public ResponseEntity<Optional<Result>> findByNo(@PathVariable Long rollNo){
        Optional<Result> result = resultService.findByRollNo(rollNo);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{rollNo}")
    public ResponseEntity<Void> deleteById(@PathVariable Long rollNo){
        resultService.deleteByRollNo(rollNo);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/result/branch/{branch}")
    public ResponseEntity<List<Result>> findByBranch(@PathVariable String branch){
       List<Result> results = resultServiceimpl.findByBranch(branch);
       return new ResponseEntity<>(results,HttpStatus.OK);
    }
    @GetMapping("/result/studentName/{studentName}")
    public ResponseEntity<List<Result>> findByStudentName(@PathVariable String studentName){
        List<Result> results = resultServiceimpl.findByStudentName(studentName);
        return new ResponseEntity<>(results,HttpStatus.OK);
    }
    @GetMapping("/result/status/{result}")
    public ResponseEntity<List<Result>> findResult(@PathVariable String result){
        List<Result> results = resultServiceimpl.findByResult(result);
        return new ResponseEntity<>(results,HttpStatus.OK);
    }
    @GetMapping("/result/email/{email}")
    public ResponseEntity<Result> findByEmail(@PathVariable String email){
        Result results = resultServiceimpl.findByEmail(email);
        return new ResponseEntity<>(results, HttpStatus.OK);
    }
    @GetMapping("/result/studentName/email{studentName}/{email}")
    public ResponseEntity<Result> findByStudentNameEmail(@PathVariable String studentName, @PathVariable String email){
        Result results = resultServiceimpl.findByStudentNameEmail(studentName, email);
        return new ResponseEntity<>(results,HttpStatus.OK);
    }
    @GetMapping("/result/partial/{partialName}")
    public ResponseEntity<List<Result>> findByStudentNamePartial(@PathVariable String partialName){
        List<Result> results = resultServiceimpl.findByStudentNamePartial(partialName);
        return new ResponseEntity<>(results,HttpStatus.OK);
    }


}
