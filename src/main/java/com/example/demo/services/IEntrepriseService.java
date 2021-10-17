package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Entreprise;


public interface IEntrepriseService {

	public Entreprise ajouterEntreprise(Entreprise entreprise);
	List<Entreprise> getAllEntreprise();
	void deleteEntreprise(String id);
	Entreprise updateEntreprise(Entreprise e);
	Entreprise retrieveEntreprise(String id);
	
	//void affecterDepartementAEntreprise(int depId, int entrepriseId);
	//public int ajouterDepartement(Departement dep);
	//List<String> getAllDepartementsNamesByEntreprise(long entrepriseId);
	 
}
