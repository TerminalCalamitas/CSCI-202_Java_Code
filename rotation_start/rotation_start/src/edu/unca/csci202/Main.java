package edu.unca.csci202;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {

		// Make the leaves
//		LinkedBinaryTree<String> D = new LinkedBinaryTree<String>("D");
		LinkedBinaryTree<String> F = new LinkedBinaryTree<String>("F");
		LinkedBinaryTree<String> E = new LinkedBinaryTree<String>("E");
		LinkedBinaryTree<String> C = new LinkedBinaryTree<String>("C");

		// make sub-tree
		LinkedBinaryTree<String> D = new LinkedBinaryTree<String>("D", null, F);
		LinkedBinaryTree<String> B = new LinkedBinaryTree<String>("B", D, E);

		LinkedBinaryTree<String> A = new LinkedBinaryTree<String>("A", B, C);

		// a node to represent the rest of the tree
		LinkedBinaryTree<String> restOfTree = new LinkedBinaryTree<String>("restOfTree", A, null);

		System.out.println("Before rotation around A:");
		System.out.println(restOfTree);

		// uncomment after implementing
		BinaryTreeNode<String> nodeA = restOfTree.getRootNode().getLeft();
		restOfTree.getRootNode().setLeft(restOfTree.rightRotation(nodeA));

		System.out.println("After rotation around A:");
		System.out.println(restOfTree);

	}

}
