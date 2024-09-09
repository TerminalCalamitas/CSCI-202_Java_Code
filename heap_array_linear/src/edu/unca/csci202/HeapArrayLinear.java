package edu.unca.csci202;

/**
 * Implement the HeapADT using an linear array (not a binary tree array
 * implementation)
 * 
 * @author ksanft
 *
 * @param <T>
 */
public class HeapArrayLinear<T> implements HeapADT<T> {

    // instance variables
    protected T[] data; // make initial capacity=4
    // add more instance variables here if necessary
    protected int size;

    // construct empty heap
    public HeapArrayLinear() {
	size = 0;
	data = (T[]) new Object[4];

    }

    @Override
    public void addElement(T obj) {
	if (!(obj instanceof Comparable))
	    throw new IllegalArgumentException();

	// implement, if you need to increase capacity, TRIPLE the current capacity
	if (size == data.length) {
	    T[] temp = (T[]) new Object[data.length * 3];
	    for (int i = 0; i < data.length; i++) {
		temp[i] = data[i];
	    }
	    data = temp;

	}

	// Add element
	data[size] = obj;
	// Increase size
	size++;
    }

    @Override
    public T removeMin() {
	int min = 0;
	for (int i = 0; i < size; i++) {
	    if (((Comparable) data[i]).compareTo(data[min]) < 0) {
		min = i;
	    }
	}

	T[] temp = (T[]) new Object[data.length];
	for (int i = 0; i < min; i++) {
	    temp[i] = data[i];
	}
	for (int i = min + 1; i < size; i++) {
	    temp[i - 1] = data[i];
	}
	T removed = data[min];
	data = temp;
	size--;

	return removed;
    }

    @Override
    public T findMin() {
	T min = data[0];
	for (int i = 0; i < size; i++) {
	    if (((Comparable) data[i]).compareTo(min) < 0) {
		min = data[i];
	    }
	}

	return min;
    }

    @Override
    public int size() {
	return size;
    }
}
