package com.operator.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "expensescategory")
public class ExpenseCategory {
	/*
	 * public ExpenseCategory( int id, String name) { ec_id=id; ec_name=name; }
	 */	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String categoryName;	
 
	 private int ec_id;

	

	public int getEc_id() {
		return ec_id;
	}

	public void setEc_id(int ec_id) {
		this.ec_id = ec_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	

	
}
