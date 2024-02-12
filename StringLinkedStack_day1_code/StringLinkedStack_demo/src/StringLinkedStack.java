
public class StringLinkedStack {
	private StringLinkedNode top;
	private int size;

	public StringLinkedStack() {
		top = null;
	}

	public void push(String elem) {
		StringLinkedNode node = new StringLinkedNode(elem);
		node.setNext(top);
		top = node;
		size++;
	}

	public String pop() {
		StringLinkedNode n = top;
		top = top.getNext();
		size--;
		return n.getElement();
	}

	public String toString() {
		String linkString = "[";
		StringLinkedNode node = top;

		for (int i = 0; i < size; i++) {
			linkString += node.getElement();
			node = node.getNext();

			if (node.getNext() != null) {
				linkString += ", ";
			}
		}
		linkString += "]";
		return linkString;
	}

	public int size() {
		return size;
	}
	/*
	 * public String toString() { String linkString = "["; StringLinkedNode node =
	 * top;
	 * 
	 * while (node.getNext() != null) { linkString += node.getElement(); node =
	 * node.getNext();
	 * 
	 * if (node.getNext() != null) { linkString += ", "; } } linkString += "]";
	 * return linkString; }
	 * 
	 * public int size() { int count = 0; StringLinkedNode node = top; while
	 * (node.getNext() != null) { count++; node = node.getNext(); }
	 * 
	 * return count; }
	 */}
