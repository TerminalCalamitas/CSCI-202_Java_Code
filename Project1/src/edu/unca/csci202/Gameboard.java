package edu.unca.csci202;

import java.util.Random;
import java.util.Scanner;

public class Gameboard {
	private Cell[][] board;
	private Scanner input;
	private boolean gameOver;

	public void run() {
		input = new Scanner(System.in);
		System.out.println("Welcome to Minesweeper!");
		System.out.print("Would you like to play a game? (y/n): ");
		String play = input.nextLine();
		while (!play.equalsIgnoreCase("y") && !play.equalsIgnoreCase("n")) {
			System.out.println("Invalid input, please try again.");
			System.out.print("Would you like to play a game? (y/n): ");
			play = input.nextLine();
		}
		if (play.equalsIgnoreCase("n")) {
			System.out.println("Goodbye!");
		} else {
			board = new Cell[8][8];
			fillBoard();
			placeMines();
			System.out.println(toString());
		}
	}

	private void fillBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = new Cell();
			}
		}
	}

	private void placeMines() {
		Random rand = new Random();
		int minesPlaced = 0;
		while (minesPlaced < 10) {
			int x = rand.nextInt(8);
			int y = rand.nextInt(8);
			if (!board[x][y].getCellValue().equals("M")) {
				board[x][y].setCellValue("M");
				minesPlaced++;
			}
		}
	}

	public String toString() {
		String boardString = "";
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				boardString += board[i][j].toString() + " ";
			}
			boardString += "\n";
		}
		return boardString;
	}
}
