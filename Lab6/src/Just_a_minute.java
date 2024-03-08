import java.util.Scanner;

public class Just_a_minute {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int observations = Integer.parseInt(scan.nextLine());
		double totalMins = 0;
		double totalSecs = 0;
		for (int i = 0; i < observations; i++) {
			String line = scan.nextLine();
			Scanner intScan = new Scanner(line);
			totalMins += intScan.nextInt();
			totalSecs += intScan.nextInt();
		}
		double slMinute = totalSecs / (totalMins * 60);
		if (slMinute > 1) {
			System.out.println(slMinute);
		} else {
			System.out.println("measurement error");
		}
	}
}
