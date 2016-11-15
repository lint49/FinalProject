package model;

public class Worker extends People {

	private String title;
	private double workerPay;
	private String shiftStart;
	private String shiftEnd;

	public Worker(String firstName, String lastName, String stNum, String stName, String city, String state, String zip,
			String phone, String title, double workerPay, String shiftStart, String shiftEnd) {
		super(firstName, lastName, stNum, stName, city, state, zip, phone);
		this.title = title;
		this.workerPay = workerPay;
		this.shiftStart = shiftStart;
		this.shiftEnd = shiftEnd;
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
		return "Worker [title=" + title + ", workerPay=" + workerPay + ", shiftStart=" + shiftStart + ", shiftEnd="
				+ shiftEnd + "]";
	}

}
