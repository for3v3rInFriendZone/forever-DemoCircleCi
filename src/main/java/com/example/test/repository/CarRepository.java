package com.example.test.repository;

import com.example.test.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findByOwnerId(Long ownerId);
}
