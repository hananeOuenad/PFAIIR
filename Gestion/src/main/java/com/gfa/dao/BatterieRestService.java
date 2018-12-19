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

import com.gfa.entities.Batterie;

@RestController
@RequestMapping("/batteries")
public class BatterieRestService {
	@Autowired
	private BatterieRepository BatterieRepository;
	
	@GetMapping("")
	public List<Batterie> getAllBatteries(){
		return BatterieRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Batterie getBatterie(@PathVariable int id){
		
		
		Optional<Batterie>Batteries=BatterieRepository.findById(id);
		return Batteries.get();
		       
	}
	
	
	@PostMapping("")
	public Batterie save(@RequestBody Batterie p) {
		
		return BatterieRepository.save(p);
		 
	}
	
	
	//update
	
	@PutMapping("/{id}")
	public Batterie update(@RequestBody Batterie p) {
		
		return BatterieRepository.saveAndFlush(p);
	}
	
	//delete

	@DeleteMapping("/{id}")
	public void deleteBatterie(@PathVariable int id){
		
		
		BatterieRepository.deleteById(id);;

		       
	}


}
