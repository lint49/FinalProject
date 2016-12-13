package model;

import java.io.Serializable;

public class Wine implements Serializable {

	private static final long serialVersionUID = 1L;
	private String wineName;
	private String wineType;
	private String region;
	private int alcoholPercentage;
	private double winePrice;

	public Wine(String wineName, String wineType, String region, int alcoholPercentage, double winePrice) {
		super();
		this.wineName = wineName;
		this.wineType = wineType;
		this.region = region;
		this.alcoholPercentage = alcoholPercentage;
		this.winePrice = winePrice;
	}

	public Wine() {

	}

	public String getWineName() {
		return wineName;
	}

	public void setWineName(String wineName) {
		this.wineName = wineName;
	}

	public String getWineType() {
		return wineType;
	}

	public void setWineType(String wineType) {
		this.wineType = wineType;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public int getAlcoholPercentage() {
		return alcoholPercentage;
	}

	public void setAlcoholPercentage(int alcoholPercentage) {
		this.alcoholPercentage = alcoholPercentage;
	}

	public double getPrice() {
		return winePrice;
	}

	public void setPrice(double winePrice) {
		this.winePrice = winePrice;
	}

	@Override
	public String toString() {
		return "Wine [wineName=" + wineName + ", wineType=" + wineType + ", region=" + region + ", alcoholPercentage="
				+ alcoholPercentage + ", price=" + winePrice + "]";
	}

}
