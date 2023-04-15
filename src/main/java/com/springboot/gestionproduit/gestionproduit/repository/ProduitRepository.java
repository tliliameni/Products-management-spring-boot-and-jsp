package com.springboot.gestionproduit.gestionproduit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.gestionproduit.gestionproduit.entity.Produit;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Integer>{
	
	//List<Produit> findByNomcontains(String mc);
	
	@Query("select p from Produit p  where p.nom like %:x%")
	List<Produit> rechercherParMc(@Param("x") String mc);



}
