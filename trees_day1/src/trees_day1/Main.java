package trees_day1;

public class Main {

	public static void main(String[] args) {
		BinaryTreeNode<String> leaf1 = new BinaryTreeNode<String>("leaf1");
		BinaryTreeNode<String> leaf2 = new BinaryTreeNode<String>("leaf2");
		BinaryTreeNode<String> leaf3 = new BinaryTreeNode<String>("leaf3");
		
		BinaryTreeNode<String> internal1 = new BinaryTreeNode<String>("internal1",leaf1,leaf2);
		BinaryTreeNode<String> internal2 = new BinaryTreeNode<String>("internal2",leaf3,null);
		BinaryTreeNode<String> root = new BinaryTreeNode<String>("root",internal1,internal2);

		System.out.println(root.getLeft().getRight().getData());//should print leaf2
		
		System.out.println(root.countDescendants());//should print 5
		
	}

}
