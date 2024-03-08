package edu.unca.csci202;

/**
 * Main class of this grocery store simulation.
 * 
 * @author Caleb Knapp
 */
public class StoreDriver {
	/**
	 * Makes a grocery store then runs four different simulations and prints the
	 * data from each one.
	 * 
	 * @param args Not used in this project.
	 */
	public static void main(String args[]) {
		GroceryStore g1 = new GroceryStore(5);
		// Provided examples
		g1.run(1000, 0.1, 1, 50);
		g1.printData();
		g1.run(1000, 0.1, 2, 50);
		g1.printData();

		GroceryStore g2 = new GroceryStore(10);
		// Personal Examples
		g2.run(1500, .02, 2, 45);
		g2.printData();
		// this is walmart when I want to buy 1 soda
		g2.run(2000, .4, 10, 93);
		g2.printData();
	}
}
