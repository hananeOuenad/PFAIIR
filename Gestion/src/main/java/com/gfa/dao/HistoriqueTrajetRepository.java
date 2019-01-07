package com.gfa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

 
import com.gfa.entities.HistoriqueTrajet;

@Repository("historiqueTrajetRepository")
public interface HistoriqueTrajetRepository extends JpaRepository<HistoriqueTrajet,Integer>{ 

	@Query(
			 value = "select * from historique_trajet  where  code_vehicule5=:code  ", 
			  nativeQuery = true)
	public List findHistoriqueTrajetbyvehicule(@Param("code") int code
	);
}
