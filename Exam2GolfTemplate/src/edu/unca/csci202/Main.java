package edu.unca.csci202;

import java.time.LocalDate;
import java.util.List;

public class Main {

	private static void testGolfScore() {
		System.out.println("running testGolfScore()...");
		// create some golf scores
		GolfScore score1 = new GolfScore(LocalDate.now(), 72, 77);
		System.out.println(score1);// should print today's date 77 (+5);

		GolfScore score2 = new GolfScore(LocalDate.of(2024, 2, 28), 71, 68);
		System.out.println(score2);// should print: 2/28/2024 68 (-3);

		GolfScore score3 = new GolfScore(LocalDate.of(2015, 4, 4), 70, 70);
		System.out.println(score3);// should print: 4/4/2015 70 (E);

		System.out.println("compareTo:");
		if (score2.compareTo(score3) < 0) {
			System.out.println(score2.toString() + " round is 'less than' " + score3.toString());
		} else if (score2.compareTo(score3) > 0) {
			System.out.println(score2.toString() + " round is 'greater than' " + score3.toString());
		} else {
			System.out.print(score2.toString() + " round is '(compareTo) equal to' " + score3.toString());
			if (score2.equals(score3)) {
				System.out.println(", which agrees with .equals.");
			} else {
				System.out.println(", but that disagrees with .equals.");
			}
		}
		System.out.println("finished testGolfScore().\n");

	}

	private static void testGolfIndexInsertScoreAndToString() {
		System.out.println("running testGolfIndexInsertScoreAndToString()...");

		// create some golf scores
		GolfScore score1 = new GolfScore(LocalDate.now(), 72, 77);
		GolfScore score2 = new GolfScore(LocalDate.of(2024, 2, 28), 71, 68);
		GolfScore score3 = new GolfScore(LocalDate.of(2015, 4, 4), 70, 70);

		GolfIndex index = new GolfIndex(20, 2);
		index.insertScore(score3);
		index.insertScore(score2);
		index.insertScore(score1);
		System.out.println("index:");
		System.out.println(index);
		System.out.println("finished testGolfIndexInsertScoreAndToString().\n");
	}

	private static void testLowestM() {
		System.out.println("running testLowestM()...");
		// create some golf scores
		GolfScore score1 = new GolfScore(LocalDate.now(), 72, 77);
		GolfScore score2 = new GolfScore(LocalDate.of(2024, 2, 28), 71, 68);
		GolfScore score3 = new GolfScore(LocalDate.of(2015, 4, 4), 70, 70);

		GolfIndex index = new GolfIndex(20, 2);
		index.insertScore(score3);
		index.insertScore(score2);
		index.insertScore(score1);

		List<GolfScore> lowest = index.getLowestM();
		System.out.println("lowest (since it is a list, it will print in square brackets):");
		System.out.println(lowest);
		System.out.println("finished testLowestM().\n");
	}

	private static void testComputeIndex() {
		System.out.println("running testComputeIndex()...");
		// create some golf scores
		GolfScore score1 = new GolfScore(LocalDate.now(), 72, 77);
		GolfScore score2 = new GolfScore(LocalDate.of(2024, 2, 28), 71, 68);
		GolfScore score3 = new GolfScore(LocalDate.of(2015, 4, 4), 70, 70);

		GolfIndex index = new GolfIndex(20, 2);
		index.insertScore(score3);
		index.insertScore(score2);
		index.insertScore(score1);

		System.out.println(index);

		System.out.println("computeIndex: " + index.computeIndex());
		System.out.println("finished testComputeIndex().\n");
	}

	public static void main(String[] args) {

		testGolfScore();

		testGolfIndexInsertScoreAndToString();

		testLowestM();

		testComputeIndex();

		// largeNlargeMTests();//instructor test code not provided
	}

}
