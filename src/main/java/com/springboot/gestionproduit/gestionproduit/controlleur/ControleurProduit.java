package com.springboot.gestionproduit.gestionproduit.controlleur;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.gestionproduit.gestionproduit.entity.Produit;
import com.springboot.gestionproduit.gestionproduit.service.ServiceCategorie;
import com.springboot.gestionproduit.gestionproduit.service.ServiceProduit;

@Controller
@RequestMapping("/apiproduit")
public class ControleurProduit {
	
	@Autowired
	ServiceProduit sp;
	
	@Autowired
	ServiceCategorie cr;
	

	@GetMapping("/all")
	public String getAllProducts(Model m) {
		
		List<Produit> products = sp.getAllProducts();
		m.addAttribute("listeProduit", products);
		return "vue";
		
	}
	

	@GetMapping("/rechercheParMc")
	public String getAllProductsByMc(@RequestParam String mc, Model m) {
		
		List<Produit> products = sp.getProductsBMC(mc);
		m.addAttribute("listeProduit", products);
		return "vue";
		
	}
	

	@GetMapping("/ajouterproduit")
	public String ajouter( Model m) {
		
		m.addAttribute("categories",cr.getAllCategories());
		
		return "formulaireajout";
		
	}
	@PostMapping("/ajouterproduit")
	public String ajouterProduit(Produit p, @RequestParam("file") MultipartFile mf, Model m) throws IOException {
		Integer id=p.getId();
		sp.ajouterProduit(p,mf);
		if (id!=null) {
			return "redirect:/apiproduit/all";
		}
		else {
			m.addAttribute("message", "ajout avec succés");
			m.addAttribute("categories", cr.getAllCategories());
			return "formulaireajout";
		}
		
	}
	
	@GetMapping("/modifierproduit/{id}")
	
	public String ModifierProduit(Model m,@PathVariable int id) {
		m.addAttribute("categories",cr.getAllCategories());
		m.addAttribute("produit",sp.getProductById(id));
		
		return "formulaireajout";
	}
	@GetMapping("/supprimerproduit/{id}")
	public String SupprimerProduit(@PathVariable int id) {
		sp.supprimerProduit(id);
		return "redirect:/apiproduit/all";
	}
	
	
	
}
