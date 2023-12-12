package com.practice.facebook.Service;

import com.practice.facebook.Entity.Result;
import com.practice.facebook.Repo.ResultRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResultServiceImpl implements ResultService {
    private final ResultRepo resultRepo;
   @Autowired
    public ResultServiceImpl(ResultRepo resultRepo) {
        this.resultRepo = resultRepo;
    }
    @Override
    public List<Result> getAllList() {
        return resultRepo.findAll();
    }
    @Override
    public Result createNew(Result result) {
        return resultRepo.save(result);
    }
    @Override
    public Result updateOld(Long rollNo, Result result) {
        if (resultRepo.existsById(rollNo)){
            return resultRepo.save(result);
        } return null;
    }
    @Override
    public Optional<Result> findByRollNo(Long rollNo) {
        return resultRepo.findById(rollNo);
    }
    @Override
    public void deleteByRollNo(Long rollNo) {
     resultRepo.deleteById(rollNo);
    }
    public List<Result> findByStudentName(String studentName){
        return resultRepo.findByStudentNameIgnoreCase(studentName);
    }
    public List<Result> findByBranch(String branch){
        return resultRepo.findByBranchIgnoreCase(branch);
    }
    public List<Result> findByResult(String result){
        return resultRepo.findByResult(result);
    }
    public Result findByEmail(String email){
        return resultRepo.findByEmailIgnoreCase(email);
    }
    public Result findByStudentNameEmail(String studentName, String email){
        return resultRepo.findByStudentNameAndEmailIgnoreCase(studentName,email);
    }
    public List<Result> findByStudentNamePartial(String partialName){
        return resultRepo.findByStudentNameContainingIgnoreCase(partialName);
    }













}
