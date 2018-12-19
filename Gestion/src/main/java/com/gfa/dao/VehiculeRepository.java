package com.gfa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gfa.entities.Vehicule;

@Repository("vehiculeRepository")
public interface VehiculeRepository extends JpaRepository<Vehicule,Integer> {

}
