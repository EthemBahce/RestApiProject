package com.enocaProject.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enocaProject.demo.entities.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
