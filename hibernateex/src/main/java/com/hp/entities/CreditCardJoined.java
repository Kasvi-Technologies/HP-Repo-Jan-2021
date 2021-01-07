package com.hp.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class CreditCardJoined extends AccountJoined{

	public CreditCardJoined() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return super.toString() + "CreditCard [expYear=" + expYear + ", expMonth=" + expMonth + "]";
	}

	public CreditCardJoined(int id, String name, int expYear, int expMonth) {
		super(id, name);
		this.expYear = expYear;
		this.expMonth = expMonth;
	}
	private int expYear;
	private int expMonth;
	public int getExpYear() {
		return expYear;
	}
	public void setExpYear(int expYear) {
		this.expYear = expYear;
	}
	public int getExpMonth() {
		return expMonth;
	}
	public void setExpMonth(int expMonth) {
		this.expMonth = expMonth;
	}
	
}
