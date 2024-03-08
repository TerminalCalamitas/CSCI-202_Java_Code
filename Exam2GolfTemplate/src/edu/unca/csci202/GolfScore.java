package edu.unca.csci202;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GolfScore implements Comparable<GolfScore> {

	// DO NOT MODIFY INSTANCE VARIABLES
	private LocalDate date;
	private int par;
	private int score;

	// DO NOT MODIFY CONSTRUCTOR
	public GolfScore(LocalDate date, int par, int score) {
		this.date = date;
		this.par = par;
		this.score = score;
	}

	public LocalDate getDate() {
		return date;
	}

	// IMPLEMENT THIS METHOD
	public int getDifferential() {
		return score - par;
	}

	// COMPLETE THIS METHOD
	public String toString() {

		// date formatting code provided, format date as usual month/day/year (m/d/yyyy)
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/YYYY");

		int diff = getDifferential();
		String strDiff;
		if (diff > 0) {
			strDiff = "+" + diff;
		} else {
			strDiff = "" + diff;
		}
		if (diff != 0) {
			return formatter.format(date) + " " + score + " (" + strDiff + ")";
		} else {
			return formatter.format(date) + " " + score + " (E)";
		}
	}

	// IMPLEMENT THIS METHOD
	public boolean equals(GolfScore other) {
		return this.getDifferential() == other.getDifferential();
	}

	// IMPLEMENT THIS METHOD
	public int compareTo(GolfScore other) {
		if (this.getDifferential() < other.getDifferential()) {
			return -1;
		} else if (this.getDifferential() > other.getDifferential()) {
			return 1;
		}
		return 0;

	}

}
