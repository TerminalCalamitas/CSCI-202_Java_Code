package edu.unca.csci202;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PPMImage {
	Pixel[][] image;
	Scanner scan;
	int[] dimensions;

	public PPMImage(String fileName) throws FileNotFoundException, InputMismatchException {
		dimensions = new int[2];
		File file = new File(fileName);
		scan = new Scanner(file);
		prepareFile(file, scan);

	}

	public void write(String fileName) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter(fileName);
		writer.println("P3\n" + image.length + " " + image[1].length + "\n255");
		writer.println(this.toString());
		writer.close();
		System.out.println("FIle written, ending program");
	}

	public void rotate() {
		int rows = dimensions[1];
		int columns = dimensions[0];
		Pixel[][] tempPicture = new Pixel[rows][columns];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				tempPicture[i][j] = image[i][j];
			}
		}

		image = new Pixel[columns][rows];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				image[columns - 1 - j][i] = tempPicture[i][j];
			}
		}

	}

	private void prepareFile(File file, Scanner scan) {
		if (!scan.nextLine().equals("P3")) {
			throw new InputMismatchException();
		}

		int lineRule = 0;
		while (scan.hasNextLine()) {
			// skip past comments
			while (!scan.hasNextInt() && scan.hasNextLine()) {
				scan.nextLine();
			}
			// Ends loop if there are comments at the end of a file
			if (!scan.hasNextLine()) {
				break;
			}

			if (lineRule == 0) {
				// get 2 numbers for dimensions
				Scanner lineCheck = new Scanner(scan.nextLine());
				for (int i = 0; i < 2; i++) {
					if (!lineCheck.hasNextInt()) {
						throw new InputMismatchException();
					}
					dimensions[1 - i] = lineCheck.nextInt();
				}
				// make sure file doesn't have 3 dimensions
				if (lineCheck.hasNext()) {
					throw new InputMismatchException();
				}

				lineRule++;
				image = new Pixel[dimensions[1]][dimensions[0]];

				// Makes sure color space is 255
			} else if (lineRule == 1) {

				if (Integer.parseInt(scan.nextLine()) != 255) {
					throw new InputMismatchException();
				}
				lineRule++;

				// Pixel Logic
			} else {
				int rows = dimensions[1];
				int columns = dimensions[0];
				for (int i = 0; i < columns; i++) {
					for (int j = 0; j < rows; j++) {
						// Gets three next integers for rgb values
						image[j][i] = new Pixel(scan.nextInt(), scan.nextInt(), scan.nextInt());
					}
				}
			}
		}
	}

	public String toString() {
		String board = "";
		int rows = image.length;
		int columns = image[1].length;

		// Loop through and add new lines after each pixel for ease of reading
		for (int i = 0; i < columns; i++) {
			for (int j = 0; j < rows; j++) {
				board += image[j][i] + "\n";
			}
		}

		return board;
	}

}
