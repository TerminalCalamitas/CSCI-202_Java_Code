package edu.unca.csci202;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Hash table implemented using an array of LinkedLists, where the LinkedLists
 * are used to implement chaining for collision resolution
 * 
 * @author ksanft
 *
 * @param <K> key type
 * @param <V> value type
 */
public class SimpleHashTable<K, V> implements SimpleHashTableADT<K, V> {

    /**
     * inner class to hold key:value pairs
     * 
     * @param <K> key type
     * @param <V> value type
     */
    private class Pair<K, V> {
	K key;
	V value;

	public Pair(K key, V value) {
	    this.key = key;
	    this.value = value;
	}

	K getKey() {
	    return key;
	}

	V getValue() {
	    return value;
	}

	public String toString() {
	    return key + ":" + value;
	}
    }

    LinkedList<Pair<K, V>>[] bins;
    int size;
    double loadFactorLimit;
    final double DEFAULT_LOAD_FACTOR_LIMIT = 0.75;

    public SimpleHashTable(int numberOfBins) {
	// initialize array and linked lists
	bins = (LinkedList<Pair<K, V>>[]) new LinkedList<?>[numberOfBins];
	for (int i = 0; i < numberOfBins; i++) {
	    bins[i] = new LinkedList<Pair<K, V>>();
	}
	size = 0;
	loadFactorLimit = DEFAULT_LOAD_FACTOR_LIMIT;
    }

    public List<K> getKeys() {
	ArrayList<K> returnList = new ArrayList<K>();
	for (int i = 0; i < bins.length; i++) {
	    for (int j = 0; j < bins[i].size(); j++) {
		returnList.add(bins[i].get(j).getKey());
	    }
	}

	return returnList;
    }

    @Override
    public void put(K key, V value) {
	int binNum = Math.abs(key.hashCode() % bins.length);

	for (int i = 0; i < bins[binNum].size(); i++) {
	    if (bins[binNum].get(i).getKey().equals(key)) {
		bins[binNum].set(i, new Pair(key, value));
		return;
	    }
	}
	bins[binNum].add(new Pair(key, value));
	size++;
	// implement this method
    }

    /**
     * double the length of the underlying array
     */
    protected void increaseCapacity() {
	// do not delete this print statement
	System.out.println("increasing capacity...");

	// implement this method
	int newSize = bins.length * 2;
	LinkedList<Pair<K, V>>[] temp = (LinkedList<Pair<K, V>>[]) new LinkedList<?>[newSize];
	for (int i = 0; i < newSize; i++) {
	    if (i < bins.length) {
		temp[i] = bins[i];
	    } else {
		temp[i] = new LinkedList<Pair<K, V>>();
	    }
	}
	bins = temp;
    }

    @Override
    public V get(K key) {
	// implement this method
	int binNum = Math.abs(key.hashCode() % bins.length);
	for (int i = 0; i < bins[binNum].size(); i++) {
	    if (bins[binNum].get(i).getKey().equals(key)) {
		return bins[binNum].get(i).getValue();
	    }
	}
	return null;
    }

    @Override
    public V remove(K key) {
	int binNum = Math.abs(key.hashCode() % bins.length);
	for (int i = 0; i < bins[binNum].size(); i++) {
	    if (bins[binNum].get(i).getKey().equals(key)) {
		V value = bins[binNum].get(i).getValue();

		bins[binNum].set(i, null);
		size--;
		return value;
	    }
	}
	return null;
    }

    @Override
    public int size() {
	return size;
    }

    @Override
    public void setLoadFactorLimit(double loadFactorLimit) {
	this.loadFactorLimit = loadFactorLimit;
	// uncomment this when increaseCapacity is implemented:
	while (getCurrentLoadFactor() > loadFactorLimit) {
	    increaseCapacity();
	}
    }

    @Override
    public double getLoadFactorLimit() {
	return loadFactorLimit;
    }

    @Override
    public double getCurrentLoadFactor() {
	return (double) size / bins.length;
    }

    public String toString() {
	String out = "{";
	for (int i = 0; i < bins.length; i++) {
	    for (Pair<K, V> pair : bins[i]) {
		out += pair + ", ";
	    }
	}
	out += "}";
	return out;
    }

    public void printTable() {
	for (int i = 0; i < bins.length; i++) {
	    System.out.println(i + ": " + bins[i]);
	}
    }
}
