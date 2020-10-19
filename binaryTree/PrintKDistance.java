package binaryTree;
//Given a root of a tree, and an integer k. Print all the nodes which are at k distance from root.
//For example, in the below tree, 4, 5 & 8 are at distance 2 from root.
//            1
//          /   \
//        2      3
//      /  \    /
//    4     5  8 

class Node 
{ 
	int data; 
	Node left, right; 

	Node(int item) 
	{ 
		data = item; 
		left = right = null; 
	} 
} 

class PrintKDistance 
{ 
	Node root; 

	void printKDistant(Node node, int k) 
	{ 
		if(node==null)
			return;
		if(k==0)
		{
			System.out.print(node.data+ " ");
			return;
		}
		else
		{
			printKDistant(node.left,k-1);
			printKDistant(node.right,k-1);
		}
	} 
	
	public static void main(String args[])
	{ 
		PrintKDistance tree = new PrintKDistance(); 
		
		/* Constructed binary tree is 
				1 
			/ \ 
			2	 3 
			/ \ / 
		4 5 8 
		*/
		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
		tree.root.left.left = new Node(4); 
		tree.root.left.right = new Node(5); 
		tree.root.right.left = new Node(8); 

		tree.printKDistant(tree.root, 2); 
	} 
} 

//algo level order traversal