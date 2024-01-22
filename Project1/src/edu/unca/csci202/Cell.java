package edu.unca.csci202;

public class Cell {
	private String cellValue;
	private boolean visible;

	public Cell() {
		cellValue = "-";
		visible = true;
	}

	public void flip() {
		for
			for
	}

	public String toString() {
		if (visible) {
			return "" + cellValue + " ";
		} else {
			return "- ";
		}
	}

	public String getCellValue() {
		return cellValue;
	}

	public void setCellValue(String cellValue) {
		this.cellValue = cellValue;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

}
