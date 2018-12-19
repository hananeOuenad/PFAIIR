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
public class HistoriqueTrajet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private Date dateDepart;
	private String lieuDepart;
	private Date dateFin;
	private String lieuFin;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="code_vehicule5") 
	private Vehicule vehicule5;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDateDepart() {
		return dateDepart;
	}
	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}
	public String getLieuDepart() {
		return lieuDepart;
	}
	public void setLieuDepart(String lieuDepart) {
		this.lieuDepart = lieuDepart;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public String getLieuFin() {
		return lieuFin;
	}
	public void setLieuFin(String lieuFin) {
		this.lieuFin = lieuFin;
	}
	public Vehicule getVehicule() {
		return vehicule5;
	}
	public void setVehicule(Vehicule vehicule) {
		this.vehicule5 = vehicule;
	}
	public HistoriqueTrajet(Date dateDepart, String lieuDepart, Date dateFin, String lieuFin, Vehicule vehicule) {
		super();
		this.dateDepart = dateDepart;
		this.lieuDepart = lieuDepart;
		this.dateFin = dateFin;
		this.lieuFin = lieuFin;
		this.vehicule5 = vehicule;
	}
	public HistoriqueTrajet() {
		super();
	}
	
}
