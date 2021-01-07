package com.hp.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("bankaccount")
public class BankAccount extends Account{
	
	public BankAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BankAccount(int id, String name, int amount, String type) {
		super(id, name);
		this.amount = amount;
		this.type = type;
	}
	@Override
	public String toString() {
		return super.toString() + "BankAccount [amount=" + amount + ", type=" + type + "]";
	}
	private int amount;
	private String type;
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	

}
