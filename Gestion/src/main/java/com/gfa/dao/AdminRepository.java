package com.gfa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gfa.entities.Admin;

@Repository("adminRepository")
public interface AdminRepository extends JpaRepository<Admin,Integer> {
	@Query(
			 value = "select * from admin where login= :login and mdp= :mdp", 
			  nativeQuery = true)
	public Admin findAdminbyloginmdp(@Param("login") String login,
	@Param("mdp") String mdp);
}
