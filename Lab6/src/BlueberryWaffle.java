import java.util.Scanner;

public class BlueberryWaffle {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double timeToTurn = Integer.parseInt(input.next());
		double timeTurned = Integer.parseInt(input.next());
		double dubTurns = (timeTurned / timeToTurn);
		input.close();
		int numTurns = (int) Math.round(dubTurns);
		if (numTurns % 2 == 0) {
			System.out.println("up");
		} else {
			System.out.println("down");
		}

	}

}
