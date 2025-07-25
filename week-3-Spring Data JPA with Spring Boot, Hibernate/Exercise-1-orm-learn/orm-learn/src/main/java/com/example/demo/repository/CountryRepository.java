package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
    // No methods needed for basic CRUD
}
