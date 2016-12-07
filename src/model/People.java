package model;

import java.io.Serializable;

public abstract class People implements Serializable {

	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String stNum;
	private String stName;
	private String city;
	private String state;
	private String zip;
	private String phone;

	public People() {

	}

	public People(String firstName, String lastName, String stNum, String stName, String city, String state, String zip,
			String phone) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.stNum = stNum;
		this.stName = stName;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "firstName=" + firstName + ", lastName=" + lastName + ", stNum=" + stNum + ", stName=" + stName
				+ ", city=" + city + ", state=" + state + ", zip=" + zip + ", phone=" + phone;
	}

}
