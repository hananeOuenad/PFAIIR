package com.gfa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gfa.entities.Chauffeur;
 
@Repository("chauffeurRepository")
public interface ChauffeurRepository extends JpaRepository<Chauffeur,Integer> {

}
