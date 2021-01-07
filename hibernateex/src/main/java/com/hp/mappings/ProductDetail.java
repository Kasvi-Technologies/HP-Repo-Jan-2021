package com.hp.mappings;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class ProductDetail {

	public ProductDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductDetail(int stock, String owner, String hostedOn) {
		super();
		this.stock = stock;
		this.owner = owner;
		this.hostedOn = hostedOn;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getHostedOn() {
		return hostedOn;
	}
	public void setHostedOn(String hostedOn) {
		this.hostedOn = hostedOn;
	}
	
	@Column
	private int stock;
	
	@Override
	public String toString() {
		return "ProductDetail [id=" + id + ", stock=" + stock + ", owner=" + owner + ", hostedOn=" + hostedOn + "]";
	}

	@Column
	private String owner;
	
	@Column
	private String hostedOn;
	
	
}
