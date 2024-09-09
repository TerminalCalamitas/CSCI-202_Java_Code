import java.util.Scanner;

public class Skammstofun {
    public static void main(String args[]) {
	Scanner input = new Scanner(System.in);
	int numWords = Integer.parseInt(input.nextLine());
	String abbrev = "";
	for (int i = 0; i < numWords; i++) {
	    char firstChar = input.next().charAt(0);
	    if (Character.isUpperCase(firstChar)) {
		abbrev += firstChar;
	    }
	}
	System.out.println(abbrev);
    }
}
