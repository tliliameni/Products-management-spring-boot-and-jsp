package com.springboot.gestionproduit.gestionproduit.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.gestionproduit.gestionproduit.entity.Categorie;

import com.springboot.gestionproduit.gestionproduit.repository.CategorieRepository;

@Service
public class ServiceCategorie implements IserviceCategorie {
	
	
	@Autowired
	CategorieRepository cat;

	@Override
	public void ajouterCategorie(Categorie c) {

		cat.save(c);
	}

	@Override
	public List<Categorie> getAllCategories() {

		return cat.findAll();
	}

	@Override
	public Categorie getCategorieById(int Id) {
		
		return cat.findById(Id).get();

	}

	@Override
	public List<Categorie> getCategorieBMC(String motcle) {

		return cat.rechercherParMc(motcle);
		}

	@Override
	public void supprimerCategorie(int Id) {
		
		cat.deleteById(Id);
		
	}

	@Override
	public void mettreAJourCategorie(Categorie c) {
		
		cat.save(c);
		
	}

}
