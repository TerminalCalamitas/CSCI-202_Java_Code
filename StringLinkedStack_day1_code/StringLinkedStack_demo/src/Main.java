
public class Main {

	public static void main(String[] args) {
//		StringLinkedNode test1 = new StringLinkedNode("Hi");
//		System.out.println("element is "+test1.getElement());
//		System.out.println("next is"+test1.getNext());
		StringLinkedStack stack = new StringLinkedStack();
		stack.push("Hi");
		stack.push("Kevin");
		System.out.println(stack);
		stack.push("Hello");
		System.out.println(stack);
		String element = stack.pop();
		System.out.println("popped: "+element);
		System.out.println(stack);
	}

}
