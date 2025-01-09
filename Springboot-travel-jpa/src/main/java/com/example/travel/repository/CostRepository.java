package com.example.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.travel.model.entity.Cost;

@Repository
public interface CostRepository extends JpaRepository<Cost, Integer>{

}
