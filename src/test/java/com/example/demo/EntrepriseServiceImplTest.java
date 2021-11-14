package com.example.demo;

import java.text.ParseException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entities.Entreprise;
import com.example.demo.services.IEntrepriseService;


@SpringBootTest
public class EntrepriseServiceImplTest {

	@Autowired
	IEntrepriseService en;
	
	@Test 
	@Order(1) //c
	public void testRetrieveAllEntreprises(){
		List<Entreprise> entreprises = en.getAllEntreprise();
		Assertions.assertEquals(en.getEntreprisesCount(), entreprises.size());
	}

	@Test
	@Order(2)
	public void testAddEntreprise() {
		
		Entreprise e = new Entreprise("Netflix","Social2");
		Entreprise eAdded = en.ajouterEntreprise(e);
		Assertions.assertEquals(e.getName(),eAdded.getName());
	}
	
	
	@Test
	@Order(3) //c
	public void testModifyEntreprise() throws ParseException {
		Entreprise e = new Entreprise(3L,"Netflix","Social3");
		Entreprise eUpdated = en.updateEntreprise(e);
		Assertions.assertEquals(e.getName(),eUpdated.getName());
	}
	
	
	@Test
	@Order(4) //c
	public void testRetrieveEntreprise(){
		Entreprise e = en.retrieveEntreprise(4L);
		Assertions.assertEquals(4L, e.getId());
	}
	
	@Test
	@Order(5)  //d
	public void testDeleteUser(){
		Long id = en.getLastEntrepriseId();
		en.deleteEntreprise(id); //d
		Assertions.assertNull(en.retrieveEntreprise(id)); //d
	}
	
}
