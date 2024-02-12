package edu.unca.csci202;

/**
 * Provides a cell that has a value and visibility indicator.
 * 
 * @author Caleb Knapp
 */
public class Cell {
	private String cellValue;
	private boolean visible;

	/**
	 * A new Cell starts as blank and hidden.
	 */
	public Cell() {
		// Default value is nothing and not flipped
		cellValue = "-";
		visible = false;
	}

	/**
	 * Changes a hidden spot to a visible one and calculates the Cell's value.
	 * 
	 * @param board A 2d array of Cell objects that contains the Cell.
	 * @param row   int 1 to 8 for the row of the Cell.
	 * @param col   int 1 to 8 for the column of the Cell.
	 */
	public void flip(Cell[][] board, int row, int col) {
		// Don't need to count mines if flipping a mine
		if (this.getCellValue().equals("M")) {
			visible = true;
			return;
		}
		int mineCount = 0;
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				// Check to make sure the space being checked is in the board
				if (row + i > board.length - 1 || row + i < 0 || col + j > board.length - 1 || col + j < 0) {
				} else if (board[row + i][col + j].getCellValue().equals("M")) {
					// If cell is a mine, add 1 to mine count
					mineCount++;
				}
			}
		}
		// Setting cell value to number of surrounding mines
		cellValue = "" + mineCount;
		visible = true;
	}

	/**
	 * Variable toString based on the boolean input.
	 * 
	 * @param peak A boolean value to override a cell being hidden.
	 * @return Returns the value of the cell if it is visible or if peak is true.
	 */
	public String toString(boolean peak) {
		// If player is peaking or the cell has been flipped, print value, otherwise
		// print "- "
		if (peak || visible) {
			return "" + cellValue + " ";
		} else {
			return "- ";

		}
	}

	/**
	 * Gets the value of the cell regardless of it being visible or not.
	 * 
	 * @return String of length 1 being "M" or "-"
	 */
	public String getCellValue() {
		return cellValue;
	}

	/**
	 * Sets the cell value to the input character.
	 * 
	 * @param cellValue Should be a single character
	 */
	public void setCellValue(String cellValue) {
		this.cellValue = cellValue;
	}

	/**
	 * Checks if cell is visible.
	 * 
	 * @return returns a boolean
	 */
	public boolean isVisible() {
		return visible;
	}

	/**
	 * Changes visibility.
	 * 
	 * @param visible boolean to set visibility.
	 */
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

}
