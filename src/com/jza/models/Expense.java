package com.jza.models;

public class Expense {

	public String dateOfAccounting;
	public String dateOfCurrency;
	public String entityDetails;
	public String entityBillNumber;
	public String title;
	public String amount;
	public String currency;
	public String refNumber;
	public String type;

	public String getCSVformat() {
		return dateOfAccounting + ", " + entityDetails + ", " + amount.replace(",", ".") + ", " + currency + ", " + type;
	}

	private String formatDate(String date) {
		return date.substring(0, 4) + "-" + date.substring(4, 6) + "-" + date.substring(6, 8);
	}

	@Override
	public String toString() {
		return "Expense{" +
				"dateOfAccounting='" + dateOfAccounting + '\'' +
				", dateOfCurrency='" + dateOfCurrency + '\'' +
				", entityDetails='" + entityDetails + '\'' +
				", entityBillNumber='" + entityBillNumber + '\'' +
				", title='" + title + '\'' +
				", amount='" + amount + '\'' +
				", currency='" + currency + '\'' +
				", refNumber='" + refNumber + '\'' +
				", type='" + type + '\'' +
				'}';
	}

	public Expense(String dateOfAccounting, String dateOfCurrency, String entityDetails, String entityBillNumber, String title, String amount, String currency, String refNumber, String type) {
		this.dateOfAccounting = dateOfAccounting;
		this.dateOfCurrency = dateOfCurrency;
		if(entityDetails != null){
			this.entityDetails = entityDetails.replaceAll("[0-9]","");
		}
		this.entityBillNumber = entityBillNumber;
		this.title = title;
		this.amount = amount;
		this.currency = currency;
		this.refNumber = refNumber;
		this.type = type;
	}
}
