package com.enocaProject.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enocaProject.demo.entities.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
	
	

}