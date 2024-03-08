package edu.unca.csci202;

/**
 * The customer class makes an object that has a certain number of items and the
 * time left to process the customer.
 * 
 * @author Caleb Knapp
 */
public class Customer {
	/** The number of items a customer has. */
	private int groceryItems;
	/** The number of time steps left to process a customer. */
	private int timeLeft;

	/**
	 * The constructor takes the number of items and the time to set the instance
	 * variables.
	 * 
	 * @param items       The number of things the customer needs processed.
	 * @param timePerItem The number of time steps it needs to process one item.
	 */
	public Customer(int items, int timePerItem) {
		this.groceryItems = items;
		this.timeLeft = items * timePerItem;
	}

	/**
	 * Decreases the customer's time left by one time step.
	 */
	public void decreaseTime() {
		this.timeLeft -= 1;
	}

	/**
	 * Returns the number of items the customer has.
	 * 
	 * @return The number of items the customer has.
	 */
	public int getGroceryItems() {
		return groceryItems;
	}

	/**
	 * Returns the amount of time left to process the customer.
	 * 
	 * @return The number of time steps left for the customer to be processed.
	 */
	public int getTimeLeft() {
		return timeLeft;
	}

}
