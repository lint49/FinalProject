package model;

public class Manager extends People {

	private double salary;
	private String shiftStart;
	private String shiftEnd;

	public Manager(String firstName, String lastName, String stNum, String stName, String city, String state,
			String zip, String phone, String userName, String password, double salary, String shiftStart,
			String shiftEnd) {
		super(firstName, lastName, stNum, stName, city, state, zip, phone, userName, password);
		this.salary = salary;
		this.shiftStart = shiftStart;
		this.shiftEnd = shiftEnd;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getShiftStart() {
		return shiftStart;
	}

	public void setShiftStart(String shiftStart) {
		this.shiftStart = shiftStart;
	}

	public String getShiftEnd() {
		return shiftEnd;
	}

	public void setShiftEnd(String shiftEnd) {
		this.shiftEnd = shiftEnd;
	}

	@Override
	public String toString() {
		return super.toString() + "salary=" + salary + ", shiftStart=" + shiftStart + ", shiftEnd=" + shiftEnd;
	}
	
	

}
