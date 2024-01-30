package edu.unca.csci202;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int[] nums = { 1, 98, 2, 0, 67, 3, 88 };
		System.out.println(Arrays.toString(nums));
		insertionSort(nums);
		System.out.print("sorted: ");
		System.out.println(Arrays.toString(nums));

		int[] nums0 = {};
		System.out.println(Arrays.toString(nums0));
		insertionSort(nums0);
		System.out.print("sorted: ");
		System.out.println(Arrays.toString(nums0));

		int[] nums1 = { 3, 2 };
		System.out.println(Arrays.toString(nums1));
		insertionSort(nums1);
		System.out.print("sorted: ");
		System.out.println(Arrays.toString(nums1));
	}

	public static void insertionSort(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			int currentNum = nums[i];
			int j = i - 1;
			while (currentNum > nums[j] && j > 0) {
				nums[j + 1] = nums[j];
				j--;
			}
			nums[j] = currentNum;
		}
	}

	// swaps values
	public static void swap(int[] array, int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
}
