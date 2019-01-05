package com.gfa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gfa.entities.EntretientPrevertif;
@Repository("entretientPrevertifRepository")

public interface EntretientPrevertifRepository extends JpaRepository<EntretientPrevertif,Integer> {
	
	@Query(
			 value = "select * from entretient_prevertif where code_vehicule4= :code", 
			  nativeQuery = true)
	public List<EntretientPrevertif> findEntretienbyVehicule(@Param("code") int code);

}
