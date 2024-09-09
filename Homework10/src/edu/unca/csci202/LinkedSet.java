package edu.unca.csci202;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class LinkedSet<T> implements Set<T> {

    @Override
    public boolean add(T arg0) {

	return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> arg0) {
	return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean contains(Object arg0) {
	return false;
    }

    @Override
    public boolean containsAll(Collection<?> arg0) {
	return false;
    }

    @Override
    public boolean isEmpty() {
	return false;
    }

    @Override
    public Iterator<T> iterator() {
	return null;
    }

    @Override
    public boolean remove(Object arg0) {
	return false;
    }

    @Override
    public boolean removeAll(Collection<?> arg0) {
	return false;
    }

    @Override
    public boolean retainAll(Collection<?> arg0) {
	return false;
    }

    @Override
    public int size() {
	return 0;
    }

    @Override
    public Object[] toArray() {
	return null;
    }

    @Override
    public <T> T[] toArray(T[] arg0) {
	return null;
    }

}
