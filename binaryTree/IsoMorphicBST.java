package binaryTree;



class IsoMorphicBST 
{ 
	static class Node 
	{ 
		int data; 
		Node left, right; 

		Node(int item) 
		{ 
			data = item; 
			left = right; 
		} 
	} 
	Node root1, root2; 

	/* Given a binary tree, print its nodes in reverse level order */
	boolean isIsomorphic(Node n1, Node n2) 
	{ 
		if(n1==null&&n2==null)
			return true;
		if(n1==null||n2==null)
			return false;
		if(n1.data!=n2.data)
			return false;
		return  (isIsomorphic(n1.left,n2.left)&&isIsomorphic(n1.right,n2.right)) ||
				(isIsomorphic(n1.left,n2.right)&&isIsomorphic(n1.right,n2.left));
	} 

	public static void main(String args[]) 
	{ 
		IsoMorphicBST tree = new IsoMorphicBST(); 
		
		tree.root1 = new Node(1); 
		tree.root1.left = new Node(2); 
		tree.root1.right = new Node(3); 
		tree.root1.left.left = new Node(4); 
		tree.root1.left.right = new Node(5); 
		tree.root1.right.left = new Node(6); 
		tree.root1.left.right.left = new Node(7); 
		tree.root1.left.right.right = new Node(8); 
			
//			TREE 1				 TREE 2
//				1					1
//			   / \				   / \
//			  2   3               3   2
//			 / \  / 			  \  / \
//			4  5 6				  6 4   5
//			  / \                      / \
//			 7   8                    8   7
		tree.root2 = new Node(1); 
		tree.root2.left = new Node(3); 
		tree.root2.right = new Node(2); 
		tree.root2.right.left = new Node(4); 
		tree.root2.right.right = new Node(5); 
		tree.root2.left.right = new Node(6); 
		tree.root2.right.right.left = new Node(8); 
		tree.root2.right.right.right = new Node(7); 

		if (tree.isIsomorphic(tree.root1, tree.root2) == true) 
			System.out.println("Yes"); 
		else
			System.out.println("No"); 
	} 
} 
//algo
//We simultaneously traverse both trees. Let the current internal nodes of two trees being 
//traversed be n1 and n2 respectively. There are following two conditions for subtrees rooted 
//with n1 and n2 to be isomorphic.
//1) Data of n1 and n2 is same.
//2) One of the following two is true for children of n1 and n2
//……a) Left child of n1 is isomorphic to left child of n2 and right child of n1 is isomorphic 
//to right child of n2.
//……b) Left child of n1 is isomorphic to right child of n2 and right child of n1 is isomorphic
//to left child of n2.