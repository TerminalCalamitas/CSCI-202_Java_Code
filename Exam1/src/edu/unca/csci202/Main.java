package edu.unca.csci202;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		PPMImage image = null;
		Scanner input = new Scanner(System.in);
		boolean validFile = false;
		String fileName = null;

		// loop to make sure file is valid
		while (!validFile) {
			System.out.print("Enter PPM filename: ");
			fileName = input.nextLine();

			try {
				image = new PPMImage(fileName);
			} catch (FileNotFoundException e) {
				System.out.println("File not found with name: " + fileName);
			} catch (InputMismatchException e) {
				System.out.println("" + fileName + " is not in the ppm format.");
			} finally {
				if (image != null) {
					validFile = true;
				}
			}
		}

		// Logic for rotating
		System.out.print("Would you like to rotate the image (y/n): ");
		String answer = input.nextLine();
		while (!answer.equals("n")) {
			if (answer.equals("y")) {
				image.rotate();
			} else {
				System.out.print("Invalid input. ");
			}
			System.out.print("Would you like to rotate the image (y/n): ");
			answer = input.nextLine();
		}

		// Only executes when player answers "n"
		image.write(fileName);

	}

}
