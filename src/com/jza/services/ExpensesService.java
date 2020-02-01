package com.jza.services;

import com.jza.ExpenseFactory;
import com.jza.models.Expense;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ExpensesService {

	public static List<Expense> getExpenses(List<Path> paths) throws IOException {
		List<Expense> expenses = new ArrayList<>();
		for (Path path : paths) {
			expenses.addAll(getExpensesFromFile(path));
		}
		expenses.sort(Comparator.comparing(o -> o.dateOfAccounting));
		return expenses;
	}

	private static List<Expense> getExpensesFromFile(Path path) throws IOException {
		List<Expense> expenses = new ArrayList<>();
		File inputFile = new File(path.toString(), "");
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), StandardCharsets.UTF_8))) {
			String st = br.readLine(); // skip first line with columns names
			while ((st = br.readLine()) != null) {
				List<String> fields = removeBlanks(Arrays.asList(st.split("\t")));
				expenses.add(ExpenseFactory.createExpense(fields));
			}
		}
		return expenses;
	}

	private static List<String> removeBlanks(List<String> values) {
		return values.stream().filter(value -> (!value.isEmpty() && !value.equals("\t"))).collect(Collectors.toList());
	}
}
