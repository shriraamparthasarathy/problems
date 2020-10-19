package binarySearchTree2;


class ClosestElementBST 
{ 
	
	static int min_diff, min_diff_key; 

	static class Node 
	{ 
		int key; 	
		Node left, right; 
	} 


	static Node newnode(int key) 
	{ 	
		Node node = new Node(); 
		node.key = key; 
		node.left = node.right = null; 
		return (node); 
	} 


	static void maxDiffUtil(Node ptr, int k) 
	{ 
		if(ptr==null)
			return;
		if(ptr.key==k)
		{
			min_diff_key=ptr.key;
			return;
		}
		if(min_diff>Math.abs(ptr.key-k))
		{
			min_diff=Math.abs(ptr.key-k);
			min_diff_key=ptr.key;
		}
		if(k<ptr.key)
			maxDiffUtil(ptr.left,k);
		else
			maxDiffUtil(ptr.right,k);
	} 

	static int maxDiff(Node root, int k) 
	{ 
		min_diff = 999999999; min_diff_key = -1; 
		maxDiffUtil(root, k); 
		return min_diff_key; 
	} 


	public static void main(String args[]) 
	{ 
		Node root = newnode(9); 
		root.left = newnode(4); 
		root.right = newnode(17); 
		root.left.left = newnode(3); 
		root.left.right = newnode(6); 
		root.left.right.left = newnode(5); 
		root.left.right.right = newnode(7); 
		root.right.right = newnode(22); 
		root.right.right.left = newnode(20); 
		int k = 18; 
		System.out.println( maxDiff(root, k)); 
	
	} 
} 
//algo
//If target value K is present in given BST, then it’s the node having minimum absolute difference.
//If target value K is less than the value of current node then move to the left child.
//If target value K is greater than the value of current node then move to the right child.