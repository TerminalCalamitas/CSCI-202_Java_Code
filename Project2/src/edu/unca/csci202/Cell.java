package edu.unca.csci202;

/**
 * Provides a cell that has a value and visibility indicator.
 * 
 * @author Caleb Knapp
 */
public class Cell {
	/** A string that is the cell's value, either a number or M. */
	private String cellValue;
	/** Boolean on if the cell's value should be printed by default. */
	private boolean visible;
	private int row;
	private int col;

	/**
	 * A new Cell starts as next to zero mines and hidden.
	 * 
	 * @param row Integer 0 to 7 of the Cell row.
	 * @param col Integer 0 to 7 of the Cell column.
	 */
	public Cell(int row, int col) {
		this.row = row;
		this.col = col;

		cellValue = "0";
		visible = false;
	}

	/**
	 * Changes a hidden spot to a visible one.
	 */
	public void flip() {
		visible = true;
	}

	/**
	 * Variable toString based on the boolean input.
	 * 
	 * @param peak A boolean value to override a cell being hidden.
	 * @return The value of the cell if it is visible or if peak is true.
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
	 * Gets the Cell's Column.
	 * 
	 * @return An integer between 0 and 7.
	 */
	public int getRow() {
		return row;
	}

	/**
	 * Gets the Cell's Column.
	 * 
	 * @return An integer between 0 and 7.
	 */
	public int getCol() {
		return col;
	}

	/**
	 * Checks if cell is visible.
	 * 
	 * @return Boolean of the Cell's visibility
	 */
	public boolean isVisible() {
		return visible;
	}

	/**
	 * Changes visibility.
	 * 
	 * @param visible Boolean to set visibility to.
	 */
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

}
