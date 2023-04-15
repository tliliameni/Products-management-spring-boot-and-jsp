package com.springboot.gestionproduit.gestionproduit.controlleur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.gestionproduit.gestionproduit.entity.Categorie;
import com.springboot.gestionproduit.gestionproduit.service.ServiceCategorie;
import com.springboot.gestionproduit.gestionproduit.service.ServiceProduit;



@Controller
@RequestMapping("/apicategorie")
public class ContolleurCategorie {
	
	@Autowired
	ServiceProduit sp;
	
	@Autowired
	ServiceCategorie cr;
	

	@GetMapping("/all")
	public String getAllCategory(Model m) {
		
		List<Categorie> category = cr.getAllCategories();
		m.addAttribute("listeCategorie", category);
		return "vueCategorie";
		
	}
	

	@GetMapping("/rechercheParMc")
	public String getAllCategoryByMc(@RequestParam String mc, Model m) {
		
		List<Categorie> category = cr.getCategorieBMC(mc);
		m.addAttribute("listeCategorie", category);
		return "vueCategorie";

	}
	

	@GetMapping("/ajoutercategorie")
	public String ajouter( Model m) {
		
		m.addAttribute("categories",cr.getAllCategories());
		
		return "formulaireajoutCategorie";
		
	}
	@PostMapping("/ajoutercategorie")
	public String ajoutercategorie(Categorie c, Model m) {

		cr.ajouterCategorie(c);
		
		return "redirect:/apicategorie/all";
		
	}
	
	@GetMapping("/modifiercategorie/{id}")
	
	public String modifiercategorie(Model m,@PathVariable int id) {
		
		m.addAttribute("categorie",cr.getCategorieById(id));

		
		return "formulaireajoutCategorie";
	}
	@GetMapping("/supprimercategorie/{id}")
	public String supprimercategorie(@PathVariable int id) {
		cr.supprimerCategorie(id);
		return "redirect:/apicategorie/all";
	}
	
	
	
}
