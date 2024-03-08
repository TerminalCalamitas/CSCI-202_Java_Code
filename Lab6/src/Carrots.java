import java.util.Scanner;

public class Carrots {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String line1[] = scan.nextLine().split(" ");
		int problems = Integer.parseInt(line1[1]);

		System.out.print(problems);
	}

}
