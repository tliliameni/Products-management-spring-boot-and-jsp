package com.springboot.gestionproduit.gestionproduit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.gestionproduit.gestionproduit.entity.Categorie;


@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Integer> {
	
	@Query("select c from Categorie c  where c.nom like %:x%")
	List<Categorie> rechercherParMc(@Param("x") String mc);

}
