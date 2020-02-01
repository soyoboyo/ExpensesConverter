package com.jza;

import com.jza.models.Expense;

import java.util.List;

import static com.jza.models.OperationTypeEnum.*;

public class ExpenseFactory {

	public static Expense createExpense(List<String> fields) {
		String type = fields.get(fields.size() - 1);
		if (type.equals(ODSETKI.getOperation())) {
			return new Expense(fields.get(0), fields.get(1), null, null, null, fields.get(2), fields.get(3), null, fields.get(4));
		} else if (type.equals(PODATEK.getOperation())) {
			return new Expense(fields.get(0), fields.get(1), null, null, null, fields.get(2), fields.get(3), fields.get(4), fields.get(5));
		} else if (type.equals(PRZELEWMB.getOperation())) {
			return new Expense(fields.get(0), fields.get(1), fields.get(2), fields.get(3), fields.get(4), fields.get(5), fields.get(6), fields.get(7), fields.get(8));
		} else if (type.equals(PRZELEW_INTERNET.getOperation())) {
			return new Expense(fields.get(0), fields.get(1), fields.get(2), fields.get(3), fields.get(4), fields.get(5), fields.get(6), fields.get(7), fields.get(8));
		} else if (type.equals(PROWIZJE.getOperation())) {
			return new Expense(fields.get(0), fields.get(1), null, fields.get(2), fields.get(3), fields.get(4), fields.get(5), fields.get(6), fields.get(7));
		} else if (type.substring(0, 17).equals(PRZELEW_KRAJOWY.getOperation().substring(0, 17))) {
			return new Expense(fields.get(0), fields.get(1), fields.get(2), fields.get(3), fields.get(4), fields.get(5), fields.get(6), null, fields.get(7));
		} else if (type.substring(0, 15).equals(KARTA.getOperation().substring(0, 15))) {
			return forKARTA(fields);
		} else {
			return null;
		}
	}

	private static Expense forKARTA(List<String> fields) {
		String details = fields.get(2).substring(0, fields.get(2).length() - 17); // remove card number
		return new Expense(fields.get(0), fields.get(1), details, null, null, fields.get(3), fields.get(4), fields.get(5), fields.get(6));
	}

}
