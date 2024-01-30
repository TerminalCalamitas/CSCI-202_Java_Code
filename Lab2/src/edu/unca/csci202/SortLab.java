package edu.unca.csci202;

import java.util.Random;
import java.util.Scanner;

public class SortLab {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random rand = new Random();

		// Getting user input
		System.out.print("Enter name of sotring algorithm (e.g. “selection”, “insertion”, or “bubble”): ");
		String sortMethod = input.nextLine();
		System.out.print("Enter array size: ");
		String size = input.nextLine();
		int arraySize = 0;

		if (size.equals("")) {
			for (int i = 50000; i <= 300000; i += 50000) {
				int[] array = new int[i];
				for (int j = 0; j < i; j++) {
					array[j] = rand.nextInt();
				}
				System.out.println("Time of execution for size " + i + " is: " + getExecutionTime(sortMethod, array));
			}
		} else {
			arraySize = Integer.parseInt(size);
			// Making and filling array
			int[] array = new int[arraySize];
			for (int i = 0; i < arraySize; i++) {
				array[i] = rand.nextInt(1000);
			}

			// System.out.println("Original array: " + Arrays.toString(array));
			System.out.println("Time of execution is: " + getExecutionTime(sortMethod, array));
			// System.out.println("Sorted array: " + Arrays.toString(array));
		}

		System.out.println("Sorting finished!");
	}

	public static double getExecutionTime(String sort, int[] array) {
		long start = 0;
		long end = 0;
		if (sort.equalsIgnoreCase("selection")) {
			start = System.nanoTime();
			selectionSort(array);
			end = System.nanoTime();
		} else if (sort.equalsIgnoreCase("insertion")) {
			start = System.nanoTime();
			// insertionSort(array);
			end = System.nanoTime();
		} else if (sort.equalsIgnoreCase("bubble")) {
			start = System.nanoTime();
			// bubbleSort(array);
			end = System.nanoTime();
		} else {
			System.out.println("Invalid sort method.");
		}

		// Calculating execution time
		double executionTime = (end - start);
		double timeInSeconds = executionTime / 1000000000;
		return timeInSeconds;
	}

	public static void selectionSort(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			int smallestIndex = getSmallestIndex(nums, i);
			swap(nums, i, smallestIndex);
		}
	}

	// returns the index of the smallest element starting at a certain index
	public static int getSmallestIndex(int[] nums, int startIndex) {
		int indexOfSmallest = startIndex;
		for (int i = startIndex; i < nums.length; i++) {
			if (nums[i] < nums[indexOfSmallest]) {
				indexOfSmallest = i;
			}
		}

		return indexOfSmallest;
	}

	// swaps values
	public static void swap(int[] array, int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}

}
