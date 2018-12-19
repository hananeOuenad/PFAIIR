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

import com.gfa.entities.Pneu;

@RestController
@RequestMapping("/pneus")
public class PneuRestService {

	@Autowired
	private PneuRepository PneuRepository;
	
	@GetMapping("")
	public List<Pneu> getAllPneus(){
		return PneuRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Pneu getPneu(@PathVariable int id){
		
		
		Optional<Pneu>Pneus=PneuRepository.findById(id);
		return Pneus.get();
		       
	}
	
	
	@PostMapping("")
	public Pneu save(@RequestBody Pneu p) {
		
		return PneuRepository.save(p);
		 
	}
	
	
	//update
	
	@PutMapping("/{id}")
	public Pneu update(@RequestBody Pneu p) {
		
		return PneuRepository.saveAndFlush(p);
	}
	
	//delete

	@DeleteMapping("/{id}")
	public void deletePneu(@PathVariable int id){
		
		
		PneuRepository.deleteById(id);;

		       
	}


}

