package com.operator.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "operatormanagement")
public class OperatorManagement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String contactPerson;
	private String reference;
	private String reasonForVisit;
	/**
     * @ManyToOne Mapping from Multiple Operators to one ticket
     */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ticketId")
	private Ticket ticket;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "visitorAccessoryId")
	private VisitorAccessory visitorAccessory;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "operatorId")
	private Operator operator;
	
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	public VisitorAccessory getVisitorAccessory() {
		return visitorAccessory;
	}
	public void setVisitorAccessory(VisitorAccessory visitorAccessory) {
		this.visitorAccessory = visitorAccessory;
	}
	public Operator getOperator() {
		return operator;
	}
	public void setOperator(Operator operator) {
		this.operator = operator;
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
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	

}
