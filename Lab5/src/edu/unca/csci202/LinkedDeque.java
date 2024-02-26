package edu.unca.csci202;

import java.util.NoSuchElementException;

/**
 * Implementation of linked double-ended queue uses dummy (aka sentinel) nodes
 * at head and tail
 */
public class LinkedDeque<E> implements Deque<E> {

	private DNode<E> head;
	private DNode<E> tail;

	/**
	 * Constructor, creates both a dummy head and a dummy tail.
	 */
	public LinkedDeque() {
		head = new DNode<>();
		tail = new DNode<>();
		head.setNext(tail);
		tail.setPrevious(head);
	}

	/**
	 * @return returns true if the deque is empty
	 */
	public boolean isEmpty() {
		return head.getNext() == tail;
	}

	/**
	 * Remove all elements from the deque.
	 */
	public void clear() {
		head.setNext(tail);
		tail.setPrevious(head);
	}

	// IMPLEMENT THESE METHODS
	public void addFirst(E element) {
		DNode<E> temp = new DNode<>(element);
		// Own re-referencing
		temp.setNext(head.getNext());
		temp.setPrevious(head);
		// Re-refrencing head.next
		head.getNext().setPrevious(temp);
		head.setNext(temp);

	}

	public E removeFirst() {
		if (!isEmpty()) {
			DNode<E> temp = head;
			head.getNext().getNext().setPrevious(head);
			head.setNext(head.getNext().getNext());
			return temp.getData();
		} else {
			throw new NoSuchElementException();
		}
	}

	public E getFirst() {
		if (!isEmpty()) {
			return head.getNext().getData();
		} else {
			throw new NoSuchElementException();
		}
	}

	public boolean removeFirstOccurrence(E obj) {
		DNode<E> iterator = head.getNext();

		while (!iterator.getNext().equals(tail)) {
			if (iterator.getData().equals(obj) || iterator.getData() == obj) {
				iterator.getNext().setPrevious(iterator.getPrevious());
				iterator.getPrevious().setNext(iterator.getNext());
				iterator = null;
				return true;
			}
			iterator = iterator.getNext();
		}

		return false;
	}

	public void addLast(E element) {
		DNode<E> temp = new DNode<>(element);
		// Own re-referencing
		temp.setPrevious(tail.getPrevious());
		temp.setNext(tail);
		// Re-refrencing tail.previous
		tail.getPrevious().setNext(temp);
		tail.setPrevious(temp);
	}

	public E removeLast() {
		if (!isEmpty()) {
			DNode<E> temp = tail.getPrevious();
			tail.getPrevious().getPrevious().setNext(tail);
			tail.setPrevious(tail.getPrevious().getPrevious());

			return temp.getData();
		} else {
			throw new NoSuchElementException();
		}
	}

	public E getLast() {
		if (!isEmpty()) {
			return tail.getPrevious().getData();
		} else {
			throw new NoSuchElementException();
		}
	}

	public boolean removeLastOccurrence(E obj) {
		DNode<E> iterator = tail.getPrevious();

		while (iterator.getPrevious() != null && !iterator.getPrevious().equals(head)) {
			if (iterator.getData().equals(obj) || iterator.getData() == obj) {
				iterator.getPrevious().setNext(iterator.getNext());
				iterator.getNext().setPrevious(iterator.getPrevious());
				iterator = null;
				return true;
			}
			iterator = iterator.getPrevious();
		}

		return false;
	}

	// methods to print the deque are provided:
	// do not modify these methods
	/**
	 * Print the contents of the deque from front (head) to back (tail)
	 */
	public void printForward() {
		System.out.println("The deque printed forward:");
		DNode<E> current = head.getNext();
		while (current != tail) {
			System.out.println(current.getData());
			current = current.getNext();
		}
		System.out.println();
	}

	/**
	 * Print the contents of the deque backwards (from back/tail to front/head)
	 */
	public void printBackward() {
		System.out.println("The deque printed backward:");
		DNode<E> current = tail.getPrevious();
		while (current != head) {
			System.out.println(current.getData());
			current = current.getPrevious();
		}
		System.out.println();
	}

}
