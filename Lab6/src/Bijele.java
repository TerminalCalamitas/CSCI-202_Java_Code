import java.util.Scanner;

public class Bijele {
	public static void main(String args[]) {

		Scanner input = new Scanner(System.in);
		String line = input.nextLine();
		String set[] = line.split(" ");

		String rtrnStr = "" + (1 - Integer.parseInt(set[0])) + " " + (1 - Integer.parseInt(set[1])) + " " + (2 - Integer.parseInt(set[2])) + " " + (2 - Integer.parseInt(set[3])) + " " + (2 - Integer.parseInt(set[4])) + " " + (8 - Integer.parseInt(set[5]));
		System.out.println(rtrnStr);
	}
}
