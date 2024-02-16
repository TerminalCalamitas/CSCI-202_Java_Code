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

	/**
	 * A new Cell starts as blank and hidden.
	 */
	public Cell() {
		// Default value is nothing and not flipped
		cellValue = "-";
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
