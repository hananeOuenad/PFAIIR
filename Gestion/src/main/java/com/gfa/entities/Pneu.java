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
public class Pneu implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	private int id;
	private long numSerie;
	private Date dateMontage;
	private Date demontage;
	private long kmH;
	private String observation;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="code_vehicule2") 
	private Vehicule vehicule2;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getNumSerie() {
		return numSerie;
	}
	public void setNumSerie(long numSerie) {
		this.numSerie = numSerie;
	}
	public Date getDateMontage() {
		return dateMontage;
	}
	public void setDateMontage(Date dateMontage) {
		this.dateMontage = dateMontage;
	}
	public Date getDemontage() {
		return demontage;
	}
	public void setDemontage(Date demontage) {
		this.demontage = demontage;
	}
	public long getKmH() {
		return kmH;
	}
	public void setKmH(long kmH) {
		this.kmH = kmH;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	
	
	public Vehicule getVehicule() {
		return vehicule2;
	}
	public void setVehicule(Vehicule vehicule) {
		this.vehicule2 = vehicule;
	}
	
	public Pneu(long numSerie, Date dateMontage, Date demontage, long kmH, String observation, Vehicule vehicule) {
		super();
		this.numSerie = numSerie;
		this.dateMontage = dateMontage;
		this.demontage = demontage;
		this.kmH = kmH;
		this.observation = observation;
		this.vehicule2 = vehicule;
	}
	
	public Pneu(long numSerie, Date dateMontage, Date demontage, long kmH, String observation) {
		super();
		this.numSerie = numSerie;
		this.dateMontage = dateMontage;
		this.demontage = demontage;
		this.kmH = kmH;
		this.observation = observation;
	}
	public Pneu() {
		super();
	}
	

}
