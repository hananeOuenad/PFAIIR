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

import com.gfa.entities.EntretientPrevertif;

@RestController
@RequestMapping("/entretienPrevertifs")
public class EntretienPrevertifRestService {
	@Autowired
	private EntretientPrevertifRepository EntretientPrevertifRepository;
	
	@GetMapping("")
	public List<EntretientPrevertif> getAllEntretientPrevertifs(){
		return EntretientPrevertifRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public EntretientPrevertif getEntretientPrevertif(@PathVariable int id){
		
		
		Optional<EntretientPrevertif>EntretientPrevertifs=EntretientPrevertifRepository.findById(id);
		return EntretientPrevertifs.get();
		       
	}
	
	
	@PostMapping("")
	public EntretientPrevertif save(@RequestBody EntretientPrevertif p) {
		
		return EntretientPrevertifRepository.save(p);
		 
	}
	
	
	//update
	
	@PutMapping("/{id}")
	public EntretientPrevertif update(@RequestBody EntretientPrevertif p) {
		
		return EntretientPrevertifRepository.saveAndFlush(p);
	}
	
	//delete

	@DeleteMapping("/{id}")
	public void deleteEntretientPrevertif(@PathVariable int id){
		
		
		EntretientPrevertifRepository.deleteById(id);;

		       
	}


}
