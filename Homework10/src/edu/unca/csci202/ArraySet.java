package edu.unca.csci202;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

//add, contains, remove, and size.
public class ArraySet<T> implements Set<T> {
    private T[] elements;
    private int size;

    public ArraySet() {
	elements = (T[]) new Object[10];
	size = 0;
    }

    @Override
    public boolean add(T arg0) {
	if (contains(arg0)) {
	    return false;
	}
	if (size == elements.length) {
	    growArray();
	}
	elements[size] = arg0;
	size++;
	return true;
    }

    @Override
    public boolean contains(Object arg0) {
	for (int i = 0; i < size; i++) {
	    if (elements[i].equals(arg0)) {
		return true;
	    }
	}
	return false;
    }

    @Override
    public boolean remove(Object arg0) {
	for (int i = 0; i < size; i++) {
	    if (elements[i].equals(arg0)) {
		elements[i] = elements[size - 1];
		elements[size - 1] = null;
		size--;
		return true;
	    }
	}
	return false;
    }

    @Override
    public int size() {
	return size;
    }

    private void growArray() {
	T[] temp = (T[]) new Object[elements.length * 2];
	for (int i = 0; i < elements.length; i++) {
	    temp[i] = elements[i];
	}
	elements = temp;
    }

    @Override
    public boolean addAll(Collection<? extends T> arg0) {
	// Not Implemented
	return false;
    }

    @Override
    public void clear() {
	// Not Implemented

    }

    @Override
    public boolean containsAll(Collection<?> arg0) {
	// Not Implemented
	return false;
    }

    @Override
    public boolean isEmpty() {
	// Not Implemented
	return false;
    }

    @Override
    public Iterator<T> iterator() {
	// Not Implemented
	return null;
    }

    @Override
    public boolean removeAll(Collection<?> arg0) {
	// Not Implemented
	return false;
    }

    @Override
    public boolean retainAll(Collection<?> arg0) {
	// Not Implemented
	return false;
    }

    @Override
    public Object[] toArray() {
	// Not Implemented
	return null;
    }

    @Override
    public <T> T[] toArray(T[] arg0) {
	// Not Implemented
	return null;
    }

}
