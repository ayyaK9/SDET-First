package com.pojo;

public class CustomerDetails {

	private String courseName;
	private String purchasedDate;
	private int amount;
	private String Location;

	public CustomerDetails() {
		super();
	}

	public CustomerDetails(String courseName, String purchasedDate, int amount, String location) {
		super();
		this.courseName = courseName;
		this.purchasedDate = purchasedDate;
		this.amount = amount;
		Location = location;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getPurchasedDate() {
		return purchasedDate;
	}

	public void setPurchasedDate(String purchasedDate) {
		this.purchasedDate = purchasedDate;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

}
