package com.gfa;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gfa.dao.VehiculeRepository;
import com.gfa.entities.EntretientPrevertif;
import com.gfa.entities.Vehicule;


@Controller
@RequestMapping(value="/Vehicule")
public class AjoutVehiculeControlleur {

	// inject via application.properties
	@Autowired
private VehiculeRepository vr;

	@RequestMapping(value="/list" , method=RequestMethod.GET)
	public String Index(Model model) {
		List<Vehicule>vehicules=vr.findAll();
		model.addAttribute("vehicule", vehicules);
				return "ListVehicule";
	}
	

	@RequestMapping(value="/AjoutVehicule" , method=RequestMethod.GET)
	public String AjoutVehicule(Model model) {
		model.addAttribute("vehicule", new Vehicule());
		
		return "AjoutVehicule";
	}
	 
	 
	/*@RequestMapping(value="/SaveEntretient" , method=RequestMethod.POST)
	public String saveEntretient(EntretientPrevertif v, Model model) {
		
     en.save(v);		
     List<EntretientPrevertif>entretients=en.findAll();
     model.addAttribute("entretientPrevertif", entretients); 
		return "AjoutEntretient";
	}*/
	
	 
	@RequestMapping(value="/SaveVehicule" , method=RequestMethod.POST)
	public String save(Vehicule v, Model model) {
     		vr.saveAndFlush(v);
List<Vehicule>vehicules=vr.findAll();
model.addAttribute("vehicule", vehicules);
		return "ListVehicule";
	}
	
	@RequestMapping(value = "/delete_vehicule", method = RequestMethod.GET)
	public String DeleteVehicule(@RequestParam(name="id")int id, Model model) {
		System.out.println(id);
	    Vehicule vehicule=vr.getOne(id);
		vr.delete(vehicule);
		List<Vehicule>vehicules=vr.findAll();
		model.addAttribute("vehicule", vehicules);
	    return "ListVehicule";
	}
	
	@RequestMapping(value = "/modifier_vehicule", method = RequestMethod.GET)
	public String ModifierVehicule(@RequestParam(name="id")int id, Model model) {
		System.out.println(id);
	    Vehicule vehicule=vr.getOne(id);
		
		model.addAttribute("vehicule", vehicule);
	    return "ModifierVehicule";
	}
	
	
@RequestMapping(value="/AjoutEntretient" , method=RequestMethod.GET)
	
	public String AjoutEntretient(Model model) {
		
		model.addAttribute("entretientPrevertif", new EntretientPrevertif());
		List<Vehicule>vehicules= vr.findAll();
		model.addAttribute("vehicule", vehicules);
		return "AjoutEntretient";
	}
}
