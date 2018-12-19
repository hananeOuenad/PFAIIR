package com.gfa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gfa.entities.Affectation;


@Repository("affectationRepository")
public interface AffectationRepository extends JpaRepository<Affectation,Long>{

}
