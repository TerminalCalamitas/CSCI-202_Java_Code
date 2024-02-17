package edu.unca.csci202;

/**
 * A class that runs the game.
 * 
 * @author Caleb Knapp
 */
public class Minesweeper {
	/**
	 * Initializes and runs the game.
	 * 
	 * @param args Not used in this program.
	 */
	public static void main(String[] args) {
		Gameboard game = new Gameboard();
		game.run();
	}

}
