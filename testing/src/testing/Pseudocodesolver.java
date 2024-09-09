package testing;

public class Pseudocodesolver {

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	int beep = 0;
	for (int i = 0; i < 6; i++) {
	    beep++;
	    for (int j = 0; j < 4; j++) {
		beep++;
		for (int k = 0; i < 3; i++) {
		    for (int l = 0; l < 5; l++) {
			beep++;
		    }
		    for (int m = 0; m < 4; m++) {
			beep++;
		    }
		}
	    }
	}

	System.out.println(beep);
    }

}
