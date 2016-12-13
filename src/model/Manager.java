package model;

import java.io.Serializable;

public class Manager extends People implements Serializable{

	private static final long serialVersionUID = 1L;
	private String salary;
	private String shiftStart;

	public Manager(String firstName, String lastName, String stNum, String stName, String city, String state,
			String zip, String phone, String salary, String shiftStart) {
		super(firstName, lastName, stNum, stName, city, state, zip, phone);
		this.salary = salary;
		this.shiftStart = shiftStart;
	}

	public Manager() {

	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getShiftStart() {
		return shiftStart;
	}

	public void setShiftStart(String shiftStart) {
		this.shiftStart = shiftStart;
	}


	@Override
	public String toString() {
		return super.toString() + "salary=" + salary + ", shiftStart=" + shiftStart;
	}

}
