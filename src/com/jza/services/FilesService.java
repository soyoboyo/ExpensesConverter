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
	private final static String PERIOD = "\\jan20";
	private final static String FOLDER = "C:\\Users\\Jacek\\Downloads\\expenses\\";
	private final static String PERIOD_FOLDER = "C:\\Users\\Jacek\\Downloads\\expenses" + PERIOD;
	private final static File OUTPUT_FILE = new File(FOLDER + PERIOD + ".csv");

	public static List<Path> getPaths() {
		return new ArrayList<>(getPathsOfFiles(PERIOD_FOLDER));
	}

	public static List<Path> getPathsOfFiles(String folder) {
		try (Stream<Path> paths = Files.walk(Paths.get(folder))) {
			return paths.filter(p -> p.toString().endsWith(".txt")).collect(Collectors.toCollection(ArrayList::new));
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
