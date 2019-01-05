package com.gfa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gfa.dao.AdminRepository;
import com.gfa.dao.ChauffeurRepository;
import com.gfa.entities.Admin;
import com.gfa.entities.Chauffeur;

@Controller
@RequestMapping(value="/")
public class HomeControlleur {
	@Autowired
	private ChauffeurRepository cr;
	@Autowired
	private AdminRepository ad;
	
	@RequestMapping(value="/" , method=RequestMethod.GET)
	public String Index(Model model) {
		model.addAttribute("Admin", new Admin());
				return "Authentification";
	}
	@RequestMapping(value="/homeChauffeur" , method=RequestMethod.GET)
	public String IndexChauffeur(Model model, @RequestParam(name="id") int id) {
		Chauffeur chauffeur=cr.getOne(id);
		model.addAttribute("chauffeur", chauffeur);
				return "homeChauffeur";
	}
	@RequestMapping(value="/login" , method=RequestMethod.POST)
	public String verifier(Model model, @RequestParam(name="login") String login,@RequestParam(name="mdp") String mdp, @RequestParam(name="role") String role) {
		System.out.println(login);
		System.out.println(mdp);
		System.out.println(role);

		
		if(role.equals("Admin")) {
			
			
			
		Admin admin=ad.findAdminbyloginmdp(login, mdp);
		if(admin !=null) {
			model.addAttribute("admin", admin);

			return "homeAdmin";

		}
		else 
				return "Authentification";
		}
		else if(role.equals("Chauffeur")) {
			
			Chauffeur chauffeur=cr.findChauffeurbyloginmdp(login, mdp);
			if(chauffeur !=null) {
				model.addAttribute("chauffeur", chauffeur);

				return "homeChauffeur";
			}else 
				return "Authentification";
		}
		return "Authentification";

				
	}
}
