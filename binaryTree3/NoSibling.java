package binaryTree3;
//Given a Binary Tree, print all nodes that don’t have a sibling (a sibling is a node that has
//		same parent. In a Binary Tree, there can be at most one sibling). Root should
//not be printed as root cannot have a sibling.


class NoSibling 
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
	
	void printSingles(Node node) 
	{ 
		if(node==null)
			return;
		if(node.left!=null&&node.right!=null)
		{
			printSingles(node.left);
			printSingles(node.right);
		}
		else if(node.right!=null)
		{
			System.out.print(node.right.data+" ");
			printSingles(node.right);
		}
		else if(node.left!=null)
		{
			System.out.print(node.left.data+" ");
			printSingles(node.left);
		}
	} 
	
	public static void main(String args[]) 
	{ 
		NoSibling tree = new NoSibling(); 

		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
		tree.root.left.right = new Node(4); 
		tree.root.right.left = new Node(5); 
		tree.root.right.left.right = new Node(6); 
		tree.printSingles(tree.root); 
	} 
} 
//algo
//This is a typical tree traversal question. We start from root and check if the node has one
//child, if yes then print the only child of that node. If node has both children, then recur 
//for both the children.