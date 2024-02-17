package edu.unca.csci202;

import java.util.Scanner;
import java.util.Stack;

/**
 * An interactive Reverse Polish Notation (RPN) calculator
 */
public class RPNCalculator {

	// stack used to process RPN expression
	private Stack<Double> calcStack;
	// Boolean so that only one error prints.
	private boolean error;

	/**
	 * Just a Constructor
	 */
	public RPNCalculator() {
	}

	/**
	 * run the interactive calculator loops, reading and evaluating RPN expressions
	 * until the user enters "q" to quit
	 */
	public void run() {
		Scanner inputLineReader = new Scanner(System.in);
		String line = "";
		boolean quit = false;

		while (!quit) {
			while (line.equals("")) {
				System.out.print(":::> ");
				line = inputLineReader.nextLine().trim();
			}
			quit = interpretExpression(line);
			// if proper expression, result will be only element on stack
			printResult(quit);
			line = "";
		}
		inputLineReader.close();
	}

	/**
	 * Parse a RPN expression using a stack If the expression is valid, the result
	 * of the calculation will be the only thing left on the stack after this method
	 * ends.
	 * 
	 * @param line the RPN expression to calculate
	 * @return true if the user wants to quit
	 */
	private boolean interpretExpression(String line) {
		// Reseting instance variables
		calcStack = new Stack<Double>();
		error = false;

		Scanner lineParser = new Scanner(line);
		String token = "";
		boolean quit = false;
		double operand = 0.0;

		while (lineParser.hasNext()) {
			token = lineParser.next();
			// comment out this next line in final version
			// System.out.println("processing token " + token);

			if (token.equals("+")) {
				if (calcStack.size() < 2) {
					error = true;
					printError("not enough operands");
				} else {
					double num1 = calcStack.pop();
					double num2 = calcStack.pop();
					calcStack.push(num2 + num1);
				}
				continue;
			} else if (token.equals("-")) {
				if (calcStack.size() < 2) {
					error = true;
					printError("not enough operands");
				} else {
					double num1 = calcStack.pop();
					double num2 = calcStack.pop();
					calcStack.push(num2 - num1);
				}
				continue;
			} else if (token.equals("*")) {
				if (calcStack.size() < 2) {
					error = true;
					printError("not enough operands");
				} else {
					double num1 = calcStack.pop();
					double num2 = calcStack.pop();
					calcStack.push(num2 * num1);
				}
				continue;
			} else if (token.equals("/")) {
				if (calcStack.size() < 2) {
					error = true;
					printError("not enough operands");

				} else {
					double num1 = calcStack.pop();
					double num2 = calcStack.pop();
					calcStack.push(num2 / num1);
				}
				continue;
			}

			if (token.equals("q")) {
				quit = true;
				continue;
			}

			try {
				calcStack.push(Double.parseDouble(token));
			} catch (Exception e) {
				error = true;
				error = true;
				printError("unrecognized token");
				break;
			}

		}
		return quit;
	}

	/**
	 * Simple method to print errors messages from operation.
	 * 
	 * @param reason String containing why there is an error.
	 */
	private void printError(String reason) {
		System.out.println("Invalid Input: " + reason);
		System.out.println("NaN");
	}

	/**
	 * Pop the result off the stack and print it
	 * 
	 * @param quit Won't print if quitting the program
	 */
	private void printResult(boolean quit) {
		if (!quit) {
			// Won't print an error if there already is one
			if (calcStack.size() != 1 && !error) {
				printError("too many operands");
			} else if (!error) {
				System.out.println(calcStack.pop());
			}
		}

	}

	/**
	 * Initialize the RPN calculator and launch the interactive program
	 * 
	 * @param args command line args (not used)
	 */
	public static void main(String[] args) {
		RPNCalculator calc = new RPNCalculator();
		calc.run();
	}

}
