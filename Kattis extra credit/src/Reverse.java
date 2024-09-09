import java.util.Scanner;

public class Reverse {
    public static void main(String args[]) {
	Scanner input = new Scanner(System.in);
	int listSize = input.nextInt();
	int[] numList = new int[listSize];
	for (int i = 0; i < listSize; i++) {
	    numList[i] = input.nextInt();
	}
	for (int i = listSize; i > 0; i--) {
	    System.out.println(numList[i - 1]);
	}
    }
}
