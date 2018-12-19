package com.gfa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gfa.entities.Batterie;
@Repository("batterieRepository")

public interface BatterieRepository extends JpaRepository<Batterie,Integer> {

}
