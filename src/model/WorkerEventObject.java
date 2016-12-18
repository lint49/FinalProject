package model;

import java.util.EventObject;

public class WorkerEventObject extends EventObject {

	private static final long serialVersionUID = 1L;

	private String firstName;
	private String lastName;
	private String stNum;
	private String stName;
	private String city;
	private String state;
	private String zip;
	private String phone;
	private String title;
	private double workerPay;
	private String dateStart;

	public WorkerEventObject(Object source) {
		super(source);
	}

	public WorkerEventObject(Object source, String firstName, String lastName, String stNum, String stName, String city,
			String state, String zip, String phone, String title, double workerPay, String dateStart) {
		super(source);
		this.firstName = firstName;
		this.lastName = lastName;
		this.stNum = stNum;
		this.stName = stName;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
		this.title = title;
		this.workerPay = workerPay;
		this.dateStart = dateStart;
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

	public String getTitle() {
		return title;
	}

	public double getWorkerPay() {
		return workerPay;
	}

	public String getDateStart() {
		return dateStart;
	}

}
