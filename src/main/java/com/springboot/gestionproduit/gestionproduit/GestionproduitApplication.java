package com.springboot.gestionproduit.gestionproduit;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication; 
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class GestionproduitApplication implements CommandLineRunner{

/*	@Autowired
	CategorieRepository cr;
	
	//@Autowired
	//ServiceProduit sp;*/
	
	public static void main(String[] args) {
		SpringApplication.run(GestionproduitApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	/*	Categorie c1 = new Categorie(0,"informatique",null);
		Categorie c2 = new Categorie(0,"electronique",null);
		
		cr.save(c1);
		cr.save(c2);
		
		//sp.ajouterProduit(new Produit(0,"pc protable",14,14,c1));

		//sp.ajouterProduit(new Produit(0,"clavier",14,14,c1));

		//sp.ajouterProduit(new Produit(0,"machine à laver",14,14,c2));


	}*/

}}
