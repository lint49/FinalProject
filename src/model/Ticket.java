package model;

import java.io.Serializable;

public class Ticket implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private String date;
	private double price = 0.0;

	public Ticket(String name, String date, double price) {
		super();
		this.name = name;
		this.date = date;
		this.price = price;
	}

	public Ticket() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name != null) {
			this.name = name;
		}
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		if (date != null) {
			this.date = date;
		}
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if (price > 0) {
			this.price = price;
		}
	}

	@Override
	public String toString() {
		return "Ticket [name=" + name + ", date=" + date + ", price=" + price + "]";
	}

}
