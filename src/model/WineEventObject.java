package model;

import java.util.EventObject;

public class WineEventObject extends EventObject {

	private static final long serialVersionUID = 1L;
	private String wineName;
	private String wineType;
	private String region;
	private int alcoholPercentage;
	private double price;

	public WineEventObject(Object source) {
		super(source);
	}

	public WineEventObject(Object source, String wineName, String wineType, String region, int alcoholPercentage,
			double price) {
		super(source);
		this.wineName = wineName;
		this.wineType = wineType;
		this.region = region;
		this.alcoholPercentage = alcoholPercentage;
		this.price = price;

	}

	public String getWineName() {
		return wineName;
	}

	public String getWineType() {
		return wineType;
	}

	public String getRegion() {
		return region;
	}

	public int getAlcoholPercentage() {
		return alcoholPercentage;
	}

	public double getPrice() {
		return price;
	}

}
