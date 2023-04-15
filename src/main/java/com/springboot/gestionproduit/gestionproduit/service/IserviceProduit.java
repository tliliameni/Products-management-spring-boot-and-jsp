package com.springboot.gestionproduit.gestionproduit.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.springboot.gestionproduit.gestionproduit.entity.Produit;

public interface IserviceProduit {
	
	public void ajouterProduit(Produit p, MultipartFile mf) throws IOException ;
	public List<Produit> getAllProducts();
	public Produit getProductById(int Id);
	public List<Produit> getProductsBMC(String motcle);
	public void supprimerProduit(int Id);
	public void mettreAJourProduit(Produit p);
	public String saveImage(MultipartFile mf) throws IOException;
	public byte[] getImage(int id) throws IOException;
	public void supprimerImage(Integer idProduit) throws IOException;



}
