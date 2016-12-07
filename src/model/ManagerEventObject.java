package model;

import java.util.EventObject;

public class ManagerEventObject extends EventObject {

	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String stNum;
	private String stName;
	private String city;
	private String state;
	private String zip;
	private String phone;
	private String salary;
	private String shiftStart;
	private String shiftEnd;

	public ManagerEventObject(Object source) {
		super(source);

	}

	public ManagerEventObject(Object source, String firstName, String lastName, String stNum, String stName,
			String city, String state, String zip, String phone, String salary, String shiftStart, String shiftEnd) {
		super(source);
		this.firstName = firstName;
		this.lastName = lastName;
		this.stNum = stNum;
		this.stName = stName;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
		this.salary = salary;
		this.shiftStart = shiftStart;
		this.shiftEnd = shiftEnd;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getStNum() {
		return stNum;
	}

	public String getStName() {
		return stName;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getZip() {
		return zip;
	}

	public String getPhone() {
		return phone;
	}

	public String getSalary() {
		return salary;
	}

	public String getShiftStart() {
		return shiftStart;
	}

	public String getShiftEnd() {
		return shiftEnd;
	}

}
