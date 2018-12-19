package com.gfa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gfa.entities.HistoriqueTrajet;

@Repository("historiqueTrajetRepository")
public interface HistoriqueTrajetRepository extends JpaRepository<HistoriqueTrajet,Integer>{

}
