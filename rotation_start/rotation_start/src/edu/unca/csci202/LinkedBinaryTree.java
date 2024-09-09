package edu.unca.csci202;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * Binary Tree data structure
 *
 * @param <T>
 */
public class LinkedBinaryTree<T> implements BinaryTreeADT<T>, Iterable<T> {
    // instance variables
    protected BinaryTreeNode<T> root;
    protected int modCount; //

    // Constructors
    public LinkedBinaryTree() {
	this.root = null;
    }

    public LinkedBinaryTree(T data) {
	this.root = new BinaryTreeNode<T>(data);
    }

    public LinkedBinaryTree(T data, LinkedBinaryTree<T> left, LinkedBinaryTree<T> right) {
	this.root = new BinaryTreeNode<T>(data);
	if (left != null) {
	    this.root.setLeft(left.getRootNode());
	}
	if (right != null) {
	    this.root.setRight(right.getRootNode());
	}
    }

    private int findHeight(BinaryTreeNode<T> root) {
	if (root == null) {
	    return -1; // Empty tree has height -1 (common convention)
	}
	int leftHeight = findHeight(root.left);
	int rightHeight = findHeight(root.right);
	return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
    }

    /**
     * 
     */
    public String printPretty(BinaryTreeNode<T> node, int level) {
	int treeHeight = findHeight(node);
	String ret = "";
	if (node != null) {
	    for (int i = 0; i < treeHeight; i++) {
		ret += " ";
	    }
	    ret += node.getData();
	    ret += "\n";
	    // recurse left
	    ret += print(node.getLeft(), level + 1);
	    // recurse right
	    ret += print(node.getRight(), level + 1);
	}
	return ret;
    }

    /**
     * Print the tree
     */
    public String toString() {
	return print(root, 0);
    }

    /**
     * Print a subtree
     */
    String print(BinaryTreeNode<T> node, int level) {
	String ret = "";
	if (node != null) {
	    for (int i = 0; i < level; i++) {
		ret += "\t";
	    }
	    ret += node.getData();
	    ret += "\n";
	    // recurse left
	    ret += print(node.getLeft(), level + 1);
	    // recurse right
	    ret += print(node.getRight(), level + 1);
	}
	return ret;
    }

    /**
     * return the root node of this subtree
     * 
     * @return root node of sub tree
     */
    public BinaryTreeNode<T> getRootNode() {
	return this.root;
    }

    @Override
    public T getRootElement() {
	if (root == null) {
	    return null;
	}
	return this.root.getData();
    }

    @Override
    public boolean isEmpty() {
	if (root == null) {
	    return true;
	}
	return false;
    }

    @Override
    public int size() {
	if (isEmpty()) {
	    return 0;
	}
	return root.countDescendants() + 1;
    }

    @Override
    public boolean contains(T targetElement) {
	return false;
    }

    @Override
    public T find(T targetElement) {
	return null;
    }

    @Override
    public Iterator<T> iterator() {
	return null;
    }

    @Override
    public Iterator<T> iteratorInOrder() {
	return null;
    }

    @Override
    public Iterator<T> iteratorPostOrder() {
	return null;
    }

    @Override
    public Iterator<T> iteratorLevelOrder() {
	return null;
    }

    @Override
    public Iterator<T> iteratorPreOrder() {
	LinkedList<T> list = new LinkedList<T>();
	traversePreOrder(root, list);
	// return list.iterator();
	// alternative version using inner TreeIterator class
	// this would properly handle concurrent modification
	return new TreeIterator(list.iterator());
    }

    /**
     * Recursive helper method for iteratorPreOrder
     * 
     * @param node the root of the subtree
     * @param list list that is built in preorder
     */
    private void traversePreOrder(BinaryTreeNode<T> node, LinkedList<T> list) {
	if (node != null) {
	    // visit node
	    list.add(node.getData());
	    // recurse left
	    traversePreOrder(node.getLeft(), list);
	    // recurse right
	    traversePreOrder(node.getRight(), list);
	}
    }

    /**
     * Inner class to represent an iterator over the elements of this tree
     */
    private class TreeIterator implements Iterator<T> {
	private int expectedModCount;
	private Iterator<T> iter;

	/**
	 * Sets up this iterator using the specified iterator.
	 *
	 * @param iter the list iterator created by a tree traversal
	 */
	public TreeIterator(Iterator<T> iter) {
	    this.iter = iter;
	    expectedModCount = modCount;
	}

	/**
	 * Returns true if this iterator has at least one more element to deliver in the
	 * iteration.
	 *
	 * @return true if this iterator has at least one more element to deliver in the
	 *         iteration
	 * @throws ConcurrentModificationException if the collection has changed while
	 *                                         the iterator is in use
	 */
	public boolean hasNext() throws ConcurrentModificationException {
	    if (!(modCount == expectedModCount))
		throw new ConcurrentModificationException();

	    return (iter.hasNext());
	}

	/**
	 * Returns the next element in the iteration. If there are no more elements in
	 * this iteration, a NoSuchElementException is thrown.
	 *
	 * @return the next element in the iteration
	 * @throws NoSuchElementException if the iterator is empty
	 */
	public T next() throws NoSuchElementException {
	    // System.out.println("next!");
	    if (hasNext())
		return (iter.next());
	    else
		throw new NoSuchElementException();
	}

	/**
	 * The remove operation is not supported.
	 * 
	 * @throws UnsupportedOperationException if the remove operation is called
	 */
	public void remove() {
	    throw new UnsupportedOperationException();
	}
    }

    public BinaryTreeNode<T> rightRotation(BinaryTreeNode<T> nodeA) {
	BinaryTreeNode<T> pivot = nodeA.getLeft();
	nodeA.setLeft(pivot.getRight());
	pivot.setRight(nodeA);
	return pivot;
    }
}
