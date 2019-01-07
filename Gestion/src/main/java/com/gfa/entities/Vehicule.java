package com.gfa.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnore;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@Entity
public class Vehicule implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
private int id;
private int matricule;
private String marque;
private String genre;
private double puissance;
private Date premiereCirculation;
private String typeCarburant;
@OneToMany(mappedBy = "vehicule")
@JsonIgnore
private Collection<Vidange>vidanges; 
@OneToMany(mappedBy = "vehicule2")
@JsonIgnore
private Collection<Pneu>pneus; 
@OneToMany(mappedBy = "vehicule3")
@JsonIgnore
private Collection<Batterie>batteries;
@OneToMany(mappedBy = "vehicule4")
@JsonIgnore
private Collection<EntretientPrevertif>entretientPrevertifs; 
@OneToMany(mappedBy = "vehicule5", fetch = FetchType.EAGER)
//@JsonIgnore
private Collection<HistoriqueTrajet>historiqueTrajets; 
@ManyToMany
@JoinTable(name="affectation")
private Collection<Chauffeur>chauffeurs;



public Collection<Vidange> getVidanges() {
	return vidanges;
}
public void setVidanges(Collection<Vidange> vidanges) {
	this.vidanges = vidanges;
}


public Vehicule(int id, int matricule, String marque, String genre, Collection<Vidange> vidanges,
		Collection<Chauffeur> chauffeurs) {
	super();
	this.id = id;
	this.matricule = matricule;
	this.marque = marque;
	this.genre = genre;
	this.vidanges = vidanges;
	this.chauffeurs = chauffeurs;
}
public Collection<Chauffeur> getChauffeurs() {
	return chauffeurs;
}
public void setChauffeurs(Collection<Chauffeur> chauffeurs) {
	this.chauffeurs = chauffeurs;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getMatricule() {
	return matricule;
}
public void setMatricule(int matricule) {
	this.matricule = matricule;
}
public String getMarque() {
	return marque;
}
public void setMarque(String marque) {
	this.marque = marque;
}
public String getGenre() {
	return genre;
}
public void setGenre(String genre) {
	this.genre = genre;
}


public double getPuissance() {
	return puissance;
}
public void setPuissance(double puissance) {
	this.puissance = puissance;
}
public Date getPremiereCirculation() {
	return premiereCirculation;
}
public void setPremiereCirculation(Date premiereCirculation) {
	this.premiereCirculation = premiereCirculation;
}
public String getTypeCarburant() {
	return typeCarburant;
}
public void setTypeCarburant(String typeCarburant) {
	this.typeCarburant = typeCarburant;
}

public Vehicule(int matricule, String marque, String genre, double puissance, Date premiereCirculation,
		String typeCarburant, Collection<Vidange> vidanges, Collection<Chauffeur> chauffeurs) {
	super();
	this.matricule = matricule;
	this.marque = marque;
	this.genre = genre;
	this.puissance = puissance;
	this.premiereCirculation = premiereCirculation;
	this.typeCarburant = typeCarburant;
	this.vidanges = vidanges;
	this.chauffeurs = chauffeurs;
}

public Vehicule(int matricule, String marque, String genre, double puissance, Date premiereCirculation,
		String typeCarburant) {
	super();
	this.matricule = matricule;
	this.marque = marque;
	this.genre = genre;
	this.puissance = puissance;
	this.premiereCirculation = premiereCirculation;
	this.typeCarburant = typeCarburant;
}
public Vehicule() {
	super();
}
public Collection<Pneu> getPneus() {
	return pneus;
}
public void setPneus(Collection<Pneu> pneus) {
	this.pneus = pneus;
}
public Collection<Batterie> getBatteries() {
	return batteries;
}
public void setBatteries(Collection<Batterie> batteries) {
	this.batteries = batteries;
}
public Collection<EntretientPrevertif> getEntretientPrevertifs() {
	return entretientPrevertifs;
}
public void setEntretientPrevertifs(Collection<EntretientPrevertif> entretientPrevertifs) {
	this.entretientPrevertifs = entretientPrevertifs;
}
public Collection<HistoriqueTrajet> getHistoriqueTrajets() {
	return historiqueTrajets;
}
public void setHistoriqueTrajets(Collection<HistoriqueTrajet> historiqueTrajets) {
	this.historiqueTrajets = historiqueTrajets;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}



}
