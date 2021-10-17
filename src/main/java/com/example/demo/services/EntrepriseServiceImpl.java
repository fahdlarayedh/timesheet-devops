package com.example.demo.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.repository.EntrepriseRepository;
import com.example.demo.entities.Entreprise;

public class EntrepriseServiceImpl implements IEntrepriseService {

	@Autowired
	EntrepriseRepository en;
	
	private static final Logger l = LogManager.getLogger(EntrepriseServiceImpl.class);

	@Override
	public Entreprise ajouterEntreprise(Entreprise entreprise) {
		en.save(entreprise);
		return entreprise;
	}


	@Override
	public void deleteEntreprise(String id) {
		l.info("In Method deleteEntreprise :");
		en.deleteById(Long.parseLong(id)); 
		l.info("In Method deleteEntreprise :");		
	}

	@Override
	public Entreprise updateEntreprise(Entreprise e) {
		l.info("In Method updateEntreprise :");
		Entreprise e_saved = en.save(e); 
		l.info("In Method updateEntreprise :");
		return e_saved; 
	}

	@Override
	public List<Entreprise> getAllEntreprise() {
		List<Entreprise> entreprises = null; 
		try {
	
			l.info("In Method retrieveEntreprise :");
			entreprises = (List<Entreprise>) en.findAll();  
			for (Entreprise entrep : entreprises) {
				l.debug(entrep.toString());
			} 
			l.info("Out Method retrieveEntreprise :");
		}catch (Exception e) {
			l.error("Error in retrieveEntreprise : "+e);
		}

		return entreprises;
	}


	@Override
	public Entreprise retrieveEntreprise(String id) {
		l.info("In Method retrieveEntreprise :");
		Entreprise e =  en.findById(Long.parseLong(id)).orElse(null);
		l.info("In Method retrieveEntreprise :");
		return e; 
	}

}
