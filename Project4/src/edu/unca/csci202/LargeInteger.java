package edu.unca.csci202;

import java.util.ArrayList;

public interface LargeInteger extends Comparable<LargeInteger> {

	public LargeInteger add(LargeInteger other);

	public LargeInteger subtract(LargeInteger other);

	public LargeInteger negate();

	public LargeInteger abs();

	public LargeInteger multiply(LargeInteger other);

	public LargeInteger max(LargeInteger other);

	public LargeInteger min(LargeInteger other);

	public LargeInteger signum();

	public boolean isNegatve();

	public ArrayList<Integer> getValue();
}
