package com.springboot.gestionproduit.gestionproduit.RestController;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.gestionproduit.gestionproduit.entity.Produit;
import com.springboot.gestionproduit.gestionproduit.service.IserviceProduit;

@RestController
@RequestMapping("/apiproduct")
public class RestController1 {
	@Autowired
	IserviceProduit sp;
	
	@GetMapping("/all")
	
	public List<Produit> getAllProducts(){
		return sp.getAllProducts();
	}
	@GetMapping(path="/getImage/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] getImage(@PathVariable int id) throws IOException {
		return sp.getImage(id);
		
	}
	@PostMapping("/save")
	public void ajouter(@RequestParam("produit") String p,@RequestParam("file") MultipartFile mf) throws IOException{
		Produit pp=new ObjectMapper().readValue(p, Produit.class);
		sp.ajouterProduit(pp,mf);
	}
	@DeleteMapping("/delete/{id}")
	public void updateProduct(@PathVariable int id) throws IOException{
		 sp.supprimerProduit(id);
	}

}
