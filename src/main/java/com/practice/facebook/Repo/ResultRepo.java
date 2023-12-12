package com.practice.facebook.Repo;

import com.practice.facebook.Entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultRepo extends JpaRepository<Result, Long> {
    List<Result> findByStudentNameIgnoreCase(String studentName);
    List<Result> findByBranchIgnoreCase(String branch);

    List<Result> findByResult(String result);
    Result findByEmailIgnoreCase(String email);

    Result findByStudentNameAndEmailIgnoreCase(String studentName, String email);

    List<Result> findByStudentNameContainingIgnoreCase(String partialName);




}
