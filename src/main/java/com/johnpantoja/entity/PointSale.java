package com.johnpantoja.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;
@Entity
public class PointSale implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 258366353432182204L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long idPointSale;
	@Column
	@NotBlank
	private String name;
	@Column
	@NotBlank
	private String address;
	@Column
	@NotBlank
	private String latitude;
	@Column
	@NotBlank
	private String length;

	
	@OneToMany(mappedBy="pointSale")
	private List<Visit> visits;
	
	
	
	
	
	
	
	
	
	
	public List<Visit> getVisits() {
		return visits;
	}

	public void setVisits(List<Visit> visits) {
		this.visits = visits;
	}
	
	public Long getIdPointSale() {
		return idPointSale;
	}
	public void setIdPointSale(Long idPointSale) {
		this.idPointSale = idPointSale;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	
	
	
	
	
	
	
	
	

}
