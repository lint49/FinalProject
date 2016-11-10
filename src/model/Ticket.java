package model;

public class Ticket {

	private String name;
	private String date;
	private String price;

	public Ticket(String name, String date, String price) {
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Ticket [name=" + name + ", date=" + date + ", price=" + price + "]";
	}

}
