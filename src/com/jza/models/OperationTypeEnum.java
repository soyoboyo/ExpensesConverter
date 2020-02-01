package com.jza.models;

public enum OperationTypeEnum {
	PODATEK("PODATEK POBRANY"),
	KARTA("TRANSAKCJA KARTĄ PŁATNICZĄ"),
	ODSETKI("ODSETKI OD DEPOZYTU"),
	PRZELEWMB("PRZELEW INTERNET M/B"),
	PRZELEW_INTERNET("PRZELEW INTERNET"),
	PRZELEW_KRAJOWY("PRZELEW KRAJOWY MIĘDZYBANKOWY"),
	PROWIZJE("PROWIZJE AUT.");


	public String getOperation() {
		return operation;
	}

	private String operation;

	OperationTypeEnum(String type) {
		this.operation = type;
	}
}
