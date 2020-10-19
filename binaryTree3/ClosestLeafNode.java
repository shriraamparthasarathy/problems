package binaryTree3;
//Given a Binary Tree and a node x in it, find distance of the closest leaf to x in Binary Tree. 
//If given node itself is a leaf, then distance is 0.
//
//Examples:
//
//Input: Root of below tree
//       And x = pointer to node 13
//          10
//       /     \
//     12       13
//             /     
//           14      
//Output 1
//Distance 1. Closest leaf is 14.
//
//
//Input: Root of below tree
//       And x = pointer to node 13
//          10
//       /     \
//     12       13
//           /     \
//         14       15    
//        /   \     /  \
//       21   22   23   24
//       /\   /\   /\   /\
//      1 2  3 4  5 6  7  8
//
//Output 2
//Closest leaf is 12 through 10.

class ClosestLeafNode 
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

	static class Distance 
	{ 
		int minDis = Integer.MAX_VALUE; 
	} 

	Node root; 


	void findLeafDown(Node root, int lev, Distance minDist) 
	{ 
		
		if(root==null)
			return;
		if(root.left==null&&root.right==null)
		{	if(lev<minDist.minDis)
				minDist.minDis=lev;
			return;
		}
		findLeafDown(root.left,lev+1,minDist);
		findLeafDown(root.right,lev+1,minDist);
	} 

	
	int findThroughParent(Node root, Node x, Distance minDist) 
	{ 
		if(root==null)
			return -1;
		if(root==x)
			return 0;
		int l=findThroughParent(root.left,x,minDist);
		if(l!=-1)
		{
			findLeafDown(root.right,l+2,minDist);
			return l+1;
		}
		int r=findThroughParent(root.right,x,minDist);
		if(r!=-1)
		{
			findLeafDown(root.left,r+2,minDist);
			return r+1;
		}
		return -1;
	} 

	int minimumDistance(Node root, Node x) 
	{		
		Distance d = new Distance(); 
		findLeafDown(x, 0, d); 
		findThroughParent(root, x, d); 

		return d.minDis; 
	} 

	// Driver program 
	public static void main(String[] args) 
	{ 
		ClosestLeafNode tree = new ClosestLeafNode(); 
		
		tree.root = new Node(1); 
		tree.root.left = new Node(12); 
		tree.root.right = new Node(13); 

		tree.root.right.left = new Node(14); 
		tree.root.right.right = new Node(15); 

		tree.root.right.left.left = new Node(21); 
		tree.root.right.left.right = new Node(22); 
		tree.root.right.right.left = new Node(23); 
		tree.root.right.right.right = new Node(24); 

		tree.root.right.left.left.left = new Node(1); 
		tree.root.right.left.left.right = new Node(2); 
		tree.root.right.left.right.left = new Node(3); 
		tree.root.right.left.right.right = new Node(4); 
		tree.root.right.right.left.left = new Node(5); 
		tree.root.right.right.left.right = new Node(6); 
		tree.root.right.right.right.left = new Node(7); 
		tree.root.right.right.right.right = new Node(8); 

		Node x = tree.root.right; 

		System.out.println("The closest leaf to node with value "
				+ x.key + " is at a distance of "
				+ tree.minimumDistance(tree.root, x)); 
	} 
} 
//algo
//The idea is to first traverse the subtree rooted with give node and find the closest 
//leaf in this subtree. Store this distance. Now traverse tree starting from root. If given 
//node x is in left subtree of root, then find the closest leaf in right subtree, else find the
//closest left in left subtree.
