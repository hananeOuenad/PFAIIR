package com.gfa.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gfa.entities.Affectation;

@RestController
@RequestMapping("/affectations")
public class AffectationRestService {
	
	@Autowired
	private AffectationRepository affectationRepository;
	
	@GetMapping("")
	public List<Affectation> getAllAffectations(){
		return affectationRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Affectation getAffectation(@PathVariable Long id){
		
		
		Optional<Affectation>Affectations=affectationRepository.findById(id);
		return Affectations.get();
		       
	}
	
	
	@PostMapping("")
	public Affectation save(@RequestBody Affectation p) {
		
		return affectationRepository.save(p);
		 
	}
	
	
	//update
	
	@PutMapping("/{id}")
	public Affectation update(@RequestBody Affectation p) {
		
		return affectationRepository.saveAndFlush(p);
	}
	
	//delete

	@DeleteMapping("/{id}")
	public void deleteAffectation(@PathVariable Long id){
		
		
		affectationRepository.deleteById(id);;

		       
	}

}
