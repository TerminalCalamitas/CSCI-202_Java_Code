package edu.unca.csci202;

public class RecursiveAddition {
	public static int methods = 0;

	public static void main(String[] args) {
		System.out.println(sumToN(1));
		System.out.println("Method calls: " + methods);
		methods = 0;
		System.out.println(sumToN(2));
		System.out.println("Method calls: " + methods);
		methods = 0;
		System.out.println(sumToN(3));
		System.out.println("Method calls: " + methods);
		methods = 0;
		System.out.println(sumToN(4));
		System.out.println("Method calls: " + methods);
		methods = 0;
		System.out.println(sumToN(5));
		System.out.println("Method calls: " + methods);
		methods = 0;
		System.out.println(sumToN(6));
		System.out.println("Method calls: " + methods);
		methods = 0;
		System.out.println(sumToN(7));
		System.out.println("Method calls: " + methods);
		methods = 0;
		System.out.println(sumToN(8));
		System.out.println("Method calls: " + methods);
		methods = 0;

	}

	public static int sumToN(int end) {
		methods++;
		if (end == 1) {
			return 1;
		} else {
			int midpoint = end / 2;
			return sumToN(midpoint) + midpointSum(midpoint + 1, end);
		}
	}

	public static int midpointSum(int start, int end) {
		methods++;
		if (start == end) {
			return start;
		} else {
			int midpoint = (start + end) / 2;
			return midpointSum(start, midpoint) + midpointSum(midpoint + 1, end);
		}
	}
}
