package edu.unca.csci202;

import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

/**
 * Most of the core logic for the Minesweeper Game.
 * 
 * @author Caleb Knapp
 */
public class Gameboard {
	/** 2d array of Cell objects. */
	private Cell[][] board;
	/** Scanner for player input. */
	private Scanner input;
	/** A boolean on if the game has finished. */
	private boolean gameOver;
	/** Certain code will only execute if it is the first game. */
	private boolean firstGame = true;

	/**
	 * Initializes the input Scanner.
	 */
	public Gameboard() {
		input = new Scanner(System.in);
	}

	/**
	 * Method that starts off the game logic.
	 */
	public void run() {
		gameOver = false;
		prepBoard();

		// Only print welcome message if it is the first game
		if (firstGame) {
			System.out.println("Welcome to Minesweeper!");
			boolean play = getBooleanInput("Would you like to play a game?");

			// Leave the game if the player doesn't want to play
			if (!play) {
				System.out.println("Goodbye!");
				return;
			}
		}
		System.out.println(this.toString(false));

		// loops until the game is over
		while (!gameOver) {
			playerTurn();
		}

		// Prints messages after game is over
		System.out.println("Thank you for playing Minesweeper.");
		if (getBooleanInput("Would you like to play again?")) {
			firstGame = false;
			run();
		} else {
			System.out.println("Goodbye!");
		}

	}

	/**
	 * Creates board of 8x8 Cells then calls methods to fill them with appropriate
	 * values.
	 */
	private void prepBoard() {
		// Setting up object variables
		gameOver = false;

		// Setting up the board
		board = new Cell[8][8];
		placeMines();
		calculateValues();

	}

	/**
	 * Randomly places 10 mines on the board.
	 */
	private void placeMines() {
		Random rand = new Random();
		int minesPlaced = 0;
		while (minesPlaced < 10) {
			int x = rand.nextInt(8);
			int y = rand.nextInt(8);
			// Only places mine if space is not already a mine
			if (board[x][y] == null) {
				board[x][y] = new Cell(x, y);
				board[x][y].setCellValue("M");
				minesPlaced++;
			}
		}
	}

