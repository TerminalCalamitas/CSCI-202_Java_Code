package edu.unca.csci202;

/**
 * @author Caleb Knapp
 */
public class Cell {
	private String cellValue;
	private boolean visible;

	/**
	 * 
	 */
	public Cell() {
		// Default value is nothing and not flipped
		cellValue = "-";
		visible = false;
	}

	/**
	 * 
	 * @param board
	 * @param row
	 * @param col
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
	 * 
	 * @param peak
	 * @return
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
	 * 
	 * @return
	 */
	public String getCellValue() {
		return cellValue;
	}

	/**
	 * 
	 * @param cellValue
	 */
	public void setCellValue(String cellValue) {
		this.cellValue = cellValue;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isVisible() {
		return visible;
	}

	/**
	 * 
	 * @param visible
	 */
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

}
