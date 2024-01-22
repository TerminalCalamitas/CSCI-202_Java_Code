package edu.unca.csci202;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);

	// Initializing a list of 10 ints
	Integer[] numList = new Integer[10];
	int inputNum = 0;

	// using a while loop since it may run an unknown number of times
	while (inputNum < 10) {
	    System.out.print("Enter integer " + (inputNum + 1) + ": ");
	    String input = scan.nextLine();
	    try {
		numList[inputNum] = Integer.parseInt(input);
		inputNum++;
	    } catch (NumberFormatException e) {
		System.out.println("Invalid integer.");
	    }
	}

	double inputSum = 0;
	// using print() to start the list of numbers
	System.out.print("The numbers are: ");

	for (int i = 0; i < numList.length; i++) {
	    // adds all numbers in the list to one sum
	    inputSum += numList[i];
	    // if i is at the end print the last number stuff
	    if (i == numList.length - 1) {
		System.out.print(numList[i] + "\n");
	    } else { // else prints a normal number
		System.out.print(numList[i] + ", ");
	    }
	}

	// calculates average
	double average = inputSum / numList.length;

	System.out.println("The average is: " + average);
    }

}
