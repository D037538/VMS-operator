package com.operator.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;



@Entity
@Table(name = "operator")
public class Operator {
	
	/*
	 * public Operator(long id, String operatorName, String
	 * operatorCode, @Email @NotEmpty String email, int i) { super(); this.id = id;
	 * this.operatorName = operatorName; this.operatorCode = operatorCode;
	 * this.email = email; }
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotEmpty
	private String operatorName;
	@NotEmpty
	private String operatorCode;
	@Email@NotEmpty
	private String email;
    	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	public String getOperatorCode() {
		return operatorCode;
	}
	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}
	
}
