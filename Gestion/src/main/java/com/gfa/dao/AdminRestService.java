package com.gfa.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gfa.entities.Admin;

@RestController
@RequestMapping("/admins")
public class AdminRestService {
	@Autowired
	private AdminRepository adminRepository;
	
	@GetMapping("")
	public List<Admin> getAlladmins(){
		return adminRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Admin getadmin(@PathVariable int id){
		
		
		Optional<Admin>admins=adminRepository.findById(id);
		return admins.get();
		       
	}
	
	
	@PostMapping("")
	public Admin save(@RequestBody Admin p) {
		
		return adminRepository.save(p);
		 
	}
	
	
	//update
	
	@PutMapping("/{id}")
	public Admin update(@RequestBody Admin p) {
		
		return adminRepository.saveAndFlush(p);
	}
	
	//delete

	@DeleteMapping("/{id}")
	public void deleteadmin(@PathVariable int id){
		
		
		adminRepository.deleteById(id);;

		       
	}
	
	

}
