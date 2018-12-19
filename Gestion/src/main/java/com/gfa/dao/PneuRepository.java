package com.gfa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gfa.entities.Pneu;
@Repository("pneuRepository")

public interface PneuRepository  extends JpaRepository<Pneu,Integer> {

}
