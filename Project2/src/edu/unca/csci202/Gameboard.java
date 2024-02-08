package edu.unca.csci202;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Caleb Knapp
 */
public class Gameboard {
	private Cell[][] board;
	private Scanner input;
	private boolean gameOver;
	private boolean firstGame = true;

	/**
	 * 
	 */
	public Gameboard() {
		input = new Scanner(System.in);

	}

	/**
	 * 
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
	 * 
	 */
	private void prepBoard() {
		// Setting up object variables
		gameOver = false;

		// Setting up the board
		board = new Cell[8][8];
		fillBoard();
		placeMines();
	}

	/**
	 * 
	 */
	// I tried to make this funtion as simple as possible
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
		if (mineGuess == board[row - 1][col - 1].getCellValue().equals("M")) {
			board[row - 1][col - 1].flip(board, row, col);

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
	 * 
	 * @param question
	 * @return
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
	 * 
	 * @param inputTitle
	 * @return
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
	 * 
	 * @param input
	 * @return
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
	 * 
	 * @return
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
	 * 
	 */
	private void fillBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = new Cell();
			}
		}
	}

	/**
	 * 
	 */
	private void placeMines() {
		Random rand = new Random();
		int minesPlaced = 0;
		while (minesPlaced < 10) {
			int x = rand.nextInt(8);
			int y = rand.nextInt(8);
			// Only places mine if space is not already a mine
			if (!board[x][y].getCellValue().equals("M")) {
				board[x][y].setCellValue("M");
				minesPlaced++;
			}
		}
	}

	/**
	 * 
	 * @param peak
	 * @return
	 */
	public String toString(boolean peak) {
		// Initialize boardString so we can add chaaracters to it
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
