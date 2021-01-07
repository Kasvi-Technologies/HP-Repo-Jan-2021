package com.hp.mappings;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Product1 {
	
	@Override
	public String toString() {
		return "Product1 [id=" + id + ", name=" + name + ", cost=" + cost + ", productDetail=" + productDetail + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String name;
	
	@Column
	private double cost;
	
	@OneToOne
	private ProductDetail productDetail;
	
	
	public Product1() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product1(String name, double cost) {
		super();
		this.name = name;
		this.cost = cost;
	}

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

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public ProductDetail getProductDetail() {
		return productDetail;
	}

	public void setProductDetail(ProductDetail productDetail) {
		this.productDetail = productDetail;
	}

	
	
}
