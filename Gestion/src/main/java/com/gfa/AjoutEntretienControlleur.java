package com.gfa;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gfa.dao.EntretientPrevertifRepository;
import com.gfa.dao.VehiculeRepository;
import com.gfa.entities.EntretientPrevertif;
import com.gfa.entities.Vehicule;
import com.gfa.NotificationService;

@Controller
@RequestMapping(value="/Entretien") 
public class AjoutEntretienControlleur {
	
	@Autowired
	private EntretientPrevertifRepository en;
	@Autowired
	private VehiculeRepository vn;

	@RequestMapping(value="/listeEntretien" , method=RequestMethod.GET)
	public String Index(Model model, Model model1, Vehicule vehicule) {
		List<EntretientPrevertif>entretients=en.findAll();
	/*	entretients.get(0).getVehicule4().setMatricule(11);
		entretients.get(1).getVehicule4().setMatricule(111);
		entretients.get(2).getVehicule4().setMatricule(233);*/
		model.addAttribute("entretientPrevertif", entretients);


				return "ListeEntretient";
	}
	
	
	@RequestMapping(value="/SaveEntretient" , method=RequestMethod.POST)
	public String saveEntretient(EntretientPrevertif v, Model model, @RequestParam(name="veh") int veh) {
 System.out.println("##########################"+veh);
Vehicule vv=vn.getOne(veh);
v.setVehicule4(vv);
en.saveAndFlush(v)	;

		model.addAttribute("entretientPrevertif", v);
		
   
		return "AjoutEntretient";}

}
