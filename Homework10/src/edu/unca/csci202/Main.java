package edu.unca.csci202;

public class Main {

    public static void main(String[] args) {
	ArraySet<String> stringArraySet = new ArraySet<>();

	stringArraySet.add("apple");
	stringArraySet.add("banana");
	stringArraySet.add("orange");

	System.out.println("ArraySet size: " + stringArraySet.size());
	System.out.println("ArraySet Contains 'apple': " + stringArraySet.contains("apple"));

	stringArraySet.remove("banana");

	System.out.println("ArraySet Contains 'banana' after removal: " + stringArraySet.contains("banana"));

	System.out.println("ArraySet size: " + stringArraySet.size());
	System.out.println("ArraySet Contains 'orange': " + stringArraySet.contains("orange"));

    }

}
