package edu.unca.csci202;

public interface SimpleHashTableADT<K, V> {

	/**
	 * Inserts the given key:value pair into the data structure
	 * If key is already in the structure, it updates the value
	 * Uses key hashCode() to determine the bin
	 * 
	 * @param key
	 * @param value
	 */
	public void put(K key, V value);
	
	/**
	 * Get the value associated with the key.
	 * 
	 * @param key
	 * @return the value associated with that key, or null if the key is not in the table
	 */
	public V get(K key);
	
	/**
	 * 
	 * @param key
	 * @return the value associated with the key, or null if the key is not in the table
	 */
	public V remove(K key);
	
	/**
	 * @return the total number of elements in the table
	 */
	public int size();
	
	/**
	 * The "load factor" is the size (number of elements
	 * in the table) divided by the number of bins.
	 * The loadFactorLimit is the maximum load factor allowed.
	 * If the load factor exceeds loadFactorLimit, the number of
	 * bins must be increased.
	 * 
	 * @param loadFactorLimit
	 */
	public void setLoadFactorLimit(double loadFactorLimit);
	
	/**
	 * get the max allowed load factor
	 * 
	 * @return the current load factor limit
	 */
	public double getLoadFactorLimit();
	
	/**
	 * 
	 * @return load factor
	 */
	public double getCurrentLoadFactor();
	
}
