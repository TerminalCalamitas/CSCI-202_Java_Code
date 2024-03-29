package edu.unca.csci202;

public class RecursiveMultiplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(recursiveMult(1, 0));
		System.out.println(recursiveMult(11, 2));
		System.out.println(recursiveMult(12, 3));
		System.out.println(recursiveMult(6, 5));
		System.out.println(recursiveMult(2, -8));
		System.out.println(recursiveMult(0, 12));
	}

	/*
	 * B: p = 0; j = 0 R: p = i + R(i-1); j >= 1
	 */
	public static int recursiveMult(int num1, int num2) {
		if (num1 == 0) {
			return 0;
		} else {
			return num2 + recursiveMult(num1 - 1, num2);
		}
	}
}
