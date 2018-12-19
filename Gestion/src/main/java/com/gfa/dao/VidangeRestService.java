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

import com.gfa.entities.Vidange;

@RestController
@RequestMapping("/vidanges")
public class VidangeRestService {
	@Autowired
	private VidangeRepository vidangeRepository;
	
	@GetMapping("")
	public List<Vidange> getAllvidanges(){
		return vidangeRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Vidange getvidange(@PathVariable int id){
		
		
		Optional<Vidange>vidanges=vidangeRepository.findById(id);
		return vidanges.get();
		       
	}
	
	
	@PostMapping("")
	public Vidange save(@RequestBody Vidange p) {
		
		return vidangeRepository.save(p);
		 
	}
	
	
	//update
	
	@PutMapping("/{id}")
	public Vidange update(@RequestBody Vidange p) {
		
		return vidangeRepository.saveAndFlush(p);
	}
	
	//delete

	@DeleteMapping("/{id}")
	public void deletevidange(@PathVariable int id){
		
		
		vidangeRepository.deleteById(id);;

		       
	}


}
