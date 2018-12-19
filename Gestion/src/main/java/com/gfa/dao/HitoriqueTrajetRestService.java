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

import com.gfa.entities.HistoriqueTrajet;

@RestController
@RequestMapping("/historiqueTrajets")
public class HitoriqueTrajetRestService {
	@Autowired
	private HistoriqueTrajetRepository HistoriqueTrajetRepository;
	
	@GetMapping("")
	public List<HistoriqueTrajet> getAllHistoriqueTrajets(){
		return HistoriqueTrajetRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public HistoriqueTrajet getHistoriqueTrajet(@PathVariable int id){
		
		
		Optional<HistoriqueTrajet>HistoriqueTrajets=HistoriqueTrajetRepository.findById(id);
		return HistoriqueTrajets.get();
		       
	}
	
	
	@PostMapping("")
	public HistoriqueTrajet save(@RequestBody HistoriqueTrajet p) {
		
		return HistoriqueTrajetRepository.save(p);
		 
	}
	
	
	//update
	
	@PutMapping("/{id}")
	public HistoriqueTrajet update(@RequestBody HistoriqueTrajet p) {
		
		return HistoriqueTrajetRepository.saveAndFlush(p);
	}
	
	//delete

	@DeleteMapping("/{id}")
	public void deleteHistoriqueTrajet(@PathVariable int id){
		
		
		HistoriqueTrajetRepository.deleteById(id);;

		       
	}


}
