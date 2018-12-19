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
public class Batterie implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private Date dateMontage;
	private Date finGarantie;
	private long numGarantie;
	private String observation;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="code_vehicule3") 
	private Vehicule vehicule3;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDateMontage() {
		return dateMontage;
	}
	public void setDateMontage(Date dateMontage) {
		this.dateMontage = dateMontage;
	}
	public Date getFinGarantie() {
		return finGarantie;
	}
	public void setFinGarantie(Date finGarantie) {
		this.finGarantie = finGarantie;
	}
	public long getNumGarantie() {
		return numGarantie;
	}
	public void setNumGarantie(long numGarantie) {
		this.numGarantie = numGarantie;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	public Batterie() {
		super();
		
	}
	public Batterie(Date dateMontage, Date finGarantie, long numGarantie, String observation, Vehicule vehicule) {
		super();
		this.dateMontage = dateMontage;
		this.finGarantie = finGarantie;
		this.numGarantie = numGarantie;
		this.observation = observation;
		this.vehicule3 = vehicule;
	}
	
	
	

}
