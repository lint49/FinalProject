package model;

public class Worker extends People {

	private static final long serialVersionUID = 1L;
	private String title;
	private double workerPay;
	private String dateStart;

	public Worker(String firstName, String lastName, String stNum, String stName, String city, String state, String zip,
			String phone, String title, double workerPay, String dateStart) {
		super(firstName, lastName, stNum, stName, city, state, zip, phone);
		this.title = title;
		this.workerPay = workerPay;
		this.dateStart = dateStart;
	}

	public Worker() {

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getWorkerPay() {
		return workerPay;
	}

	public void setWorkerPay(double workerPay) {
		this.workerPay = workerPay;
	}

	public String getDateStart() {
		return dateStart;
	}

	public void setDateStart(String dateStart) {
		this.dateStart = dateStart;
	}

	@Override
	public String toString() {
		return "Worker [title=" + title + ", workerPay=" + workerPay + ", dateStart=" + dateStart + "]";
	}

}
