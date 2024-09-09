package edu.unca.csci202;

import java.util.ArrayList;

import javax.print.attribute.standard.MediaSize.Other;

public class ArrayLargeInteger implements LargeInteger {
    private boolean negative;
    private ArrayList<Integer> value;

    /**
     * Constructor that takes an arrayList
     * 
     * @param arraylist An Integer ArrayList representing a LargeInteger
     */
    public ArrayLargeInteger(ArrayList<Integer> arraylist) {
	trimLeadingZeros(arraylist);
	value = arraylist;
    }

    /**
     * Constructor that takes a String
     * 
     * @param strValue A String representing a LargeInteger
     */
    public ArrayLargeInteger(String strValue) {
	negative = (strValue.charAt(0) == '-');
	value = new ArrayList<Integer>();
	// strings are looped backwards to make operations a forwards loop
	for (int i = strValue.length() - 1; i > 0; i--) {
	    value.add(strValue.charAt(i) - '0');
	}

	if (!negative) {
	    value.add(strValue.charAt(0) - '0');
	}
	trimLeadingZeros(value);
    }

    /**
     * Compares a given LargeInteger to the one calling the function
     * 
     * @param other A LargeInteger to compare values against
     * @return Relation of other to this. -1 is less, 0 is equal, 1 is greater.
     */
    public int compareTo(LargeInteger other) {
	if (this.signum() != other.signum()) {
	    return this.signum() > 0 ? 1 : -1;
	}

	if (this.getValue().size() != other.getValue().size()) {
	    increaseLen(this, other);
	}
	// looping from largest values to ones place.
	for (int i = value.size() - 1; i >= 0; i--) {
	    // if negative and ith digit greater value is less
	    if (this.value.get(i) > other.getValue().get(i)) {
		return 1;
	    } else if (this.value.get(i) < other.getValue().get(i)) {
		return -1;
	    }
	}

	return 0;
    }

    /**
     * Function to check if the LargeInteger is negative
     * 
     * @return Value of the negative boolean.
     */
    private boolean isNegative() {
	return negative;
    }

    /**
     * Sets the value of negative to the input.
     * 
     * @param value Boolean of whether the number should be negative or not.
     */
    private void setNegative(boolean value) {
	this.negative = value;
    }

    /**
     * Function to get the value of the LargeInteger
     * 
     * @return The LargeInteger's value
     */
    public ArrayList<Integer> getValue() {
	return value;
    }

    /**
     * Adds two LargeInteger objects
     * 
     * @param other The Large integer to be added
     * @return Value of the two LargeIntegers added together
     */
    public LargeInteger add(LargeInteger other) {

	// handling addition with negatives
	if (this.signum() == -1) {
	    LargeInteger temp = new ArrayLargeInteger(this.getValue());
	    return other.subtract(temp);
	} else if (other.signum() == -1) {
	    LargeInteger temp = new ArrayLargeInteger(other.getValue());
	    temp.negate();
	    return this.subtract(temp);
	}

	// make sure inputs are same length by putting 0 in front
	if (this.getValue().size() != other.getValue().size()) {
	    increaseLen(this, other);
	}

	// addition
	ArrayList<Integer> sum = new ArrayList<Integer>();
	int remainder = 0;
	for (int i = 0; i <= this.getValue().size(); i++) {
	    if (i == this.getValue().size()) {
		if (remainder == 1) {
		    sum.add(remainder);
		}
		break;
	    }
	    // Adding ith value
	    int sumI = this.getValue().get(i) + other.getValue().get(i);
	    // Adding previous remainder
	    sumI += remainder;

	    remainder = 0;

	    // If sum > 10 we only need the ones place and increase the remainder
	    if (sumI >= 10) {
		sumI = sumI % 10;
		remainder = 1;
	    }
	    // Add value to list
	    sum.add(sumI);
	}
	return new ArrayLargeInteger(sum);

    }

    public LargeInteger subtract(LargeInteger other) {
	// if this < other, -(other - this)
	if (this.compareTo(other) == -1) {
	    LargeInteger diff = other.subtract(this);
	    return diff.negate();
	}

	// double negation
	if (other.signum() == -1) {
	    LargeInteger temp = other;

	    return this.add(temp.negate());
	}
	// Align lengths and handle negatives
	if (this.getValue().size() != other.getValue().size()) {
	    increaseLen(this, other);
	}
	// Subtraction
	ArrayList<Integer> difference = new ArrayList<>();
	int borrow = 0;
	for (int i = 0; i < this.getValue().size(); i++) {
	    int differenceI = this.getValue().get(i) - other.getValue().get(i) - borrow;
	    borrow = 0;

	    // Handle borrow
	    if (differenceI < 0) {
		differenceI += 10;
		borrow = 1;
	    }

	    difference.add(differenceI);
	}

	// Remove leading zeros
	trimLeadingZeros(difference);

	return new ArrayLargeInteger(difference);
    }

