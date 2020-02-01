package com.jza;

import com.jza.models.Expense;

import java.util.ArrayList;
import java.util.List;

import static com.jza.models.OperationTypeEnum.*;

public class ExpenseFactory {
	public static List<String> FIELDS;
	public static Expense EXPENSE;

	public static Expense createExpense(List<String> fields) {
		FIELDS = new ArrayList<>(fields);
		EXPENSE = new Expense(FIELDS.get(0), FIELDS.get(1), FIELDS.get(FIELDS.size() - 1));

		String type = FIELDS.get(fields.size() - 1);
		if (type.equals(ODSETKI.getOperation())) {
			forODSETKI();
		} else if (type.equals(PODATEK.getOperation())) {
			forPODATEK();
		} else if (type.equals(PRZELEWMB.getOperation()) || type.equals(PRZELEW_INTERNET.getOperation())) {
			forPRZELEW();
		} else if (type.equals(PROWIZJE.getOperation())) {
			forPROWIZJE();
		} else if (type.substring(0, 17).equals(PRZELEW_KRAJOWY.getOperation().substring(0, 17))) {
			forPRZELEW_KRAJOWY();
		} else if (type.substring(0, 15).equals(KARTA.getOperation().substring(0, 15))) {
			forKARTA();
		}
		return EXPENSE;

	}

	private static void forODSETKI() {
		EXPENSE.amount = FIELDS.get(2);
		EXPENSE.currency = FIELDS.get(3);
	}

	private static void forPODATEK() {
		EXPENSE.amount = FIELDS.get(2);
		EXPENSE.currency = FIELDS.get(3);
		EXPENSE.refNumber = FIELDS.get(4);
	}

	private static void forPRZELEW() {
		EXPENSE.entityDetails = FIELDS.get(2);
		EXPENSE.entityBillNumber = FIELDS.get(3);
		EXPENSE.title = FIELDS.get(4);
		EXPENSE.amount = FIELDS.get(5);
		EXPENSE.currency = FIELDS.get(6);
		EXPENSE.refNumber = FIELDS.get(7);
	}

	private static void forPROWIZJE() {
		EXPENSE.entityBillNumber = FIELDS.get(2);
		EXPENSE.title = FIELDS.get(3);
		EXPENSE.amount = FIELDS.get(4);
		EXPENSE.currency = FIELDS.get(5);
		EXPENSE.refNumber = FIELDS.get(6);
	}

	private static void forPRZELEW_KRAJOWY() {
		EXPENSE.entityDetails = FIELDS.get(2);
		EXPENSE.entityBillNumber = FIELDS.get(3);
		EXPENSE.title = FIELDS.get(4);
		EXPENSE.amount = FIELDS.get(5);
		EXPENSE.currency = FIELDS.get(6);
	}

	private static void forKARTA() {
		String details = FIELDS.get(2).substring(0, FIELDS.get(2).length() - 17); // remove card number
		EXPENSE.entityDetails = details;
		EXPENSE.amount = FIELDS.get(3);
		EXPENSE.currency = FIELDS.get(4);
		EXPENSE.refNumber = FIELDS.get(5);
	}

}
