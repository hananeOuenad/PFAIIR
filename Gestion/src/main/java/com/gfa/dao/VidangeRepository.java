package com.gfa.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.gfa.entities.Vidange;

@Repository("vidangeRepository")

public interface VidangeRepository extends JpaRepository<Vidange,Integer> {


}
