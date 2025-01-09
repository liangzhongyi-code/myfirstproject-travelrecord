package com.example.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.travel.model.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer>{

}
