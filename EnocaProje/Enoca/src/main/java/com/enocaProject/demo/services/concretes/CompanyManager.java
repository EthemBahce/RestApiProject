package com.enocaProject.demo.services.concretes;




import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enocaProject.demo.dto.CompanyDTO;
import com.enocaProject.demo.entities.Company;
import com.enocaProject.demo.repository.CompanyRepository;
import com.enocaProject.demo.services.abstracts.ICompanyService;


@Service
public class CompanyManager implements ICompanyService {

	
	private CompanyRepository companyRepository;
	private ModelMapper mapper;
	
	@Autowired
	public CompanyManager(CompanyRepository companyRepository, ModelMapper mapper) {
		this.companyRepository = companyRepository;
		this.mapper = mapper;
		
	}



	@Override
	public List<Company> getAllCompany() {
		
		return this.companyRepository.findAll();
	}





	@Override
	public CompanyDTO createCompany(CompanyDTO companyDTO) {
		Company company = mapToEntity(companyDTO);
		Company newCompany = companyRepository.save(company);
		
		CompanyDTO companyDTO2 = mapToDTO(newCompany);
		
		return companyDTO2;
	}





	@Override
	public CompanyDTO updateCompany(Long id, CompanyDTO companyDTO) {
		
		Optional<Company> company = this.companyRepository.findById(id);
		Company addCompany = new Company();
		
		if(company.isPresent()) {
			Company company1 = company.get();
			this.companyRepository.delete(company1);
			addCompany.setCompany_name(companyDTO.getCompany_name());
			addCompany.setEmployees(companyDTO.getEmployees());
			return mapToDTO(this.companyRepository.save(addCompany)); 
		}else {
			return null;
		}
		
		
	}


	@Override
	public Company delete(Long id) {
		
        Optional<Company> foundCompany = this.companyRepository.findById(id);
		
		if (foundCompany.isPresent()) {
			Company company1 = foundCompany.get();
			this.companyRepository.deleteById(company1.getCompany_id());
			return company1;
		} else {
			return null;
		}
	}
	
	
	//Convert Entity into DTO
		private CompanyDTO mapToDTO(Company company) {
		   
			CompanyDTO companyDTO1 = mapper.map(company, CompanyDTO.class);
			
			/*CompanyDTO companyDTO = new CompanyDTO();
			companyDTO.setCompany_id(company.getCompany_id());
			companyDTO.setCompany_name(company.getCompany_name());
	        companyDTO.setEmployees(company.getEmployees());*/
			
			return companyDTO1;
		}
		
		
		//Convert DTO to Entity
		private Company mapToEntity(CompanyDTO companyDTO) {
			Company company = mapper.map(companyDTO, Company.class );
			
			/*Company company = new Company();
			company.setCompany_name(companyDTO.getCompany_name());
			company.setEmployees(companyDTO.getEmployees());*/
			
			return company;
		}
	
	
			
		
		
	}



	
    
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

