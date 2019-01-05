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
	@RequestMapping(value="/login" , method=RequestMethod.POST)
	public String verifier(@RequestParam(name="login") String login,@RequestParam(name="mdp") String mdp, @RequestParam(name="role") String role) {
		System.out.println(login);
		System.out.println(mdp);
		System.out.println(role);

		
		if(role.equals("Admin")) {
			
			
			
		Admin admin=ad.findAdminbyloginmdp(login, mdp);
		if(admin !=null) {
			return "homeAdmin";
		}
		else 
				return "Authentification";
		}
		
		return "Authentification";

				
	}
}
