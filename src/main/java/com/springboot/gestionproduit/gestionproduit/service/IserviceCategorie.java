package com.springboot.gestionproduit.gestionproduit.service;

import java.util.List;

import com.springboot.gestionproduit.gestionproduit.entity.Categorie;


public interface IserviceCategorie {
	
	
	public void ajouterCategorie(Categorie c);
	public List<Categorie> getAllCategories();
	public Categorie getCategorieById(int Id);
	public List<Categorie> getCategorieBMC(String motcle);
	public void supprimerCategorie(int Id);
	public void mettreAJourCategorie(Categorie c);


}
