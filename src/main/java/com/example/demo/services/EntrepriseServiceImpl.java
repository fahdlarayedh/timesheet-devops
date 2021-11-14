package com.example.demo.services;

import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.EntrepriseRepository;
import com.example.demo.entities.Entreprise;

@Service
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
	public void deleteEntreprise(Long id) {
		l.info("In Method deleteEntreprise :");
		en.deleteById(id); 
		l.info("Out Method deleteEntreprise :");		
	}

	@Override
	public Entreprise updateEntreprise(Entreprise e) {
		l.info("In Method updateEntreprise :");
		Entreprise e_saved = en.save(e); 
		l.info("Out Method updateEntreprise :");
		return e_saved; 
	}

	@Override
	public List<Entreprise> getAllEntreprise() {
		List<Entreprise> entreprises = null; 
		try {
	
			l.info("In Method getAllEntreprise :");
			entreprises = (List<Entreprise>) en.findAll();  
			for (Entreprise e : entreprises) {
				l.debug(e.toString());
			} 
			l.info("Out Method getAllEntreprise :");
		}catch (Exception e) {
			l.error("Error in getAllEntreprise : "+e);
		}

		return entreprises;
	}


	@Override
	public Entreprise retrieveEntreprise(Long id) {
		l.info("In Method retrieveEntreprise :");
		Entreprise e =  en.findById((id)).orElse(null);
		l.info("Out Method retrieveEntreprise :");
		return e; 
	}


	@Override
	public int getEntreprisesCount() {
		List<Entreprise> entreprises = null; 
		try {
			l.info("In Method getEntreprisesCount :");
			entreprises = (List<Entreprise>) en.findAll();  
			for (Entreprise e : entreprises) {
				l.debug(e.toString());
			}
			l.info("Out Method getEntreprisesCount :");
		}catch (Exception ex) {
			l.error("Error in getEntreprisesCount : "+ex);
		}

		if(entreprises != null){
			return entreprises.size();
		}else{
			return 0;
		}
	}


	@Override
	public Long getLastEntrepriseId() {
		l.info("In Method getLastEntrepriseId :");
		l.info("Out Method getLastEntrepriseId :");

		return en.getMaxId();
	}

}
