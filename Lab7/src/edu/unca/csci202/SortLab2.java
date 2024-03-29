package edu.unca.csci202;

import java.util.Arrays;
import java.util.Random;

public class SortLab2 {

	public static void main(String[] args) {
		Sorting sort = new Sorting();
		for (int i = 5000; i <= 50000; i += 5000) {
			String[] bfa = generateArray(i, 10, 30);
			long start = System.nanoTime();
			Arrays.sort(bfa);
			long end = System.nanoTime();
			double execution = end - start;
			double execTime = execution / 1000000000;
			System.out.println("Arrays.sort: " + execTime);
		}

		System.out.println();

		for (int i = 5000; i <= 50000; i += 5000) {
			String[] bfa = generateArray(i, 10, 30);
			long start = System.nanoTime();
			sort.selectionSort(bfa);
			long end = System.nanoTime();
			double execution = end - start;
			double execTime = execution / 1000000000;
			System.out.println("Selection sort: " + execTime);
		}

		System.out.println();

		for (int i = 5000; i <= 50000; i += 5000) {
			String[] bfa = generateArray(i, 10, 30);
			long start = System.nanoTime();
			sort.quickSort(bfa);
			long end = System.nanoTime();
			double execution = end - start;
			double execTime = execution / 1000000000;
			System.out.println("Quick sort: " + execTime);
		}
	}

	public static String[] generateArray(int n, int minLength, int maxLength) {
		Random rand = new Random();
		String[] array = new String[n];
		char[] letters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		for (int i = 0; i < n; i++) {
			String str = "";
			// get str length
			int strLen = rand.nextInt(minLength, maxLength + 1);

			// generate str
			for (int j = 0; j < strLen; j++) {
				int index = rand.nextInt(26);
				str += letters[index];
			}

			// add str to array
			array[i] = str;
		}

		return array;
	}
}
