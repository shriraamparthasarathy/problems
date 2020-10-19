package binaryTree2;


class MaxPathSum 
{ 
	static class Node { 

		int data; 
		Node left, right; 

		Node(int item) { 
			data = item; 
			left = right = null; 
		} 
	} 

	//An object of Res is passed around so that the 
	//same value can be used by multiple recursive calls. 
	static class Res { 
		int val; 
	} 

	Node root; 

	// A utility function to find the maximum sum between any 
	// two leaves.This function calculates two values: 
	// 1) Maximum path sum between two leaves which is stored 
	// in res. 
	// 2) The maximum root to leaf path sum which is returned. 
	// If one side of root is empty, then it returns INT_MIN 
	int maxPathSumUtil(Node node, Res res)
	{ 

		if(node==null)
			return 0;
		if(node.left==null&&node.right==null)
			return node.data;
		int ls=maxPathSumUtil(node.left,res);
		int rs=maxPathSumUtil(node.right,res);
		if(node.left!=null&&node.right!=null)
		{
			res.val=Math.max(res.val,ls+rs+node.data);
			return Math.max(ls, rs)+node.data;
		}
		return (node.left==null)?rs+node.data:ls+node.data;
	} 

	// The main function which returns sum of the maximum 
	// sum path between two leaves. This function mainly 
	// uses maxPathSumUtil() 
	int maxPathSum(Node node) 
	{ 
		Res res = new Res(); 
		res.val = Integer.MIN_VALUE; 
		maxPathSumUtil(root, res); 
		return res.val; 
	} 

	public static void main(String args[]) 
	{ 
		MaxPathSum tree = new MaxPathSum(); 
		tree.root = new Node(-15); 
		tree.root.left = new Node(5); 
		tree.root.right = new Node(6); 
		tree.root.left.left = new Node(-8); 
		tree.root.left.right = new Node(1); 
		tree.root.left.left.left = new Node(2); 
		tree.root.left.left.right = new Node(6); 
		tree.root.right.left = new Node(3); 
		tree.root.right.right = new Node(9); 
		tree.root.right.right.right = new Node(0); 
		tree.root.right.right.right.left = new Node(4); 
		tree.root.right.right.right.right = new Node(-1); 
		tree.root.right.right.right.right.left = new Node(10); 
		System.out.println("Max pathSum of the given binary tree is "
				+ tree.maxPathSum(tree.root)); 
	} 
} 
//algo
//We can find the maximum sum using single traversal of binary tree. 
//The idea is to maintain two values in recursive calls
//1) Maximum root to leaf path sum for the subtree rooted under current node.
//2) The maximum path sum between leaves (desired output).
//
//For every visited node X, we find the maximum root to leaf sum in left and right subtrees of X.
//We add the two values with X->data, and compare the sum with maximum path sum found so far.