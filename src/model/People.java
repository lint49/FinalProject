package model;

public class People {

	private String firstName;
	private String lastName;
	private String stNum;
	private String stName;
	private String city;
	private String state;
	private String zip;
	private String phone;
	private String userName;
	private String password;

	public People(String firstName, String lastName, String stNum, String stName, String city, String state, String zip,
			String phone, String userName, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.stNum = stNum;
		this.stName = stName;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
		this.userName = userName;
		this.password = password;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "[firstName=" + firstName + ", lastName=" + lastName + ", stNum=" + stNum + ", stName=" + stName
				+ ", city=" + city + ", state=" + state + ", zip=" + zip + ", phone=" + phone + ", userName=" + userName
				+ ", password=" + password + "]";
	}

}
