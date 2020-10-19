package binaryTree4;


public class MaximumDifferencebetweenNodes 
{ 
	static class Node 
	{ 
		int key; 
		Node left, right; 

		public Node(int key) 
		{ 
			this.key = key; 
			left = right = null; 
		} 
	} 
	static class Res 
	{ 
		int r = Integer.MIN_VALUE; 
	} 
	Node root; 


	int maxDiffUtil(Node t, Res res) 
	{ 
		if(t==null)
			return Integer.MAX_VALUE;
		if(t.left==null&&t.right==null)
			return t.key;
		int val=Math.min(maxDiffUtil(t.left,res), maxDiffUtil(t.right,res));
		res.r=Math.max(res.r,t.key-val);
		return Math.min(t.key, val);
	} 

	int maxDiff(Node root) 
	{ 
		Res res = new Res(); 
		maxDiffUtil(root, res); 
		return res.r; 
	} 

	void inorder(Node root) 
	{ 
		if (root != null) 
		{ 
			inorder(root.left); 
			System.out.print(root.key + ""); 
			inorder(root.right); 
		} 
	} 

	public static void main(String[] args) 
	{ 
		MaximumDifferencebetweenNodes tree = new MaximumDifferencebetweenNodes(); 

		tree.root = new Node(8); 
		tree.root.left = new Node(3); 
		tree.root.left.left = new Node(1); 
		tree.root.left.right = new Node(6); 
		tree.root.left.right.left = new Node(4); 
		tree.root.left.right.right = new Node(7); 

		tree.root.right = new Node(10); 
		tree.root.right.right = new Node(14); 
		tree.root.right.right.left = new Node(13); 

		System.out.println("Maximum difference between a node and"
				+ " its ancestor is : " + tree.maxDiff(tree.root)); 
	} 
} 
//algo
//As we are given a binary tree, there is no relationship between node values so we need to
//traverse whole binary tree to get max difference and we can obtain the result in one traversal
//only by following below steps :
//If we are at leaf node then just return its value because it can’t be ancestor of any node.
//		Then at each internal node we will try to get minimum value from left subtree and right 
//		subtree and calculate the difference between node value and this minimum value and
//		according to that we will update the result.
//As we are calculating minimum value while retuning in recurrence we will check all optimal
//possibilities (checking node value with minimum subtree value only) of differences and hence
//calculate the result in one traversal only.