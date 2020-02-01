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
		return formatDate(dateOfAccounting) + ", " + formatDetails(entityDetails) + ", " + amount.replace(",", ".") + ", " + currency.replaceAll(",", ".") + ", " + type;
	}

	private String formatDate(String date) {
		return date.substring(0, 4) + "-" + date.substring(4, 6) + "-" + date.substring(6, 8);
	}

	private String formatDetails(String date) {
		if (entityDetails != null) {
			return entityDetails.replaceAll("[0-9]", "");
		}
		return null;
	}

	public Expense(String dateOfAccounting, String dateOfCurrency, String type) {
		this.dateOfAccounting = dateOfAccounting;
		this.dateOfCurrency = dateOfCurrency;
		this.type = type;
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
}
