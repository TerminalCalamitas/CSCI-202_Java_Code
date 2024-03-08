import java.util.Scanner;

public class R2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String line1[] = scan.nextLine().split(" ");
		int problems = Integer.parseInt(line1[1]);

		System.out.print((Integer.parseInt(line1[1]) * 2) - Integer.parseInt(line1[0]));
	}

}
