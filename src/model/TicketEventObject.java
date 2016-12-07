package model;

import java.util.EventObject;

public class TicketEventObject extends EventObject {

	private static final long serialVersionUID = 1L;
	private String name;
	private String date;
	private double price;

	public TicketEventObject(Object source) {
		super(source);
	}

	public TicketEventObject(Object source, String name, String date, double price) {
		super(source);
		this.name = name;
		this.date = date;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public String getDate() {
		return date;
	}

	public double getPrice() {
		return price;
	}

}
