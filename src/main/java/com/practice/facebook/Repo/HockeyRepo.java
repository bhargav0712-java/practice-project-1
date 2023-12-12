package com.practice.facebook.Repo;

import com.practice.facebook.Entity.Hockey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HockeyRepo extends JpaRepository<Hockey, Long> {
}
