package edu.unca.csci202;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Class that allows for simulating a grocery store.
 * 
 * @author Caleb Knapp
 */
public class GroceryStore {
	/** An arraylist of the queues of customers. */
	private ArrayList<Queue<Customer>> queues;
	/** The number of queues the grocery store has. */
	private int numQueues;
	/** A unit of time that is the basis for most events. */
	private int timeSteps;
	/** How many time steps it takes to process an item. */
	private int processTime;
	/** The maximum number of items a customer can have. */
	private int maxItems;
	/** The total number of customers that were fully processed. */
	private int servedCustomers;
	/** An array that keeps track of the maximum length of each line. */
	private int maxLength[];
	/**
	 * The percent chance as a decimal of a customer joining a queue in a given time
	 * step.
	 */
	private double arrivalProb;
	/**
	 * A random Object to drive random occurences like customers joining a queue.
	 */
	private Random rand;

	/**
	 * Constructor that makes an int array and arraylist of the input size.
	 * 
	 * @param numQueues the number of lines the grocery store should have.
	 */
	public GroceryStore(int numQueues) {
		this.numQueues = numQueues;
		queues = new ArrayList<Queue<Customer>>();
		maxLength = new int[numQueues];
	}

	/**
	 * Runs a simulation of a grocery store given the settings when called.
	 * 
	 * @param timeSteps   The length of the simulations runtime.
	 * @param arrivalProb How likely a customer is to join a line on a given time
	 *                    step.
	 * @param processTime How many time steps it takes for a cashier to handle one
	 *                    item.
	 * @param maxItems    The maximum number of items that a customer can have.
	 */
	public void run(int timeSteps, double arrivalProb, int processTime, int maxItems) {
		queues.clear();
		for (int i = 0; i < this.numQueues; i++) {
			queues.add(new ArrayDeque<Customer>());
		}

		// Setting up instance variables for later use.
		this.timeSteps = timeSteps;
		this.arrivalProb = arrivalProb;
		this.processTime = processTime;
		this.maxItems = maxItems;
		rand = new Random();
		// looping through time steps
		for (int i = timeSteps; i > 0; i--) {
			calcTimeStep();
		}

	}

	/**
	 * Loops through all queues and adds customers and processes items.
	 */
	public void calcTimeStep() {
		double arrival = rand.nextDouble();
		// Adding customer to queue
		if (arrival <= arrivalProb) {
			int i = getShortest();
			queues.get(i).add(new Customer(rand.nextInt(0, maxItems) + 1, processTime));
			if (queues.get(i).size() > maxLength[i]) {
				maxLength[i] = queues.get(i).size();
			}
		}
		// looping a time step for each queue
		for (int i = 0; i < numQueues; i++) {
			if (queues.get(i).size() != 0) {
				// setting up a reference to simplify later code
				Customer person = queues.get(i).element();
				// decrease time left for customer
				person.decreaseTime();
				// time left shouldn't get below 0 but adding it to the test just in case
				if (person.getTimeLeft() <= 0) {
					queues.get(i).remove();
					servedCustomers++;
				}
			}

		}

	}

	/**
	 * Returns the index of the shortest line.
	 * 
	 * @return shortest queue index.
	 */
	private int getShortest() {
		int minLength = Integer.MAX_VALUE;
		int index = 0;
		for (int i = 0; i < numQueues; i++) {
			if (queues.get(i).size() < minLength) {
				index = i;
				minLength = queues.get(i).size();
			}
		}
		return index;
	}

	/**
	 * Prints helpful information about a runtime including the maximum length of
	 * each queue, the total number of customers served and the number of people
	 * left in a given queue.
	 */
	public void printData() {
		System.out.println("Number of timesteps: " + timeSteps);
		System.out.println("Number of lines: " + queues.size());
		System.out.println("Probability of customer arriving: " + arrivalProb);
		System.out.println("Time per item: " + processTime);
		System.out.println("Max number of items: " + maxItems);
		for (int i = 0; i < numQueues; i++) {
			System.out.println("Maximum length of line " + i + " is: " + maxLength[i]);
			System.out.println("Customers left in line " + i + " is: " + queues.get(i).size());
		}
		System.out.println("Total number of customers served is: " + servedCustomers + " \n");
	}

}