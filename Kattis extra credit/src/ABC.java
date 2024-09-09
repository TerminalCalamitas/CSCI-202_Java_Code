import java.util.Arrays;
import java.util.Scanner;

public class ABC {

    public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	int[] nums = new int[3];
	for (int i = 0; i < 3; i++) {
	    nums[i] = input.nextInt();
	}
	Arrays.sort(nums);
	input.nextLine();

	String order = input.nextLine();
	for (int i = 0; i < 3; i++) {
	    if (order.charAt(i) == 'A') {
		System.out.print(nums[0]);
	    } else if (order.charAt(i) == 'B') {
		System.out.print(nums[1]);
	    } else if (order.charAt(i) == 'C') {
		System.out.print(nums[2]);
	    }

	    if (i != 2) {
		System.out.print(" ");
	    }
	}
    }

}
