package com.jza.services;

import com.jza.models.Expense;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilesService {
	final static String PERIOD = "jan20";
	final static String FOLDER = "C:\\Users\\Jacek\\Downloads\\expenses\\";
	final static String PERIOD_FOLDER = "C:\\Users\\Jacek\\Downloads\\expenses\\" + PERIOD;
	final static File OUTPUT_FILE = new File(FOLDER + "\\" + PERIOD + ".csv");

	public static List<Path> getPaths() {
		return listFilesForFolder(PERIOD_FOLDER).stream().filter(p -> p.toString().endsWith(".txt")).collect(Collectors.toCollection(ArrayList::new));
	}

	public static List<Path> listFilesForFolder(String folder) {
		try (Stream<Path> paths = Files.walk(Paths.get(folder))) {
			return paths.collect(Collectors.toCollection(ArrayList::new));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	public static void saveExpensesToFile(List<Expense> expenses) throws FileNotFoundException {
		PrintWriter printWriter = new PrintWriter(OUTPUT_FILE);
		expenses.forEach(e -> printWriter.println(e.getCSVformat()));
		printWriter.close();
	}
}
