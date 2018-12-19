package com.gfa.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@Entity
public class EntretientPrevertif implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String titreEntretient;
	private Date dateEntretient;
	private int compteurHoraire;
	private String typeCompteur;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="code_vehicule4") 
	private Vehicule vehicule4;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitreEntretient() {
		return titreEntretient;
	}
	public void setTitreEntretient(String titreEntretient) {
		this.titreEntretient = titreEntretient;
	}
	public Date getDateEntretient() {
		return dateEntretient;
	}
	public void setDateEntretient(Date dateEntretient) {
		this.dateEntretient = dateEntretient;
	}
	public int getCompteurHoraire() {
		return compteurHoraire;
	}
	public void setCompteurHoraire(int compteurHoraire) {
		this.compteurHoraire = compteurHoraire;
	}
	public String getTypeCompteur() {
		return typeCompteur;
	}
	public void setTypeCompteur(String typeCompteur) {
		this.typeCompteur = typeCompteur;
	}
	public Vehicule getVehicule() {
		return vehicule4;
	}
	public void setVehicule(Vehicule vehicule) {
		this.vehicule4 = vehicule;
	}
	public EntretientPrevertif(String titreEntretient, Date dateEntretient, int compteurHoraire, String typeCompteur,
			Vehicule vehicule) {
		super();
		this.titreEntretient = titreEntretient;
		this.dateEntretient = dateEntretient;
		this.compteurHoraire = compteurHoraire;
		this.typeCompteur = typeCompteur;
		this.vehicule4 = vehicule;
	}
	public EntretientPrevertif() {
		super();
	}
	

}
