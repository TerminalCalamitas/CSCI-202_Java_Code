package edu.unca.csci202;

import java.util.ArrayList;

public class ArrayLargeInteger implements LargeInteger {
	private boolean negative;
	private ArrayList<Integer> value;

	public ArrayLargeInteger(String strValue) {
		negative = (strValue.charAt(0) == '-');
		value = new ArrayList<Integer>();

		for (int i = strValue.length() - 1; i > 0; i--) {
			value.add(strValue.charAt(i) - '0');
		}

		if (!negative) {
			value.add(strValue.charAt(0) - '0');
		}
	}

	public int compareTo(LargeInteger other) {
		for (int i = value.size() - 1; i > 0; i--) {
			if (this.value.get(i) != other.getValue().get(i)) {
				return this.isNegative() ? -1 : 1;
			}
		}

		return 0;
	}

	public boolean isNegative() {
		return negative;
	}

	public ArrayList<Integer> getValue() {
		return value;
	}

	public LargeInteger add(LargeInteger other) {
		// TODO Auto-generated method stub
		return null;
	}

	public LargeInteger subtract(LargeInteger other) {
		// TODO Auto-generated method stub
		return null;
	}

	public LargeInteger negate() {
		// TODO Auto-generated method stub
		return null;
	}

	public LargeInteger abs() {
		// TODO Auto-generated method stub
		return null;
	}

	public LargeInteger multiply(LargeInteger other) {
		// TODO Auto-generated method stub
		return null;
	}

	public LargeInteger max(LargeInteger other) {
		// TODO Auto-generated method stub
		return null;
	}

	public LargeInteger min(LargeInteger other) {
		// TODO Auto-generated method stub
		return null;
	}

	public LargeInteger signum() {
		// TODO Auto-generated method stub
		return null;
	}

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

	public boolean isNegatve() {
		// TODO Auto-generated method stub
		return false;
	}

}
