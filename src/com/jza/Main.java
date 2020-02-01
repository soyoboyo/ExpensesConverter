package com.jza;

import com.jza.services.ExpensesService;
import com.jza.services.FilesService;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		FilesService.saveExpensesToFile(ExpensesService.getExpenses(FilesService.getPaths()));
	}

}
