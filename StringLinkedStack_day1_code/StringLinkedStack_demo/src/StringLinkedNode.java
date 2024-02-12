
public class StringLinkedNode {
	private String element;
	private StringLinkedNode next;
	
	public StringLinkedNode(String element) {
		this.element=element;
	}
	
	public String getElement() {
		return element;
	}
	
	public StringLinkedNode getNext() {
		return next;
	}
	
	public void setNext(StringLinkedNode n) {
		next=n;
	}
	
	public void setElement(String elem) {
		element=elem;
	}
}
