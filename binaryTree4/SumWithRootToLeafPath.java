package binaryTree4;

//Given a binary tree, where every node value is a Digit from 1-9 .Find the sum of all the
//numbers which are formed from root to leaf paths.
//For example consider the following Binary Tree.
//
//           6
//       /      \
//     3          5
//   /   \          \
//  2     5          4  
//      /   \
//     7     4
//  There are 4 leaves, hence 4 root to leaf paths:
//   Path                    Number
//  6->3->2                   632
//  6->3->5->7               6357
//  6->3->5->4               6354
//  6->5>4                    654   
//Answer = 632 + 6357 + 6354 + 654 = 13997 
class SumWithRootToLeafPath 
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

	int treePathsSumUtil(Node node, int val) 
	{ 
		if(node==null)
			return 0;
		val=(val*10)+node.data;
		if(node.left==null&&node.right==null)
			return val;
		return (treePathsSumUtil(node.left,val)+treePathsSumUtil(node.right,val));
	} 

	int treePathsSum(Node node) 
	{ 
		return treePathsSumUtil(node, 0); 
	} 

	public static void main(String args[]) 
	{ 
		SumWithRootToLeafPath tree = new SumWithRootToLeafPath(); 
		tree.root = new Node(6); 
		tree.root.left = new Node(3); 
		tree.root.right = new Node(5); 
		tree.root.right.right = new Node(4); 
		tree.root.left.left = new Node(2); 
		tree.root.left.right = new Node(5); 
		tree.root.left.right.right = new Node(4); 
		tree.root.left.right.left = new Node(7); 
		
		System.out.print("Sum of all paths is " + 
								tree.treePathsSum(tree.root)); 
	}	 
} 
//algo
//The idea is to do a preorder traversal of the tree. In the preorder traversal, keep track of the 
//value calculated till the current node, let this value be val. For every node, we update the val 
//as val*10 plus node’s data.