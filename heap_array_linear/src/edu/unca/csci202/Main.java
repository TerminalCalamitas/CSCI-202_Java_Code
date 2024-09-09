package edu.unca.csci202;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		HeapArrayLinear<Integer> heap = new HeapArrayLinear<Integer>();
		
		Random rand = new Random(123);
		
		int N = 1000;
		
		// put elements in
		for (int i=0; i<N; i++) {
			Integer num = rand.nextInt();
			heap.addElement(num);
		}
		
		// remove some elements
		for (int i=0; i<N/100; i++) {
			heap.removeMin();
		}
		
		// put more elements in
		for (int i=0; i<N/100; i++) {
			Integer num = rand.nextInt();
			heap.addElement(num);
		}
		
		System.out.println("heap.size()="+heap.size());
		System.out.println("top of heap: "+heap.findMin());

	}

}
