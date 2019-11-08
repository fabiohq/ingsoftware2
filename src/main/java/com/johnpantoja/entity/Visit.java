package com.johnpantoja.entity;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Visit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 258366353432182204L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long idVisit;

	@Column
	private Date dateVisit;
	@Column

	private String latitude;
	@Column

	private String length;

	@Column
	@NotBlank
	private String observations;

	@JoinColumn(name = "id_user", nullable = true)
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private User user;

	@JoinColumn(name = "id_pointSale", nullable = false)
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private PointSale pointSale;

	
	
	
	
	



	public Long getIdVisit() {
		return idVisit;
	}

	public void setIdVisit(Long idVisit) {
		this.idVisit = idVisit;
	}

	public Date getDateVisit() {
		return dateVisit;
	}

	public String getDateVisitString() {

	
		SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");

		return formateador.format(dateVisit);

	}

	public void setDateVisit(Date dateVisit) {
		this.dateVisit = dateVisit;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public PointSale getPointSale() {
		return pointSale;
	}

	public void setPointSale(PointSale pointSale) {
		this.pointSale = pointSale;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

	@Override
	public String toString() {
		return "Visit [idVisit=" + idVisit + ",  dateVisit=" + dateVisit + ", latitude=" + latitude + ", length="
				+ length + ", observations=" + observations + ", user=" + user + ", pointSale="
				+ pointSale.getIdPointSale() + "]";
	}

}
