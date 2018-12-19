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

import com.gfa.entities.Chauffeur;

@RestController
@RequestMapping("/chauffeurs")
public class ChauffeurRestService {

	@Autowired
	private ChauffeurRepository chauffeurRepository;
	
	@GetMapping("")
	public List<Chauffeur> getAllchauffeurs(){
		return chauffeurRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Chauffeur getchauffeur(@PathVariable int id){
		
		
		Optional<Chauffeur>chauffeurs=chauffeurRepository.findById(id);
		return chauffeurs.get();
		       
	}
	
	
	@PostMapping("")
	public Chauffeur save(@RequestBody Chauffeur p) {
		
		return chauffeurRepository.save(p);
		 
	}
	
	
	//update
	
	@PutMapping("/{id}")
	public Chauffeur update(@RequestBody Chauffeur p) {
		
		return chauffeurRepository.saveAndFlush(p);
	}
	
	//delete

	@DeleteMapping("/{id}")
	public void deletechauffeur(@PathVariable int id){
		
		
		chauffeurRepository.deleteById(id);;

		       
	}

}
