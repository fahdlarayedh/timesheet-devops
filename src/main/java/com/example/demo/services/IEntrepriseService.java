package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Entreprise;
import com.example.demo.entities.User;


public interface IEntrepriseService {

	public Entreprise ajouterEntreprise(Entreprise entreprise);
	List<Entreprise> getAllEntreprise();
	void deleteEntreprise(Long id);
	Entreprise updateEntreprise(Entreprise e);
	Entreprise retrieveEntreprise(Long id);
	int getEntreprisesCount();
	Long getLastEntrepriseId(); 
}
