package com.gfa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gfa.entities.Chauffeur;
 
@Repository("chauffeurRepository")
public interface ChauffeurRepository extends JpaRepository<Chauffeur,Integer> {
	@Query(
			 value = "select * from chauffeur where login= :login and mdp= :mdp", 
			  nativeQuery = true)
	public Chauffeur findChauffeurbyloginmdp(@Param("login") String login,
	@Param("mdp") String mdp);
	
	/* @Query(
			 value = "update chauffeur= :chauffeur set cin= :cin, nom= :nom, prenom= :prenom, email= :email, tel= :tel, login= :login, mdp= :mdp where id= :id", 
			  nativeQuery = true)
	public boolean UpdateChauffeur(@Param("chauffeur") Chauffeur chauffeur,@Param("cin") String cin, @Param("nom") String nom, @Param("prenom") String prenom, @Param("email") String email,
	@Param("tel") Long tel, @Param("login") String login, @Param("mdp") String mdp, @Param("id") int id);*/
}
