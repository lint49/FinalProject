package model;

public class Wine {

	private int wineInStock;
	private String wineType;
	private String region;
	private int alcoholPercentage;
	private double price;

	public Wine(int wineInStock, String wineType, String region, int alcoholPercentage, double price) {
		super();
		this.wineInStock = wineInStock;
		this.wineType = wineType;
		this.region = region;
		this.alcoholPercentage = alcoholPercentage;
		this.price = price;
	}

	public int getWineInStock() {
		return wineInStock;
	}

	public void setWineInStock(int wineInStock) {
		this.wineInStock = wineInStock;
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
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Wine [wineInStock=" + wineInStock + ", wineType=" + wineType + ", region=" + region
				+ ", alcoholPercentage=" + alcoholPercentage + ", price=" + price + "]";
	}

}
