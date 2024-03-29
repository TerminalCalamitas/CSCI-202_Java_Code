package edu.unca.csci202;

import java.util.Iterator;
import java.util.LinkedList;

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

	/**
	 * A method to see if an element is in a binary tree.
	 * 
	 * @param targetElement A generic object to see if the tree contains.
	 * @return A boolean of if the tree contains the given element.
	 */
	@Override
	public boolean contains(T targetElement) {
		Iterator<T> iter = iteratorInOrder();

		while (iter.hasNext()) {
			T element = iter.next();
			if (element.equals(element)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * A method to find an element in a binary tree
	 * 
	 * @param targetElement A generic object to find.
	 * @throws ElementNotFoundException Throws if element not in tree.
	 * @return The object being searched for.
	 */
	@Override
	public T find(T targetElement) throws ElementNotFoundException {
		Iterator<T> iter = iteratorInOrder();

		while (iter.hasNext()) {
			T element = iter.next();
			if (element.equals(element)) {
				return element;
			}
		}
		throw new ElementNotFoundException("LinkedBinaryTree");
	}

	/**
	 * Required by interface calls iteratorInOrder()
	 * 
	 * @return value of iteratorInOrder()
	 */
	@Override
	public Iterator<T> iterator() {
		return iteratorInOrder();
	}

	/**
	 * In order traversal for a binary tree
	 *
	 * @return Linked list of node values in the order visited (left child, self,
	 *         then right child).
	 */
	@Override
	public Iterator<T> iteratorInOrder() {
		LinkedList<T> list = new LinkedList<T>();
		traverseInOrder(root, list);

		return list.iterator();
	}

	/**
	 * In order traversal for a binary tree
	 *
	 * @return Linked list of node values in the order visited (left child, right
	 *         child, then self).
	 */
	@Override
	public Iterator<T> iteratorPostOrder() {
		LinkedList<T> list = new LinkedList<T>();
		traversePostOrder(root, list);

		return list.iterator();
	}

	@Override
	public Iterator<T> iteratorLevelOrder() {
		LinkedList<T> list = new LinkedList<T>();
		traverseLevelOrder(root, list);
		return list.iterator();
	}

	@Override
	public Iterator<T> iteratorPreOrder() {
		LinkedList<T> list = new LinkedList<T>();
		traversePreOrder(root, list);
		return list.iterator();
	}

	/**
	 * Recursive helper method for iteratorInOrder
	 * 
	 * @param node the root of the subtree
	 * @param list list that is built in inorder
	 */
	private void traverseInOrder(BinaryTreeNode<T> node, LinkedList<T> list) {
		if (node != null) {

			// left
			traverseInOrder(node.getLeft(), list);

			// middle
			list.add(node.getData());

			// right
			traverseInOrder(node.getRight(), list);

		}
	}

	/**
	 * Recursive helper method for iteratorPostOrder
	 * 
	 * @param node the root of the subtree
	 * @param list list that is built in postorder
	 */
	private void traversePostOrder(BinaryTreeNode<T> node, LinkedList<T> list) {
		if (node != null) {
			// left
			traversePostOrder(node.getLeft(), list);
			// right
			traversePostOrder(node.getRight(), list);
			// middle
			list.add(node.getData());
		}
	}

	/**
	 * Non-recursive helper method for iteratorLevelOrder
	 * 
	 * @param node the root of the subtree
	 * @param list list that is built in levelorder
	 */
	private void traverseLevelOrder(BinaryTreeNode<T> node, LinkedList<T> list) {
		LinkedList<BinaryTreeNode<T>> queue = new LinkedList<BinaryTreeNode<T>>();
		queue.add(root);

		while (!queue.isEmpty()) {
			BinaryTreeNode<T> currentNode = queue.pop();
			list.add(currentNode.getData());
			if (currentNode.left != null) {
				queue.add(currentNode.left);
			}
			if (currentNode.right != null) {
				queue.add(currentNode.right);
			}
		}
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

}
