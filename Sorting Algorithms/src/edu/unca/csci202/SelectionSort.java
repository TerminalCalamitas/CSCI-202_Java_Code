package edu.unca.csci202;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		int[] nums = { 1, 98, 2, 0, 67, 3, 88 };
		System.out.println(Arrays.toString(nums));
		selectionSort(nums);
		System.out.print("sorted: ");
		System.out.println(Arrays.toString(nums));

		int[] nums0 = {};
		System.out.println(Arrays.toString(nums0));
		selectionSort(nums0);
		System.out.print("sorted: ");
		System.out.println(Arrays.toString(nums0));

		int[] nums1 = { 3, 2 };
		System.out.println(Arrays.toString(nums1));
		selectionSort(nums1);
		System.out.print("sorted: ");
		System.out.println(Arrays.toString(nums1));
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
