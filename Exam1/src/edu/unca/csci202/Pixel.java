package edu.unca.csci202;

public class Pixel {
	int red;
	int blue;
	int green;

	public Pixel(int red, int green, int blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
	}

	public String toString() {
		return "" + red + " " + green + " " + blue;
	}

}