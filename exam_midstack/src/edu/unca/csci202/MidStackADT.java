package edu.unca.csci202;

/**
 * The interface for a MidStack
 *
 */
public interface MidStackADT<T> {

	/**
	 * The number of elements contained in the MidStack
	 * @return number of elements in the structure
	 */
	public int size();
	
	/**
	 * The normal push stack operation that inserts at the "top" of the stack
	 * @param element the element to be inserted
	 */
	public void pushTop(T element);
	
	/**
	 * The normal pop stack operation that removes the element from the "top" of the stack
	 * 
	 * @return the element that was removed from the stack
	 */
	public T popTop();
	
	/**
	 * Insert an element into the middle of the midstack
	 * The middle is defined as index size()/2 where indexes
	 * start at 0 (the element at the bottom of the stack is index 0 and
	 * the element at the top of the stack is index size-1).
	 * 
	 * The element that is at the middle prior to the call and all elements above it
	 * are moved "up" (their index position is increased by 1). 
	 * 
	 * @param element the element to be inserted
	 */
	public void pushMid(T element);
	
	/**
	 * Remove the element at the middle of the midstack
	 * Elements above the middle are moved "down" (and size decreases by 1).
	 * 
	 * @return the element that was removed from the stack
	 */
	public T popMid();

	
}
