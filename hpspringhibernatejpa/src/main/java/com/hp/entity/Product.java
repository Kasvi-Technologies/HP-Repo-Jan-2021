package com.hp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Product_JPA")
public class Product {

	
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price + ", quantity="
				+ quantity + "]";
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(String productName, double price, int quantity) {
		super();
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int productId;
	
	@Column
	private String productName;
	
	@Column
	private double price;
	
	@Column
	private int quantity;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
