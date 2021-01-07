package com.hp.test;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class Product {
	
	public Product(int id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
	private int id;
	private String name;
	private double price;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	
	
}
public class LamdaexprTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Product p = new Product (1, "Vehicle", 10000);
		Product p1 = new Product (2, "Mobile", 3000);
		
		Product p2 = new Product (3, "Soap", 1000);
		Product p3 = new Product (4, "Electrical", 20000);
		Product p4 = new Product (5, "Vehicle", 6000);
		
		List<Product> productList = new ArrayList<Product>();
		productList.add(p);
		productList.add(p1);
		productList.add(p2);
		productList.add(p3);
		productList.add(p4);
		
		
		productList.stream().filter(p5 -> p5.getPrice() > 5000)
							.forEach(p6 -> System.out.println(p6));
		
		System.out.println("vehicle products");
		productList.stream().filter(p5 -> p5.getName().equals("Vehicle") )
		.forEach(p6 -> System.out.println(p6));
		
		System.out.println(productList.stream().count());
		
		DoubleSummaryStatistics totalPrice = productList.stream().collect(Collectors.summarizingDouble(p6 -> p6.getPrice()));
		
		System.out.println("total price:" + totalPrice.getSum());
		
		String str = null;
		//if str!=null
		Optional<String> optional = Optional.ofNullable(str);
		
		if(optional.isEmpty() || !optional.isPresent()) {
			System.out.println("empty str");
		}
		
		System.out.println(optional.orElse("asdjsasadjsad"));
		
		Optional<String> value = Optional.of("How r u");
		value.filter(s -> s.contains("How")).get();
		System.out.println(value.orElse("asdjsasadjsad"));
	}
	

}
