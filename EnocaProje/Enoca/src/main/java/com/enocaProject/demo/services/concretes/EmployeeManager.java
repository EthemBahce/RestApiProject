package com.enocaProject.demo.services.concretes;


import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.enocaProject.demo.dto.EmployeeDTO;
import com.enocaProject.demo.entities.Employee;
import com.enocaProject.demo.repository.EmployeeRepository;
import com.enocaProject.demo.services.abstracts.IEmployeeService;

@Service
public class EmployeeManager implements IEmployeeService {

	
	private EmployeeRepository employeeRepository;
	private ModelMapper mapper;
	
	@Autowired
	public EmployeeManager(EmployeeRepository employeeRepository, ModelMapper mapper) {
		this.employeeRepository = employeeRepository;
		this.mapper = mapper;
	}

	@Override
	public List<Employee> getAllEmployee() {
		
		return this.employeeRepository.findAll();
	}

	@Override
	public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
		Employee employee = mapToEntity(employeeDTO);
		Employee newEmployee = employeeRepository.save(employee);
		EmployeeDTO employeeDTO2 = mapToDTO(newEmployee);
		return employeeDTO2;
	}

	@Override
	public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {
		
		
		Optional<Employee> employee = this.employeeRepository.findById(id);
		Employee addEmployee = new Employee();
		
		if(employee.isPresent()) {
			Employee employee1 = employee.get();
			this.employeeRepository.delete(employee1);
			addEmployee.setName(employeeDTO.getName());
			addEmployee.setLastName(employeeDTO.getLastName());
			addEmployee.setCompany(employeeDTO.getCompany());
			return mapToDTO(this.employeeRepository.save(addEmployee));
		}else {
			return null;
		}
		
	}

	@Override
	public Employee delete(Long id) {
		
		Optional<Employee> foundEmployee = this.employeeRepository.findById(id);
		
		if(foundEmployee.isPresent()) {
			Employee deleteEmployee = foundEmployee.get();
			this.employeeRepository.deleteById(deleteEmployee.getId());
			return deleteEmployee;
		}
		return null;
	}
	
	
	
	//Convert Entity into DTO
	     private EmployeeDTO mapToDTO(Employee employee) {
			   
				EmployeeDTO employeeDTO = mapper.map(employee, EmployeeDTO.class);
				return employeeDTO;
			}
			
			
    //Convert DTO to Entity
	     private Employee mapToEntity(EmployeeDTO employeeDTO) {
		
				Employee employee = mapper.map(employeeDTO, Employee.class);
                return employee;
			}
	
	
	
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


