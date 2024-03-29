package edu.unca.csci202;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayLargeInteger largeInt = new ArrayLargeInteger("-123");
		ArrayLargeInteger largeInt2 = new ArrayLargeInteger("1234");

		System.out.println(largeInt);
		System.out.println(largeInt2);
		System.out.println(largeInt.compareTo(largeInt2));

	}

}
