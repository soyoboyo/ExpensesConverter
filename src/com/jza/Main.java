package com.jza;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) throws IOException {
		String folder = "C:\\Users\\Jacek\\Downloads\\expenses\\jan20";

		File outputFile = new File(folder + "\\test.csv");


		List<Path> paths = listFilesForFolder(folder).stream().filter(p -> p.toString().endsWith(".txt")).collect(Collectors.toCollection(ArrayList::new));
		System.out.println(paths.toString());
		List<Expense> expenses = new ArrayList<>();
		for (Path path : paths) {
			expenses.addAll(getExpenses(path));
		}
		Collections.sort(expenses, Comparator.comparing(o -> o.dateOfAccounting));


		PrintWriter printWriter = new PrintWriter(outputFile);
		for (Expense e : expenses) {
			printWriter.println(e.getCSVformat());
		}
		printWriter.close();
	}

	private static List<Expense> getExpenses(Path path) throws IOException {
		List<Expense> expenses = new ArrayList<>();
		File inputFile = new File(path.toString());
		BufferedReader br = new BufferedReader(new FileReader(inputFile));
		String st = br.readLine();
		while ((st = br.readLine()) != null) {
			List<String> columns = removeBlanks(Arrays.asList(st.split("\t")));
			Expense e = createExpense(columns);
			System.out.println(columns.size());
			System.out.println(e);
			expenses.add(createExpense(columns));
		}
		return expenses;
	}



	public static ArrayList<Path> listFilesForFolder(String folder) {
		try (Stream<Path> paths = Files.walk(Paths.get(folder))) {
			return paths.filter(Files::isRegularFile).collect(Collectors.toCollection(ArrayList::new));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static List<String> removeBlanks(List<String> arr) {
		List<String> clean = new ArrayList<>();
		for (int i = 0; i < arr.size(); i++) {
			String val = arr.get(i);
			if (!val.isEmpty() && !val.equals("\t")) {
				clean.add(val);
			}
		}
		return clean;
	}
}