    /**
     * Swaps the negative value of the LargeInteger
     * 
     * @return A negative version of the original LargeInteger
     */
    public LargeInteger negate() {
	boolean negative = this.isNegative();
	ArrayLargeInteger rtrnLI = new ArrayLargeInteger(this.getValue());
	rtrnLI.setNegative(!negative);
	return rtrnLI;
    }

    /**
     * Returns the positive value of a LargeInteger
     * 
     * @return A positive LargeInteger
     */
    public LargeInteger abs() {
	ArrayLargeInteger rtrnLI = this;
	rtrnLI.setNegative(false);
	return rtrnLI;
    }

    /**
     * Multiplies the LargeInteger with the provided LargeInteger
     * 
     * @param other TheLarge integer to be multiplied
     * @return Value of the two LargeIntegers multiplied together
     */
    public LargeInteger multiply(LargeInteger other) {
	// Negative multiplication examples
	if (this.signum() == -1) {
	    return this.negate().multiply(other).negate();
	} else if (other.signum() == -1) {
	    return this.multiply(other.negate()).negate();
	}

	// Arraylist to store result
	ArrayList<Integer> product = new ArrayList<>();

	// Making product the length of both LargeIntegers combined
	for (int i = 0; i < this.getValue().size() + other.getValue().size(); i++) {
	    product.add(0);
	}
	int carry = 0;
	for (int i = 0; i < this.getValue().size(); i++) {

	    int firstNum = this.getValue().get(i);

	    // Multiply digit1 with each digit of other, starting from the least significant
	    // digit
	    for (int j = 0; j < other.getValue().size(); j++) {
		int secondNum = other.getValue().get(j);
		// product is equal to x * y + the carried numbers + value of previous products
		int intProduct = firstNum * secondNum + carry + product.get(i + j);
		carry = intProduct / 10;
		product.set(i + j, intProduct % 10);
	    }
	}
	// Handle any remaining carry
	product.set(product.size() - 1, carry);

	// get rid of any extra zeros that aren't needed
	trimLeadingZeros(product);
	return new ArrayLargeInteger(product);
    }

    /**
     * Returns the larger of the two LargeIntegers
     * 
     * @param other The other LargeInteger to check the value of
     * @return The greater valued LargeInteger
     */
    public LargeInteger max(LargeInteger other) {
	if (this.compareTo(other) == 1) {
	    return this;
	}
	return other;
    }

    /**
     * Returns the smaller of the two LargeIntegers
     * 
     * @param other The other LargeInteger to check the value of
     * @return The lesser valued LargeInteger
     */
    public LargeInteger min(LargeInteger other) {
	if (this.compareTo(other) == -1) {
	    return this;
	}
	return other;
    }

    /**
     * Compares a LargeInteger to 0
     * 
     * @return Relation of the LargeInteger to 0. -1 is less, 0 is equal, 1 is
     *         greater.
     */
    public int signum() {
	ArrayLargeInteger temp = new ArrayLargeInteger(this.getValue());
	temp.trimLeadingZeros(value);
	if (temp.getValue().size() == 1 && temp.getValue().get(0) == 0) {
	    return 0;
	}
	return this.isNegative() ? -1 : 1;
    }

    /**
     * Makes both LargeIntegers the same length by adding 0s in front of the shorter
     * number
     * 
     * @param list1 A large integer to potentially make longer
     * @param list2 A large integer to potentially make longer
     */
    private void increaseLen(LargeInteger list1, LargeInteger list2) {
	// if list 1 shorter than list 2 grow list 1
	if (list1.getValue().size() < list2.getValue().size()) {
	    while (list1.getValue().size() < list2.getValue().size()) {
		// 0001 is the same as 1
		list1.getValue().add(0);
	    }
	} else {
	    // list 2 is shorter than list 1 so grow list 2
	    while (list2.getValue().size() < list1.getValue().size()) {
		list2.getValue().add(0);
	    }
	}
    }

    /**
     * A method to remove extra zeros in front of a LargeInteger
     * 
     * @param list The LargeInteger to trim zeros from
     */
    private void trimLeadingZeros(ArrayList<Integer> list) {
	while (list.size() > 1 && list.get(list.size() - 1) == 0) {
	    list.remove(list.size() - 1);
	}
    }

    /**
     * Method to turn the LargeInteger into a String
     * 
     * @return String of the LargeInteger's value
     */
    public String toString() {
	String rtrnStr = "";

	if (negative) {
	    rtrnStr += "-";
	}

	for (int i = value.size() - 1; i >= 0; i--) {
	    rtrnStr += value.get(i);
	}

	return rtrnStr;
    }

}
