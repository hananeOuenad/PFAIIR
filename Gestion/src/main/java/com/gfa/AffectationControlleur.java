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
import com.gfa.entities.Affectation;
import com.gfa.entities.Chauffeur;
import com.gfa.entities.Vehicule;


@Controller
@RequestMapping(value="/Affectation")
public class AffectationControlleur {
	
	@Autowired
	private VehiculeRepository vr;
	
	@Autowired
	private ChauffeurRepository cr;
	
	@RequestMapping(value="/Saveaffectation" , method=RequestMethod.POST)
	public String save( @RequestParam(name="veh") int veh, @RequestParam(name="chauf") int chauf, @RequestParam(name="date") String date) {
		Vehicule v=vr.getOne(veh);
		Chauffeur f=cr.getOne(chauf);
v.getChauffeurs().add(f);
f.getVehicules().add(v);
vr.save(v);
cr.save(f);
		return "Affectation";
	}
	@RequestMapping(value="/Affectationvehicules" , method=RequestMethod.GET)
	public String Affectation(Model model, Model model1) {
		List<Vehicule>vehicules=vr.findAll();
		model.addAttribute("vehicule", vehicules);
		List<Chauffeur>chauffeurs=cr.findAll();
		model1.addAttribute("chauffeur", chauffeurs);

		return "Affectation";
	}

}
