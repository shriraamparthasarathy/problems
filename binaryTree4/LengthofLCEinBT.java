package binaryTree4;
//Given a Binary Tree find the length of the longest path which comprises of
//nodes with consecutive values in increasing order. Every node is considered as a path of length 1.

class LengthofLCEinBT 
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

	static class Result 
	{ 
		int res = 0; 
	} 

	Node root; 

	int longestConsecutive(Node root) 
	{ 
		if (root == null) 
			return 0; 
		Result res = new Result(); 
		longestConsecutiveUtil(root, 0, root.data, res);
		return res.res; 
	} 


    void longestConsecutiveUtil(Node root, int curlength,int expected, Result res) 
	{ 
		if (root == null) 
			return; 

		if(root.data==expected)
			curlength++;
		else
			curlength=1;
		res.res=Math.max(curlength, res.res);
		longestConsecutiveUtil(root.left,curlength,root.data+1,res);
		longestConsecutiveUtil(root.right,curlength,root.data+1,res);
	} 
 
	public static void main(String args[]) 
	{ 
		LengthofLCEinBT tree = new LengthofLCEinBT(); 

		tree.root = new Node(6); 
		tree.root.right = new Node(9); 
		tree.root.right.left = new Node(7); 
		tree.root.right.right = new Node(10); 
		tree.root.right.right.right = new Node(11); 

		System.out.println(tree.longestConsecutive(tree.root)); 
	} 
} 
//algo
//At each node we need information of its parent node, if current node has value one more than 
//its parent node then it makes a consecutive path, at each node we will compare node’s value
//with its parent value and update the longest consecutive path accordingly.
//For getting the value of parent node, we will pass the (node_value + 1) as an argument to the
//recursive method and compare the node value with this argument value, if satisfies, update the 
//current length of consecutive path otherwise reinitialize current path length by 1.