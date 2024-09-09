package edu.unca.csci202;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
	// Range of sizes for testing
	int[] sizes = { 100, 1000, 10000 };

	// Number of times to repeat each operation
	int repetitions = 1000;

	for (int i = 0; i < sizes.length; i++) {
	    System.out.println("Numbers are " + sizes[i] + " digits long");
	    String largeNumber = generateRandomString(sizes[i]);

	    // Create ArrayLargeInteger and BigInteger instances
	    LargeInteger arrayInt = new ArrayLargeInteger(largeNumber);
	    BigInteger bigInt = new BigInteger(largeNumber);

	    // Test methods and collect execution times
	    testMethods(arrayInt, repetitions);
	    testMethods(bigInt, repetitions);

	}
    }

    private static void testMethods(LargeInteger lI, int repetitions) {
	// Adding
	long sum = 0;
	for (int i = 0; i < repetitions; i++) {
	    long start = System.nanoTime();
	    lI.add(lI);
	    long end = System.nanoTime();
	    sum += (end - start);
	}
	System.out.println(
		"LargeInteger average of  " + repetitions + "  add executions: " + sum / repetitions + " nano seconds");

	// Subtracting
	sum = 0;
	for (int i = 0; i < repetitions; i++) {

	    long start = System.nanoTime();
	    lI.subtract(lI);
	    long end = System.nanoTime();
	    sum += (end - start);
	}
	System.out.println("LargeInteger average of  " + repetitions + "  subtract executions: " + sum / repetitions
		+ " nano seconds");

	// Negating
	sum = 0;
	for (int i = 0; i < repetitions; i++) {
	    long start = System.nanoTime();
	    lI.negate();

	    long end = System.nanoTime();
	    sum += (end - start);
	}
	System.out.println("LargeInteger average of  " + repetitions + "  negate executions: " + sum / repetitions
		+ " nano seconds");

	// Absoluting
	sum = 0;
	for (int i = 0; i < repetitions; i++) {
	    long start = System.nanoTime();
	    lI.abs();
	    long end = System.nanoTime();
	    sum += (end - start);
	}
	System.out.println(
		"LargeInteger average of  " + repetitions + "  abs executions: " + sum / repetitions + " nano seconds");

	// Multiplying
	sum = 0;
	for (int i = 0; i < repetitions; i++) {
	    long start = System.nanoTime();
	    lI.multiply(lI);
	    long end = System.nanoTime();
	    sum += (end - start);
	}
	System.out.println("LargeInteger average of  " + repetitions + "  multiply executions: " + sum / repetitions
		+ " nano seconds");

	// Max-ing
	sum = 0;
	for (int i = 0; i < repetitions; i++) {
	    long start = System.nanoTime();
	    lI.max(lI);
	    long end = System.nanoTime();
	    sum += (end - start);
	}
	System.out.println(
		"LargeInteger average of " + repetitions + " max executions: " + sum / repetitions + " nano seconds");

	// Min-ing
	sum = 0;
	for (int i = 0; i < repetitions; i++) {
	    long start = System.nanoTime();
	    lI.min(lI);
	    long end = System.nanoTime();
	    sum += (end - start);
	}
	System.out.println(
		"LargeInteger average of " + repetitions + " min executions: " + sum / repetitions + " nano seconds");

	// Signum-ing
	sum = 0;
	for (int i = 0; i < repetitions; i++) {
	    long start = System.nanoTime();
	    lI.signum();
	    long end = System.nanoTime();
	    sum += (end - start);
	}
	System.out.println("LargeInteger average of  " + repetitions + "  signum executions: " + sum / repetitions
		+ " nano seconds");
    }

    private static void testMethods(BigInteger bI, int repetitions) {
	// Adding
	long sum = 0;
	for (int i = 0; i < repetitions; i++) {
	    long start = System.nanoTime();
	    bI.add(bI);
	    long end = System.nanoTime();
	    sum += (end - start);
	}
	System.out.println(
		"BigInteger average of  " + repetitions + "  add executions: " + sum / repetitions + " nano seconds");

	// Subtracting
	sum = 0;
	for (int i = 0; i < repetitions; i++) {

	    long start = System.nanoTime();
	    bI.subtract(bI);
	    long end = System.nanoTime();
	    sum += (end - start);
	}
	System.out.println("BigInteger average of  " + repetitions + "  subtract executions: " + sum / repetitions
		+ " nano seconds");

	// Negating
	sum = 0;
	for (int i = 0; i < repetitions; i++) {
	    long start = System.nanoTime();
	    bI.negate();

	    long end = System.nanoTime();
	    sum += (end - start);
	}
	System.out.println("BigInteger average of  " + repetitions + "  negate executions: " + sum / repetitions
		+ " nano seconds");

	// Absoluting
	sum = 0;
	for (int i = 0; i < repetitions; i++) {
	    long start = System.nanoTime();
	    bI.abs();
	    long end = System.nanoTime();
	    sum += (end - start);
	}
	System.out.println(
		"BigInteger average of  " + repetitions + "  abs executions: " + sum / repetitions + " nano seconds");

	// Multiplying
	sum = 0;
	for (int i = 0; i < repetitions; i++) {
	    long start = System.nanoTime();
	    bI.multiply(bI);
	    long end = System.nanoTime();
	    sum += (end - start);
	}
	System.out.println("BigInteger average of  " + repetitions + "  multiply executions: " + sum / repetitions
		+ " nano seconds");

	// Max-ing
	sum = 0;
	for (int i = 0; i < repetitions; i++) {
	    long start = System.nanoTime();
	    bI.max(bI);
	    long end = System.nanoTime();
	    sum += (end - start);
	}
	System.out.println(
		"BigInteger average of " + repetitions + " max executions: " + sum / repetitions + " nano seconds");

	// Min-ing
	sum = 0;
	for (int i = 0; i < repetitions; i++) {
	    long start = System.nanoTime();
	    bI.min(bI);
	    long end = System.nanoTime();
	    sum += (end - start);
	}
	System.out.println(
		"BigInteger average of " + repetitions + " min executions: " + sum / repetitions + " nano seconds");

	// Signum-ing
	sum = 0;
	for (int i = 0; i < repetitions; i++) {
	    long start = System.nanoTime();
	    bI.signum();
	    long end = System.nanoTime();
	    sum += (end - start);
	}
	System.out.println(
		"BigInteger average of  " + repetitions + "  abs executions: " + sum / repetitions + " nano seconds");
    }

    private static String generateRandomString(int size) {
	String rtrnStr = "";
	int sign = Math.random() < 0.5 ? -1 : 1;
	if (sign == -1) {
	    rtrnStr += "-";
	}
	for (int i = 0; i < size; i++) {
	    rtrnStr += (int) (Math.random() * 10);
	}

	return rtrnStr;
    }

}
