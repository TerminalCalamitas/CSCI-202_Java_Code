import java.util.Scanner;

public class HeadGuard {

	public static void main(String[] args) {
		Scanner lines = new Scanner(System.in);
		String formattedLine = "";
		while (lines.hasNextLine()) {
			String line = lines.nextLine();

			int count = 1;
			char currChar = line.charAt(0);

			for (int i = 1; i < line.length(); i++) {
				char nextChar = line.charAt(i);
				if (nextChar == currChar) {
					count++;
				} else {
					formattedLine += count + "" + currChar;
					currChar = nextChar;
					count = 1;
				}
			}
			System.out.println(formattedLine);
			formattedLine = "";
		}
		System.out.println("IIIISISISISISISISHG");
		lines.close();
	}

}
