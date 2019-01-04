package com.gfa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gfa.dao.ChauffeurRepository;
import com.gfa.dao.VehiculeRepository;
import com.gfa.entities.Chauffeur;
import com.gfa.entities.EntretientPrevertif;
import com.gfa.entities.Vehicule;
 

@Controller
@RequestMapping(value="/Chauffeur")
public class AjoutChauffeurControlleur {
	@Autowired
	private ChauffeurRepository cr;
	@Autowired
	private VehiculeRepository vn;
	
	@RequestMapping(value="/list" , method=RequestMethod.GET)
	public String Index(Model model) {
		List<Chauffeur>chauffeurs=cr.findAll();
		model.addAttribute("chauffeur", chauffeurs);
				return "ListChauffeur";
	}
	@RequestMapping(value = "/delete_chauffeur", method = RequestMethod.GET)
	public String DeleteVehicule(@RequestParam(name="id")int id, Model model) {
		System.out.println(id);
		Chauffeur chauffeur=cr.getOne(id);
		cr.delete(chauffeur);
		List<Chauffeur>chauffeurs=cr.findAll();
		model.addAttribute("chauffeur", chauffeurs);
	    return "ListChauffeur";
	}

	@RequestMapping(value = "/modifier_chauffeur", method = RequestMethod.GET)
	public String ModifierChauffeur(@RequestParam(name="id")int id, Model model) {
		Chauffeur chauffeur=cr.getOne(id);
		model.addAttribute("chauffeur", chauffeur);
	    return "ModifierChauffeur";
	}

	@RequestMapping(value="/ModifierChauffeur" , method=RequestMethod.POST)
	public String modifier(Chauffeur c, Model model) {
     		cr.saveAndFlush(c);
List<Chauffeur>chauffeurs=cr.findAll();
model.addAttribute("chauffeur", chauffeurs);
		return "ListChauffeur";
	}
	
	@RequestMapping(value="/SaveChauffeur" , method=RequestMethod.POST)
	public String save(Chauffeur v, Model model) {
     		cr.saveAndFlush(v);
List<Chauffeur>chauffeurs=cr.findAll();
model.addAttribute("vehicule", chauffeurs);
		return "AjoutChauffeur";
	}
@RequestMapping(value="/AjoutChauffeur" , method=RequestMethod.GET)
	
	public String AjoutChauffeur(Model model) {
		model.addAttribute("chauffeur", new Chauffeur());
		List<Chauffeur>vehicules= cr.findAll();
		model.addAttribute("vehicule", vehicules);
		return "AjoutChauffeur";}



}
