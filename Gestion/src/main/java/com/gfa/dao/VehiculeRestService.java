package com.gfa.dao;
import com.gfa.entities.Vehicule;
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



import java.util.List;


	@RestController
	@RequestMapping("/vehicules")
	public class VehiculeRestService {
		@Autowired
		private VehiculeRepository vehiculeRepository;
		
		@GetMapping("")
		public List<Vehicule> getAllvehicules(){
			return vehiculeRepository.findAll();
		}
		
		@GetMapping("/{id}")
		public Vehicule getvehicule(@PathVariable int id){
			
			
			Optional<Vehicule>vehicules=vehiculeRepository.findById(id);
			return vehicules.get();
			       
		}
		
		
		@PostMapping("")
		public Vehicule save(@RequestBody Vehicule p) {
			
			return vehiculeRepository.save(p);
			 
		}
		
		
		//update
		
		@PutMapping("/{id}")
		public Vehicule update(@RequestBody Vehicule p) {
			
			return vehiculeRepository.saveAndFlush(p);
		}
		
		//delete

		@DeleteMapping("/{id}")
		public void deletevehicule(@PathVariable int id){
			
			
			vehiculeRepository.deleteById(id);;

			       
		}

	}
