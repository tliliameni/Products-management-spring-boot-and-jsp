package com.springboot.gestionproduit.gestionproduit.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.gestionproduit.gestionproduit.entity.Produit;
import com.springboot.gestionproduit.gestionproduit.repository.ProduitRepository;

@Service
public class ServiceProduit implements IserviceProduit{
	
	@Autowired
	ProduitRepository pr;

	@Override
	public void ajouterProduit(Produit p, MultipartFile mf) throws IOException {
		String photo;
		if(mf.getOriginalFilename().equals("")){
		 photo = saveImage(mf);
         p.setPhoto(photo);		 
		}
            pr.save(p);
	}

	@Override
	public List<Produit> getAllProducts() {
		return pr.findAll();
	}

	@Override
	public Produit getProductById(int Id) {
		return pr.findById(Id).get();
	}

	@Override
	public List<Produit> getProductsBMC(String motcle) {

		return pr.rechercherParMc(motcle);
	}

	@Override
	public void supprimerProduit(int Id) {

		pr.deleteById(Id);;
	}
	public void supprimerImage(Integer idProduit) throws IOException{
		Produit produit=pr.getById(idProduit);
		String chemin= System.getProperty("user.home")+"/imagesGd/";
		Path p= Paths.get(chemin, produit.getPhoto());
	}

	@Override
	public void mettreAJourProduit(Produit p) {

		pr.save(p);
	}

	@Override
	public String saveImage(MultipartFile mf) throws IOException {
		String nameFile=mf.getOriginalFilename();
		String tab[]=nameFile.split("\\.");
		String fileModif = tab[0]+"_"+System.currentTimeMillis()+"."+tab[1];
		String chemin = System.getProperty("user.home")+"/imagesGd/";
		Path p= Paths.get(chemin,fileModif);
		Files.write(p, mf.getBytes());
		
		return fileModif;
	}

	@Override
	public byte[] getImage(int id) throws IOException {
		// TODO Auto-generated method stub
		String nomImage=pr.findById(id).get().getPhoto();
	Path p=Paths.get(System.getProperty("user.home")+"/imagesGd",nomImage);
	return Files.readAllBytes(p);
	}

}
