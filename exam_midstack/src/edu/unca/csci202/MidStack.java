package edu.unca.csci202;

public class MidStack<T> implements MidStackADT<T> {
    protected T[] array;
    protected int count;

    public MidStack() {
	count = 0;
	array = (T[]) new Object[10];
    }

    /**
     * The number of elements contained in the MidStack
     * 
     * @return number of elements in the structure
     */
    public int size() {
	return count;
    }

    /**
     * The normal push stack operation that inserts at the "top" of the stack
     * 
     * @param element the element to be inserted
     */
    public void pushTop(T element) {
	array[count] = element;
	count++;
    }

    /**
     * The normal pop stack operation that removes the element from the "top" of the
     * stack
     * 
     * @return the element that was removed from the stack
     */
    public T popTop() {
	count--;
	T removed = array[count];
	array[count] = null;
	return removed;
    }

    /**
     * Insert an element into the middle of the midstack The middle is defined as
     * index size()/2 where indexes start at 0 (the element at the bottom of the
     * stack is index 0 and the element at the top of the stack is index size-1).
     * 
     * The element that is at the middle prior to the call and all elements above it
     * are moved "up" (their index position is increased by 1).
     * 
     * @param element the element to be inserted
     */
    public void pushMid(T element) {
	int start = (count + 1) / 2;

	for (int i = count; i > start; i--) {
	    array[i] = array[i - 1];
	}
	array[start] = element;
	count++;

    }

    /**
     * Remove the element at the middle of the midstack Elements above the middle
     * are moved "down" (and size decreases by 1).
     * 
     * @return the element that was removed from the stack
     */
    public T popMid() {
	int removeIndex = count / 2;
	T removed = array[removeIndex];

	for (int i = removeIndex; i < count; i++) {
	    array[i] = array[i + 1];
	}

	count--;
	return removed;
    }

    public String toString() {
	String printStr = "[";
	int middle = count / 2;
	for (int i = 0; i < count; i++) {
	    printStr += array[i];
	    if (i == middle) {
		printStr += "*";
	    }
	    if (i + 1 != count) {
		printStr += ", ";
	    }
	}

	printStr += "]";
	return printStr;
    }
}
