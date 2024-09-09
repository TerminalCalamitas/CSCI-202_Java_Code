package edu.unca.csci202;

public class BinaryTree {
    private int key;
    private BinaryTree leftChild;
    private BinaryTree rightChild;

    public BinaryTree(int key, BinaryTree leftChild, BinaryTree rightChild) {
	this.key = key;
	this.leftChild = leftChild;
	this.rightChild = rightChild;
    }

    // complete this method
    public int product() {
	return nodeProduct(this);
    }

    private int nodeProduct(BinaryTree node) {
	// For catching null nodes
	if (node == null) {
	    // Multiplying so 1 has no effect
	    return 1;
	}

	// inOrder traversal
	int product = 1;
	product *= nodeProduct(node.leftChild);
	product *= node.key;
	product *= nodeProduct(node.rightChild);
	return product;
    }

    // complete this method
    public int countInternalNodes() {
	return intervalNodes(this);
    }

    private int intervalNodes(BinaryTree node) {
	// If node is null or has no children we don't want to interact
	if (node == null || (node.leftChild == null && node.rightChild == null)) {
	    // Adding so 0 has no effect
	    return 0;
	}

	int nodes = 0;
	nodes += intervalNodes(node.leftChild);
	// including self node
	nodes += 1;
	nodes += intervalNodes(node.rightChild);

	return nodes;
    }

    public static void main(String[] args) {
	/*
	 * builds the following tree: 1 4 5 33 6 18 2 14 7 8
	 */
	BinaryTree leaf1 = new BinaryTree(7, null, null);
	BinaryTree leaf2 = new BinaryTree(8, null, null);
	BinaryTree leaf3 = new BinaryTree(2, null, null);
	BinaryTree leaf4 = new BinaryTree(14, null, null);
	BinaryTree node1 = new BinaryTree(18, leaf1, leaf2);
	BinaryTree node2 = new BinaryTree(6, leaf3, leaf4);
	BinaryTree node3 = new BinaryTree(33, node1, null);
	BinaryTree node4 = new BinaryTree(4, null, node3);
	BinaryTree node5 = new BinaryTree(5, node2, null);
	BinaryTree root = new BinaryTree(1, node4, node5);
	System.out.println("internal nodes = " + root.countInternalNodes());// 6
	System.out.println("product = " + root.product()); // 111767040
    }
}
