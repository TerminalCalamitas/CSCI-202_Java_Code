package edu.unca.csci202;

/**
 * Simple node class for a doubly-linked list.
 */
public class DNode<E> {
	private E data;
	private DNode<E> previous;
	private DNode<E> next;

	/**
	 * Constructor that initializes all instance variables.
	 */
	public DNode(E data, DNode<E> previous, DNode<E> next) {
		this.data = data;
		this.previous = previous;
		this.next = next;
	}

	/**
	 * Constructor that initializes data only.
	 */
	public DNode(E data) {
		this(data, null, null);
	}

	/**
	 * Constructor, nulls all instance variables.
	 */
	public DNode() {
		this(null, null, null);
	}

	/**
	 * Setter for next.
	 * 
	 * @param node the new next Node.
	 */
	public void setNext(DNode<E> node) {
		next = node;
	}

	/**
	 * Getter for next.
	 * 
	 * @return the next reference.
	 */
	public DNode<E> getNext() {
		return next;
	}

	/**
	 * Setter for previous.
	 * 
	 * @param node the new previous Node.
	 */
	public void setPrevious(DNode<E> node) {
		previous = node;
	}

	/**
	 * Getter for previous.
	 * 
	 * @return the previous reference.
	 */
	public DNode<E> getPrevious() {
		return previous;
	}

	/**
	 * Getter for data.
	 * 
	 * @return the Node's data element.
	 */
	public E getData() {
		return data;
	}
}
