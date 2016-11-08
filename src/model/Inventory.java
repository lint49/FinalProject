package model;

public class Inventory {

	private int beer;
	private int wine;
	private double beerPrice;
	private double winePrice;
	private int ticket;
	private double ticketPrice;
	
	
	
	public Inventory(int beer, int wine, double beerPrice, double winePrice, int ticket, double ticketPrice) {
		super();
		this.beer = beer;
		this.wine = wine;
		this.beerPrice = beerPrice;
		this.winePrice = winePrice;
		this.ticket = ticket;
		this.ticketPrice = ticketPrice;
	}

	public Inventory(){
		
	}

	public int getBeer() {
		return beer;
	}

	public void setBeer(int beer) {
		this.beer = beer;
	}

	public int getWine() {
		return wine;
	}

	public void setWine(int wine) {
		this.wine = wine;
	}

	public double getBeerPrice() {
		return beerPrice;
	}

	public void setBeerPrice(double beerPrice) {
		this.beerPrice = beerPrice;
	}

	public double getWinePrice() {
		return winePrice;
	}

	public void setWinePrice(double winePrice) {
		this.winePrice = winePrice;
	}

	public int getTicket() {
		return ticket;
	}

	public void setTicket(int ticket) {
		this.ticket = ticket;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	
	
}
