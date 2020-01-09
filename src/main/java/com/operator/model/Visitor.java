package com.operator.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "visitor")
public class Visitor implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	// private String bloodGroup;

	private String email;
	private long mobileNo;
	private String address;
	private String country;
	private String state;

	public Visitor(long id, String name, String email, long mobileNo, String address, String country, String state,
			String city, String idProof, String contactPersonName, String contactPersonEmail, String reference,
			String reasonForVisit, String contactPersonMobile, int status) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobileNo = mobileNo;
		this.address = address;
		this.country = country;
		this.state = state;
		this.city = city;
		this.idProof = idProof;
		this.contactPersonName = contactPersonName;
		this.contactPersonEmail = contactPersonEmail;
		this.reference = reference;
		this.reasonForVisit = reasonForVisit;
		this.contactPersonMobile = contactPersonMobile;
		this.status = status;
	}

	private String city;
	private String idProof;
	private String contactPersonName;
	private String contactPersonEmail;
	private String reference;
	private String reasonForVisit;
	private String contactPersonMobile;

	public String getContactPersonMobile() {
		return contactPersonMobile;
	}

	public void setContactPersonMobile(String contactPersonMobile) {
		this.contactPersonMobile = contactPersonMobile;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Column(name = "status", nullable = false, columnDefinition = "int default 0")
	private int status;

	public Visitor() {
		super();
	}

	public Visitor(long id, String name, String email, long mobileNo, String address, String country, String state,
			String city, String idProof, String contactPersonName, String contactPersonEmail, String reference,
			String reasonForVisit, int status) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobileNo = mobileNo;
		this.address = address;
		this.country = country;
		this.state = state;
		this.city = city;
		this.idProof = idProof;
		this.contactPersonName = contactPersonName;
		this.contactPersonEmail = contactPersonEmail;
		this.reference = reference;
		this.reasonForVisit = reasonForVisit;
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getIdProof() {
		return idProof;
	}

	public void setIdProof(String idProof) {
		this.idProof = idProof;
	}

	public String getContactPersonName() {
		return contactPersonName;
	}

	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}

	public String getContactPersonEmail() {
		return contactPersonEmail;
	}

	public void setContactPersonEmail(String contactPersonEmail) {
		this.contactPersonEmail = contactPersonEmail;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getReasonForVisit() {
		return reasonForVisit;
	}

	public void setReasonForVisit(String reasonForVisit) {
		this.reasonForVisit = reasonForVisit;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	
	
	/*
	 * @OneToMany(mappedBy = "visitor")
	 * 
	 * private List<Ticket> ticket;
	 */
	
	
	

//	@OneToMany(fetch = FetchType.EAGER ,targetEntity = Ticket.class, cascade =
//	  CascadeType.ALL)
//	  
//	private Ticket ticket;
//
//	public Ticket getTicket() {
//		return ticket;
//	}
//
//	public void setTicket(Ticket ticket) {
//		this.ticket = ticket;
//	}
	
	
	
//	  @JsonManagedReference
//	  
//	  @JoinColumn(name = "visitor_id", referencedColumnName = "id")//mnt_id private
//	  Set ticket; public Set getTicket() { return ticket; }
	  
	  
	  
	 

}