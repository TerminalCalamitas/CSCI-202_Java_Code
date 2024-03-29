import java.util.Scanner;

public class BracketMatching {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int len = Integer.parseInt(input.nextLine());
		String expr = input.nextLine();
		char[] list = new char[len];
		input.close();

		int bracketCount = -1;
		for (char token : expr.toCharArray()) {
			if (token == '(' || token == '[' || token == '{') {
				list[++bracketCount] = token;
			} else {
				if (bracketCount >= 0
						&& ((list[bracketCount] == '(' && token == ')') || (list[bracketCount] == '[' && token == ']')
								|| (list[bracketCount] == '{' && token == '}'))) {
					bracketCount--;
				} else {
					System.out.println("Invalid");
					return;
				}

			}

		}
		// I learned this in csci 235
		System.out.println(bracketCount == -1 ? "Valid" : "Invalid");

	}
}
