package com.hp.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;



@Entity
@Table
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "accounttype" )
@DiscriminatorValue("account")
public class Account {
	
	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + "]";
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Id
	
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column
	private String name;
	

}
