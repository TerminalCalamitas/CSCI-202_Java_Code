package testing;

public class BinaryTree {

	public static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
		}
	}

	public static void printTree(Node root, int level) {
		if (root == null) {
			return;
		}

		// Increase indentation for each level
		for (int i = 0; i < level; i++) {
			System.out.print("  ");
		}
		System.out.println(root.data);

		printTree(root.left, level + 1);
		printTree(root.right, level + 1);
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.right.right = new Node(5);

		printTree(root, 0);
	}
}
