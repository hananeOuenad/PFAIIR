package com.gfa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gfa.dao.ChauffeurRepository;
import com.gfa.dao.EntretientPrevertifRepository;
import com.gfa.dao.VehiculeRepository;
import com.gfa.entities.Chauffeur;
import com.gfa.entities.EntretientPrevertif;
import com.gfa.entities.Vehicule;

@Controller
@RequestMapping(value="/ChauffeurUser")
public class ChauffeurControlleur {
	@Autowired
	private ChauffeurRepository cr;
	@Autowired
	private VehiculeRepository vn;
	@Autowired
	private EntretientPrevertifRepository en;
	
	@RequestMapping(value="/listeVehiculeParChauffeur" , method=RequestMethod.GET)
	public String Index(Model model, Model model1, @RequestParam(name="id")int id) {
		Chauffeur chauffeur=cr.getOne(id);
		List<Vehicule>vehicules=(List<Vehicule>) chauffeur.getVehicules();
		model.addAttribute("vehicule", vehicules);
		model.addAttribute("chauffeur", chauffeur);

				return "ListeVehiculeDeChauffeur";
	}
	@RequestMapping(value="/listeEntretienParChauffeur" , method=RequestMethod.GET)
	public String Entretien(Model model, Model model1, @RequestParam(name="id")int id) {
		Chauffeur chauffeur=cr.getOne(id);
		List<Vehicule>vehicules=(List<Vehicule>) chauffeur.getVehicules();
		for (Vehicule vehicule : vehicules) {
			List<EntretientPrevertif>entretien= en.findEntretienbyVehicule(vehicule.getId());
			model.addAttribute("entretien", entretien);

		}
				
				
		model.addAttribute("chauffeur", chauffeur);

				return "ListeEntretienDeChauffeur";
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
	    return "ModifierChauffeurByChauffeur";
	}
	
	@RequestMapping(value="/AjouterObservation" , method=RequestMethod.GET)

	public String AjoutObservation(Chauffeur chauffeur,Model model,Model model1, @RequestParam(name="id")int id) {
		EntretientPrevertif entretien=en.getOne(id);
		model.addAttribute("entretien", entretien);
		model.addAttribute("chauffeur", chauffeur);

		return "AjoutObservationEntretien";}

	@RequestMapping(value="/AjoutObservationpourEntretien" , method=RequestMethod.POST)

	public String SaveObservation(Chauffeur chauffeur,Model model,Model model1, @RequestParam(name="id")int id, @RequestParam(name="observation")String observation) {
		EntretientPrevertif entretien=en.getOne(id);
		entretien.setObservation(observation);
		en.save(entretien);
		model.addAttribute("entretien", entretien);
		model.addAttribute("chauffeur", chauffeur);

		return "ListeEntretienDeChauffeur";}

	

	@RequestMapping(value="/ModifierChauffeur" , method=RequestMethod.POST)
	public String modifier(Chauffeur c, Model model,@RequestParam(name="id")int id,@RequestParam(name="nom")String nom,
			@RequestParam(name="prenom")String prenom,@RequestParam(name="tel")Long tel,
			@RequestParam(name="email")String email, @RequestParam(name="cin")String cin,
			@RequestParam(name="login")String login,@RequestParam(name="mdp")String mdp) {
		
		c=cr.getOne(id);
		c.setCin(cin);
		c.setEmail(email);
		c.setLogin(login);
		c.setMdp(mdp);
		c.setNom(nom);
		c.setPrenom(prenom);
		c.setTel(tel);
cr.save(c);
model.addAttribute("chauffeur", c);
		return "HomeChauffeur";
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


