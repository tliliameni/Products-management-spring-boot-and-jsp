package com.springboot.gestionproduit.gestionproduit.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Categorie {

		@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		@Column(nullable=true)
		private String nom;
		
		@OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL,orphanRemoval = true)
		@JsonIgnore
		//@JsonProperty(access = Access.WRITE_ONLY)
		List<Produit>liste;

		
		
}
