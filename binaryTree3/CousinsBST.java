package binaryTree3;

//Given the binary Tree and the two nodes say ‘a’ and ‘b’, determine whether the two nodes
//are cousins of each other or not.
//Two nodes are cousins of each other if they are at same level and have different parents.
//
//Example:
//
//     6
//   /   \
//  3     5
// / \   / \
//7   8 1   3
//Say two node be 7 and 1, result is TRUE.
//Say two nodes are 3 and 5, result is FALSE.
//Say two nodes are 7 and 5, result is FALSE.
class CousinsBST 
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

	
	boolean isSibling(Node node, Node a, Node b) 
	{ 
		if(node==null)
			return false;
		return((node.left==a&&node.left==b)||(node.left==b&&node.right==a)||
				isSibling(node.left,a,b)||isSibling(node.right,a,b));
	} 


	int level(Node node, Node ptr, int lev) 
	{ 
		if(node==null)
			return 0;
		if(node==ptr)
			return lev;
		int l=level(node.left,ptr,lev+1);
		if(l!=0)
			return l;
		return level(node.right,ptr,lev+1);
	} 

	boolean isCousin(Node node, Node a, Node b) 
	{ 
		return ((level(node, a, 1) == level(node, b, 1)) && (!isSibling(node, a, b))); 
	} 

	public static void main(String args[]) 
	{ 
		CousinsBST tree = new CousinsBST(); 
		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
		tree.root.left.left = new Node(4); 
		tree.root.left.right = new Node(5); 
		tree.root.left.right.right = new Node(15); 
		tree.root.right.left = new Node(6); 
		tree.root.right.right = new Node(7); 
		tree.root.right.left.right = new Node(8); 

		Node Node1, Node2; 
		Node1 = tree.root.left.left; 
		Node2 = tree.root.right.right; 
		if (tree.isCousin(tree.root, Node1, Node2)) 
			System.out.println("Yes"); 
		else
			System.out.println("No"); 
	} 
} 
//algo
//The idea is to find level of one of the nodes. Using the found level, check if ‘a’ and ‘b’
//are at this level. If ‘a’ and ‘b’ are at given level, then finally check if they are not
//children of same parent.