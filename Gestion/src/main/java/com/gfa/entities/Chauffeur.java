package com.gfa.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@Entity

public class Chauffeur  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

private int id;
private String nom;
private String prenom;
private String cin;
private String email;
private String login;
private long tel;
private String mdp;

@ManyToMany(mappedBy="chauffeurs")
@JsonIgnore
private Collection<Vehicule>vehicules;



public String getLogin() {
	return login;
}
public void setLogin(String login) {
	this.login = login;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public long getTel() {
	return tel;
}
public void setTel(long tel) {
	this.tel = tel;
}


public String getMdp() {
	return mdp;
}
public void setMdp(String mdp) {
	this.mdp = mdp;
}
public Collection<Vehicule> getVehicules() {
	return vehicules;
}
public void setVehicules(Collection<Vehicule> vehicules) {
	this.vehicules = vehicules;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public String getCin() {
	return cin;
}
public void setCin(String cin) {
	this.cin = cin;
}


public Chauffeur(String nom, String prenom, String cin, String email, long tel, String mdp) {
	super();
	this.nom = nom;
	this.prenom = prenom;
	this.cin = cin;
	this.email = email;
	this.tel = tel;
	this.mdp = mdp;
}
public Chauffeur(String nom, String prenom, String cin, String email, long tel, String mdp,
		Collection<Vehicule> vehicules) {
	super();
	this.nom = nom;
	this.prenom = prenom;
	this.cin = cin;
	this.email = email;
	this.tel = tel;
	this.mdp = mdp;
	this.vehicules = vehicules;
}

public Chauffeur(String nom, String prenom, String cin, String email, String login, long tel, String mdp,
		Collection<Vehicule> vehicules) {
	super();
	this.nom = nom;
	this.prenom = prenom;
	this.cin = cin;
	this.email = email;
	this.login = login;
	this.tel = tel;
	this.mdp = mdp;
	this.vehicules = vehicules;
}

public Chauffeur(String nom, String prenom, String cin, String email, String login, long tel, String mdp) {
	super();
	this.nom = nom;
	this.prenom = prenom;
	this.cin = cin;
	this.email = email;
	this.login = login;
	this.tel = tel;
	this.mdp = mdp;
}
public Chauffeur() {
	super();
	// TODO Auto-generated constructor stub
}
}
