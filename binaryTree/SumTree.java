package binaryTree;

class SumTree
{
	static class Node
	{
		int key;
		Node left = null, right = null;

		Node(int key) {
			this.key = key;
		}
	}

	public static int isSumTree(Node root)
	{
		if(root==null)
			return 0;
		if(root.left==null&&root.right==null)
			return root.key;
		if(root.key==isSumTree(root.left) + isSumTree(root.right))
			return 2 * root.key;
		return Integer.MIN_VALUE;
	}

	public static void main(String[] args)
	{
	    /* Construct below tree
		         44
		        /  \
		       /    \
		      9     13
		     / \    / \
		    4   5  6   7
	    */

		Node root = new Node(44);
		root.left = new Node(9);
		root.right = new Node(13);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		if (isSumTree(root) != Integer.MIN_VALUE)
			System.out.print("Yes");
		else 
			System.out.print("No");
	}
}
//algo: O(n)time, O(h) space where h=height of the binary tree
//We can easily solve this problem by using recursion.
//The idea is to traverse the tree in postorder fashion.
//Then for each non-leaf node, we check if node’s value is equal to sum of all elements present in its left subtree and right subtree.
//If this relation do not hold true for any node, then the given binary tree cannot be a sum tree.