package com.jza;

public enum OperationTypeEnum {
	PODATEK("PODATEK POBRANY"),
	KARTA("TRANSAKCJA KARTĄ PŁATNICZĄ"),
	ODSETKI("ODSETKI OD DEPOZYTU"),
	PRZELEWMB("PRZELEW INTERNET M/B");

	public String getOperationType() {
		return operationType;
	}

	private String operationType;

	OperationTypeEnum(String s) {
		this.operationType = s;
	}
}
