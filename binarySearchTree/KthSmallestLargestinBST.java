package binarySearchTree;


class KthSmallestLargestinBST
{ 
	static class Node 
	{ 
		int data; 
		Node left, right; 
		Node(int x) 
		{ 
			data = x; 
			left = right = null; 
		} 
	} 

	static int count = 0; 
	public static Node insert(Node root, int x) 
	{ 
		if (root == null) 
			return new Node(x); 
		if (x < root.data) 
			root.left = insert(root.left, x); 
		else if (x > root.data) 
			root.right = insert(root.right, x); 
		return root; 
	} 
	
	public static Node kthSmallest(Node root, int k) 
	{ 
		if(root==null)
			return null;
		Node left=kthSmallest(root.left,k);
		if(left!=null)
			return left;
		count++;
		if(count==k)
			return root;
		return kthSmallest(root.right,k);
	} 
	public static Node kthLargest(Node root,int k)
	{
		if(root==null)
			return null;
		Node right=kthLargest(root.right,k);
		if(right!=null)
			return right;
		count++;
		if(count==k)
			return root;
		return kthLargest(root.left,k);
	}
	public static void printKthSmallestLargest(Node root, int k) 
	{ 
		count = 0; 	
		Node res = kthSmallest(root, k); 
		if (res == null) 
			System.out.println("There are less "
						+ "than k nodes in the BST"); 
		else
			System.out.println("K-th Smallest"
					+ " Element is " + res.data); 
		count=0;
		res=kthLargest(root,k);
		if (res == null) 
			System.out.println("There are less "
						+ "than k nodes in the BST"); 
		else
			System.out.println("K-th Largest"
					+ " Element is " + res.data); 
	} 
		
	public static void main (String[] args) { 
		
		Node root = null; 
		int keys[] = { 20, 8, 22, 4, 12, 10, 14 }; 
	
		for (int x : keys) 
			root = insert(root, x); 
		
		int k = 3; 
		printKthSmallestLargest(root, k); 
		
		
	} 
} 
//algo
//for kth smallest
//The Inorder Traversal of a BST traverses the nodes in increasing order. So the idea is
//to traverse the tree in Inorder. While traversing, keep track of the count of the nodes visited.
//If the count becomes k, print the node.
//
//for kth largest
//do reverse inorder