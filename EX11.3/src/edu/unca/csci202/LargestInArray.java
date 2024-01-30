package edu.unca.csci202;

import java.util.Arrays;
import java.util.Random;

public class LargestInArray {

	public static void main(String[] args) {
		Random rand = new Random();
		int[] array = new int[rand.nextInt(50)];
		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(1000);
		}
		int largestNum = Integer.MIN_VALUE;
		int index = -1;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > largestNum) {
				largestNum = array[i];
				index = i;
			}
		}
		System.out.println(Arrays.toString(array));
		System.out.println("The largest number is " + largestNum + " and it occurs at index " + index);
	}

}
