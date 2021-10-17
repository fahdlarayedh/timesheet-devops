package com.example.demo.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Entreprise;


@Repository
public interface EntrepriseRepository extends CrudRepository<Entreprise, Long> {

}


