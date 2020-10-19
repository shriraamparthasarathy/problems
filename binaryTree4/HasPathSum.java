package binaryTree4;

//Given a binary tree and a number, return true if the tree has a root-to-leaf path such that
//		adding up all the values along the path equals the given number. Return false if no such 
//		path can be found.

class HasPathSum 
{ 
	static class Node 
	{ 
		int data; 
		Node left, right; 

		Node(int item) 
		{ 
			data = item; 
			left = right = null; 
		} 
	} 
	Node root; 
	
	/*
	Strategy: subtract the node value from the sum when recurring down, 
	and check to see if the sum is 0 when you run out of tree. 
	*/

	boolean haspathSum(Node node, int sum) 
	{ 
		if(node==null)
			return sum==0;
		return haspathSum(node.left,sum-node.data)||haspathSum(node.right,sum-node.data);
	} 
	
	public static void main(String args[]) 
	{ 
		int sum = 21; 
		
		/* Constructed binary tree is 
			10 
			/ \ 
		   8    2 
		  / \  / 
		 3   5 2 
		*/
		HasPathSum tree = new HasPathSum(); 
		tree.root = new Node(10); 
		tree.root.left = new Node(8); 
		tree.root.right = new Node(2); 
		tree.root.left.left = new Node(3); 
		tree.root.left.right = new Node(5); 
		tree.root.right.left = new Node(2); 

		if (tree.haspathSum(tree.root, sum)) 
			System.out.println("There is a root to leaf path with sum " + sum); 
		else
			System.out.println("There is no root to leaf path with sum " + sum); 
	} 
} 
//algo
//Recursively check if left or right child has path sum equal to ( number – value at current node)
