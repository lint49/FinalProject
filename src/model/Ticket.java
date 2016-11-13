package model;

public class Ticket {

	private String name;
	private String date;
	private double price;

	public Ticket(String name, String date, double price) {
		super();
		this.name = name;
		this.date = date;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Ticket [name=" + name + ", date=" + date + ", price=" + price + "]";
	}

}