	/**
	 * Loops through full board and sets the cell values accordingly.
	 */
	private void calculateValues() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == null) {
					board[i][j] = new Cell(i, j);
					board[i][j].setCellValue(getNeighbors(i, j));
				}
			}
		}
	}

	/**
	 * Calculates how many mines neighbor a cell.
	 * 
	 * @param row The row of the Cell to calculate the value of.
	 * @param col The column of the Cell to calculate the value of.
	 * @return A string of the number of neighboring mines.
	 */
	private String getNeighbors(int row, int col) {
		int mineCount = 0;
		for (int i = row - 1; i <= row + 1; i++) {
			for (int j = col - 1; j <= col + 1; j++) {
				// Makes sure cell is in board, not null, and is a mine
				if (validIntInput("" + (i + 1)) && validIntInput("" + (j + 1)) && board[i][j] != null
						&& board[i][j].getCellValue().equals("M")) {
					mineCount++;
				}
			}
		}
		return "" + mineCount;
	}

	/**
	 * Gets the player's input and flips the correct cell.
	 */
	// I tried to make this function as simple as possible
	private void playerTurn() {
		int row = -1;
		int col = -1;

		// getBooleanInput handles incorrect inputs and only returns when a valid answer
		// is given
		boolean peek = getBooleanInput("Would you like to peek?");

		if (peek) {
			// True makes the board print hidden cells
			System.out.println(this.toString(true));
		}

		row = getIntInput("row");
		col = getIntInput("column");

		// Same boolean input method as before, but with a different question
		boolean mineGuess = getBooleanInput("Does row " + row + " and column " + col + " contain a mine?");
		// Guess not mine and isn't mine, or guess is mine and cell is a mine
		Cell boardLocation = board[row - 1][col - 1];
		if (mineGuess == boardLocation.getCellValue().equals("M")) {

			if (boardLocation.getCellValue().equals("0")) {
				expand(row - 1, col - 1);
			} else {
				board[row - 1][col - 1].flip();
			}

			if (checkWin()) {
				System.out.println("You win!");
				gameOver = true;
				return;
			}
		} else { // ends game if player incorrectly guesses that cell is mine
			System.out.println("Boom! You lose.");
			gameOver = true;
			return;
		}
		System.out.println(this.toString(false));
	}

	// For my two get<type>Input() methods I used a question variable so they could
	// be called from anywhere

	/**
	 * Gets a y or n input.
	 * 
	 * @param question A string of the question ending in a question mark.
	 * @return Returns the boolean that the player enters.
	 */
	private boolean getBooleanInput(String question) {
		System.out.print(question + " (y/n): ");
		String answer = input.nextLine();

		// loops until input is "y" or "n"
		while (!answer.equals("y") && !answer.equals("n")) {
			System.out.println("Invalid input, please try again.");
			System.out.print(question + " (y/n): ");
			answer = input.nextLine();
		}

		return answer.equalsIgnoreCase("y");
	}

	/**
	 * Gets an integer input between 1 and 8.
	 * 
	 * @param inputTitle The name of what needs an integer.
	 * @return Returns a number between 1 and 8.
	 */
	private int getIntInput(String inputTitle) {
		System.out.print("Please enter a " + inputTitle + " number: ");
		String strNum = input.nextLine();

		// loops until a number meets the validIntInput requirements
		while (!validIntInput(strNum)) {
			System.out.println("Invalid input, please try again.");
			System.out.print("Please enter a " + inputTitle + " number: ");
			strNum = input.nextLine();
		}

		return Integer.parseInt(strNum);
	}

	/**
	 * Makes sure given number is in range of the board.
	 * 
	 * @param input An integer as a string.
	 * @return Boolean of if the number is in the range of the board.
	 */
	private boolean validIntInput(String input) { // Makes sure input is a number and is in the board
		try {
			int row = Integer.parseInt(input);
			return row <= board.length && row > 0;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Loops around a Cell of value 0 and flips all their neighbors, adding any
	 * other neighboring cells if they have a value of 0.
	 * 
	 * @param row Integer representing row of the first 0 space.
	 * @param col Integer representing column of the first 0 space.
	 */
	private void expand(int row, int col) {
		// If a cell is visible we don't need too expand.
		if (board[row][col].isVisible()) {
			return;
		}
		Stack<Cell> stack = new Stack<Cell>();
		stack.push(board[row][col]);

		while (!stack.isEmpty()) {
			Cell currentCell = stack.pop();
			currentCell.flip();

			// Only add spaces around a cell if the cell is a 0 space.
			if (currentCell.getCellValue().equals("0")) {
				for (int i = currentCell.getRow() - 1; i <= currentCell.getRow() + 1; i++) {
					for (int j = currentCell.getCol() - 1; j <= currentCell.getCol() + 1; j++) {
						if (validIntInput("" + (i + 1)) && validIntInput("" + (j + 1)) && !board[i][j].isVisible()) {
							stack.push(board[i][j]);
						}
					}
				}
			}

		}
	}

	/**
	 * Checks if the game is at a winning state.
	 * 
	 * @return A boolean on if all mines are visible.
	 */
	private boolean checkWin() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				// checks if all mines are visible and exits if any hidden mine is found.
				if (board[i][j].getCellValue().equals("M") && !board[i][j].isVisible()) {
					return false;
				}
			}
		}

		return true;
	}

	/**
	 * A method to print the board with or without hiding the values of the squares.
	 * 
	 * @param peak If true, will print spaces even if they are hidden.
	 * @return Returns the board as a string.
	 */
	public String toString(boolean peak) {
		// Initialize boardString so we can add characters to it
		String boardString = "";
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				boardString += board[i][j].toString(peak);
			}
			boardString += "\n";
		}
		return boardString;
	}
}