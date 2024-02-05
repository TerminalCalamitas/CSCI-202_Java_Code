package file_io_demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		int kevinTotal=0;
		int beckyTotal=0;
		Scanner scan = new Scanner(new File("C:\\Users\\NH008s\\Desktop\\golf_scores.txt"));
		scan.nextLine();//throw away header line
		while (scan.hasNext()) {
			String line = scan.nextLine();
			System.out.println(line);
			Scanner words = new Scanner(line);
//			while (words.hasNext()) {
//				System.out.println(words.nextInt());
//			}
			words.nextInt(); //throw away hole number
			words.nextInt(); //throw away par
			int kevinScore = words.nextInt();
			int beckyScore = words.nextInt();

			System.out.println(kevinScore);
			kevinTotal+=kevinScore;
			beckyTotal+=beckyScore;
		}
		
		System.out.println("Kevin's total: "+kevinTotal);
		System.out.println("Becky total: "+beckyTotal);
			
	}

}
