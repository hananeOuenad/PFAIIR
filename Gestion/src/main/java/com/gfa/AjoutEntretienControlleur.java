package com.gfa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gfa.dao.EntretientPrevertifRepository;
import com.gfa.dao.VehiculeRepository;
import com.gfa.entities.EntretientPrevertif;
import com.gfa.entities.Vehicule;
 
@Controller
@RequestMapping(value="/Entretien") 
public class AjoutEntretienControlleur {
	@Autowired
	private VehiculeRepository vr;
	private EntretientPrevertifRepository en;
	@RequestMapping(value="/liste" , method=RequestMethod.GET)
	
	public String Index(Model model) {
		List<EntretientPrevertif>entretients=en.findAll();
		model.addAttribute("vehicule", entretients);
				return "ListeEntretient";
	}
	@RequestMapping(value="/AjoutEntretient" , method=RequestMethod.GET)
	
	public String AjoutEntretient(Model model) {
		model.addAttribute("entretientPrevertif", new EntretientPrevertif());
		List<Vehicule>vehicules=vr.findAll();
		model.addAttribute("vehicule", vehicules);
		return "AjoutEntretient";
	}
	
	@RequestMapping(value="/SaveEntretient" , method=RequestMethod.POST)
	public String saveEntretient(EntretientPrevertif v, Model model) {
		
		
		System.out.println(v.getId()+" "+v.getTitreEntretient()+" "+v.getCompteurHoraire()+" "+v.getTypeCompteur()+" "+v.getVehicule().getId());
   
		return "AjoutEntretient";}

}
