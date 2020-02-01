package com.jza;

import java.util.List;

public class ExpenseFactory {

	public static Expense createExpense(List<String> fields) {

		String type = fields.get(fields.size() - 1);
		switch (type) {
			case OperationTypeEnum.ODSETKI.getOperationType():
				return new Expense(fields.get(0), fields.get(1), null, fields.get(2), fields.get(3), null, fields.get(4));
			case OperationTypeEnum.PODATEK.getOperationType():
				return new Expense(fields.get(0), fields.get(1), null, fields.get(2), fields.get(3), fields.get(4), fields.get(5));
			case OperationTypeEnum.KARTA.getOperationType():
				return new Expense(fields.get(0), fields.get(1), fields.get(2), fields.get(3), fields.get(4), fields.get(5), fields.get(6));
			case OperationTypeEnum.PRZELEWMB.getOperationType():

				default:
				return new Expense(fields.get(0), fields.get(1), fields.get(2), fields.get(3), fields.get(4), fields.get(5), fields.get(6));
		}

	}

	private static Expense getExpense
}
