package com.gfa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gfa.entities.EntretientPrevertif;
@Repository("entretientPrevertifRepository")

public interface EntretientPrevertifRepository extends JpaRepository<EntretientPrevertif,Integer> {

}
