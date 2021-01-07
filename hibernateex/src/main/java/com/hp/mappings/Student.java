package com.hp.mappings;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table

public class Student {
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String name) {
		super();
		this.name = name;
		
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", addresses=" + addresses + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int studentId;
	@Column
	private String name;
	
	@OneToMany(targetEntity = Address.class)
	private Set<Address> addresses;
	
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	
	
	

}
