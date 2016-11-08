package model;

public class Address {
	
	private String stNum;
	private String stName;
	private String city;
	private String state;
	private String zip;

	public Address(String stNum, String stName, String city, String state, String zip) {
		this.stNum = stNum;
		this.stName = stName;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public String getStNum() {
		return stNum;
	}

	public void setStNum(String stNum) {
		this.stNum = stNum;
	}

	public String getStName() {
		return stName;
	}

	public void setStName(String stName) {
		this.stName = stName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		
		this.zip = zip;
	}

	public String toString() {
		return "Address: " + stNum + " " + stName + " \n         " + city + " " + state + " " + zip
				+ "";
	}
	

}
