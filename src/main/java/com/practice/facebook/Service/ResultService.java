package com.practice.facebook.Service;

import com.practice.facebook.Entity.Result;

import java.util.List;
import java.util.Optional;

public interface ResultService {
    List<Result> getAllList();

    Result createNew(Result result);
    Result updateOld(Long rollNo, Result result);

    Optional<Result> findByRollNo(Long rollNo);

    void deleteByRollNo(Long rollNo);



}
