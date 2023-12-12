package com.practice.facebook.Repo;

import com.practice.facebook.Entity.Bike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BikeRepo extends JpaRepository<Bike, Long> {
}
