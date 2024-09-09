package edu.unca.csci202;

public class Main {

	public static void main(String[] args) {
		MidStackADT<String> midStack = new MidStack<String>();
		
		midStack.pushTop("A");
		midStack.pushTop("B");
		midStack.pushTop("C");
		midStack.pushTop("D");
		midStack.pushTop("E");
		
		System.out.println(midStack); //[A, B, C*, D, E]
		String element = midStack.popMid();
		System.out.println("popped mid returned: "+element); //C
		System.out.println(midStack); //[A, B, D*, E]

		midStack.pushMid("Z");
		
		System.out.println("after pushMid(\"Z\")");
		System.out.println(midStack); //[A, B, Z*, D, E]
	}

}
