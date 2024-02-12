package unca.edu.csci202;

/**
 * A simple 3 stack implementation to see if a string is a palindrome
 * 
 * @author Caleb Knapp
 */
public class ArrayPalindrome {
	ArrayStack<String> stack1;
	ArrayStack<String> stack2;
	ArrayStack<String> stackFlipped;

	/**
	 * Runs a few tests to see if strings are palindromes.
	 * 
	 * @param args Command line arguments, not used in this code.
	 */
	public static void main(String[] args) {
		ArrayPalindrome palin = new ArrayPalindrome();
		System.out.println("Is racecar a palindrome? " + palin.isPalindrome("racecar"));
		System.out.println("Is Racecar a palindrome? " + palin.isPalindrome("Racecar"));
		System.out.println("Is pickle a palindrome? " + palin.isPalindrome("pickle"));
		System.out.println("Is rotator a palindrome? " + palin.isPalindrome("rotator"));
		System.out.println("Is cartel a palindrome? " + palin.isPalindrome("cartel"));
		System.out.println("Is civic a palindrome? " + palin.isPalindrome("civic"));
		System.out.println("Is r a palindrome? " + palin.isPalindrome("r"));

	}

	/**
	 * Initializes the three arrays to a String type ArrayStack.
	 */
	public ArrayPalindrome() {
		stack1 = new ArrayStack<String>();
		stack2 = new ArrayStack<String>();
		stackFlipped = new ArrayStack<String>();
	}

	/**
	 * Takes the string, puts it into two stacks, then flips the second and checks
	 * if they are equal then finally clears the stack and returns.
	 * 
	 * @param testString The string being tested if it's a palindrome.
	 * @return Returns a boolean if the string is a palindrome or not.
	 */
	public boolean isPalindrome(String testString) {
		boolean palindrome = true;
		// Add chars to two stacks
		for (int i = 0; i < testString.length(); i++) {
			stack1.push(testString.substring(i, i + 1));
			stack2.push(testString.substring(i, i + 1));
		}
		// flip from stack 2 to stackFlipped
		for (int i = 0; i < testString.length(); i++) {
			stackFlipped.push(stack2.pop());
		}

		// compare the two stacks
		for (int i = 0; i < testString.length(); i++) {
			if (!stack1.pop().equals(stackFlipped.pop())) {
				palindrome = false;
			}
		}
		clear();
		return palindrome;
	}

	/**
	 * Sets each stack to a new String type ArrayStack
	 */
	private void clear() {
		stack1 = new ArrayStack<String>();
		stack2 = new ArrayStack<String>();
		stackFlipped = new ArrayStack<String>();
	}

}
