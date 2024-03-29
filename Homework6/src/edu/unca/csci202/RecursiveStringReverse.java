package edu.unca.csci202;

public class RecursiveStringReverse {

	public static void main(String[] args) {
		System.out.println("hello");
		System.out.println(reverseString("hello"));
	}

	public static String reverseString(String str) {
		if (str.isEmpty() || str.length() == 1) {
			return str;
		} else {
			return reverseString(str.substring(1)) + str.charAt(0);
		}
	}

}
