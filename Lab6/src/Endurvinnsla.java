import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Endurvinnsla {

	public static void main(String[] args) throws IOException {
//		Scanner input = new Scanner(System.in);
//		input.nextLine();
//		double allowedPlastic = Double.parseDouble(input.nextLine());
//		int numItems = Integer.parseInt(input.nextLine());
//		int numPlast = 0;
//		for (int i = 0; i < numItems; i++) {
//			if (input.nextLine().equals("plast")) {
//				numPlast++;
//			}
//		}
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		// ignore city name (it's not needed)
		bufferedReader.readLine();

		double allowedPlastic = Double.parseDouble(bufferedReader.readLine());
		int numItems = Integer.parseInt(bufferedReader.readLine());

		int numPlast = 0;
		for (int i = 0; i < numItems; i++) {
			if (bufferedReader.readLine().equals("plast")) {
				numPlast++;
			}
		}

		double dubItems = numItems;
		double dubPlast = numPlast;
		if ((1 - (dubPlast / dubItems)) <= allowedPlastic) {
			System.out.println("Jebb");
		} else {
			System.out.println("Neibb");
		}
		bufferedReader.close();
	}

}
