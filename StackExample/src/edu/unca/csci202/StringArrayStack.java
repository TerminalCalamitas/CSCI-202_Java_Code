package edu.unca.csci202;

public class StringArrayStack {
	private int size;
	private String[] stack;

	public StringArrayStack() {
		size = 0;
		stack = new String[4];
	}

	public void push(String string) {
		if (size == stack.length) {
			doubleStack();
		}
		stack[size] = string;
		size++;
	}

	public String pop() {
		size--;
		String poppedElement = stack[size];
		stack[size] = null;
		return poppedElement;
	}

	public String peek() {
		if (!isEmpty()) {
			return stack[size - 1];
		} else {
			return stack[size];
		}
	}

	public String toString() {
		String stackString = "[";

		for (int i = 0; stack[i] != null; i++) {
			stackString += stack[i] + ", ";
		}

		return stackString + "]";
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	private void doubleStack() {
		String[] temp = new String[stack.length * 2];
		for (int i = 0; i < stack.length; i++) {
			temp[i] = stack[i];
		}
		stack = temp;
	}
}
