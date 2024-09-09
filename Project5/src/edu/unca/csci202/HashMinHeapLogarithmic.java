package edu.unca.csci202;

import java.util.HashMap;

/**
 * A min heap with the ability to update elements in the heap. The effect of
 * ties is ignored. Implemented using an array as a binary tree. Size must be
 * known at construction. All N=size elements must be "inserted" prior to use of
 * getMin and update
 * 
 * @author ksanft
 *
 * @param <T> T must implement Comparable<T> (verified in insert)
 */
public class HashMinHeapLogarithmic<T> implements HashMinHeapADT<T> {
    // the heap data
    protected T[] data;
    // a map that says where in the heap a particular element T is stored
    protected HashMap<T, Integer> map;
    protected int elementCount;
    protected boolean initialized;

    /**
     * Constructor sets up the underlying array data structure but does not fill it
     * with elements (use insert to fill the structure)
     * 
     * @param size the number of elements that will be in the heap
     */
    public HashMinHeapLogarithmic(int size) {
	data = (T[]) (new Object[size]);
	map = new HashMap<T, Integer>();
	elementCount = 0;
	initialized = false;
    }

    /**
     * Used to insert elements into the heap. IN THIS IMPLEMENTATION, AFTER
     * CONSTRUCTION, THIS METHOD MUST BE CALLED data.length TIMES TO FILL THE HEAP,
     * AFTER WHICH INITIALIZED IS SET TO TRUE. The intent is that this is used to
     * fill the heap before calling the other methods (e.g. getMin, update)
     * 
     * To reiterate: once initialized is true, this should never be called again.
     * 
     * @param element the element to be inserted
     */
    public void insert(T element) {
	if (!(element instanceof Comparable))
	    throw new NonComparableElementException("HashMinHeap");

	if (elementCount == data.length) {
	    throw new IndexOutOfBoundsException("HashMinHeap is full");
	}
	data[elementCount] = element;
	map.put(element, elementCount);
	elementCount++;
	if (elementCount == data.length) {
	    initialized = true;
	}
    }

    public T getMin() {
	if (elementCount != data.length || !initialized) {
	    throw new IllegalStateException("Method should not be called until heap is full.");
	}
	// uncomment next line when binary heap is implemented
	return data[0];
	// comment-out below when binary heap is implemented
	// find the smallest element using linear search
//	int indexOfMin = 0;
//	Comparable<T> comparableElement = (Comparable<T>) data[indexOfMin];
//
//	for (int i = 1; i < data.length; i++) {
//	    if (comparableElement.compareTo(data[i]) > 0) {
//		indexOfMin = i;
//		comparableElement = (Comparable<T>) data[indexOfMin];
//	    }
//	}
//	return data[indexOfMin];
    }

    public void update(T element) {
	if (elementCount != data.length || !initialized) {
	    throw new IllegalStateException("Method should not be called until heap is full.");
	}
	int index = map.get(element);
	bubbleUp(index);

	bubbleDown(index);

    }

    /**
     * Moves an object as far up the heap as is needed
     * 
     * @param index index of the object to bubble up
     */
    private void bubbleUp(int index) {
	// get parent index
	int parentIndex = (index - 1) / 2;
	// backup node value
	T node = data[index];
	// loop up as far as possible
	while (index >= 0 && (((Comparable<T>) node).compareTo(data[parentIndex]) < 0)) {
	    // Get rid of old mappings
	    map.remove(data[index]);
	    map.remove(data[parentIndex]);

	    // swap with parent
	    data[index] = data[parentIndex];
	    data[parentIndex] = node;

	    // New mappings
	    map.put(data[index], index);
	    map.put(data[parentIndex], parentIndex);

	    // update indexes
	    index = parentIndex;
	    parentIndex = (index - 1) / 2;

	}
    }

    /**
     * Moves an object as far down the heap as is needed
     * 
     * @param index index of the object to bubble down
     */
    private void bubbleDown(int index) {
	// Make backup of node
	T node = data[index];
	int moveToIndex;

	while (index < data.length / 2) {
	    int leftChild = index * 2 + 1;
	    int rightChild = index * 2 + 2;

	    // if right child exists and is less than the left child
	    if (rightChild < data.length && (((Comparable<T>) data[leftChild]).compareTo(data[rightChild]) > 0)) {
		moveToIndex = rightChild;
	    } else {
		moveToIndex = leftChild;
	    }

	    // End early if in place
	    if (((Comparable<T>) node).compareTo(data[moveToIndex]) <= 0) {
		break;
	    }

	    // Get rid of old mappings
	    map.remove(data[index]);
	    map.remove(data[moveToIndex]);

	    // swap with parent
	    data[index] = data[moveToIndex];
	    data[moveToIndex] = node;

	    // New mappings
	    map.put(data[index], index);
	    map.put(data[moveToIndex], moveToIndex);

	    // update indexes
	    index = moveToIndex;

	    // Update positions
	    data[index] = data[moveToIndex];
	    index = moveToIndex;
	}
    }

    @Override
    public boolean isInitialized() {
	return initialized;
    }

    @Override
    public int getElementCount() {
	return elementCount;
    }
}
