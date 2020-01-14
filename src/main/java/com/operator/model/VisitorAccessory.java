package com.operator.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "visitoraccesory")
public class VisitorAccessory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String accessoryName;
	private String accesssoryType;
	private String message;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
