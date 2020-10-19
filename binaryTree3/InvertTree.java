package binaryTree3;
//Mirror of a Tree: Mirror of a Binary Tree T is another Binary Tree M(T) with left and 
//right children of all non-leaf nodes interchanged.

class InvertTree 
{ 
	static class Node 
	{ 
		int data; 
		Node left, right; 

		public Node(int item) 
		{ 
			data = item; 
			left = right = null; 
		} 
	} 
	Node root; 

	void mirror() 
	{ 
		root = mirror(root); 
	} 

	Node mirror(Node node) 
	{ 
		if(node==null)
			return node;
		Node left=mirror(node.left);
		Node right=mirror(node.right);
		node.left=right;
		node.right=left;
		return node;
	} 

	void inOrder() 
	{ 
		inOrder(root); 
	} 

	void inOrder(Node node) 
	{ 
		if (node == null) 
			return; 

		inOrder(node.left); 
		System.out.print(node.data + " "); 

		inOrder(node.right); 
	} 

	public static void main(String args[]) 
	{ 
		InvertTree tree = new InvertTree(); 
		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
		tree.root.left.left = new Node(4); 
		tree.root.left.right = new Node(5); 
		System.out.println("Inorder traversal of input tree is :"); 
		tree.inOrder(); 
		System.out.println(""); 
		tree.mirror(); 
		System.out.println("Inorder traversal of binary tree is : "); 
		tree.inOrder(); 
	} 
} 
//Algorithm – Mirror(tree):
//
//(1)  Call Mirror for left-subtree    i.e., Mirror(left-subtree)
//(2)  Call Mirror for right-subtree  i.e., Mirror(right-subtree)
//(3)  Swap left and right subtrees.
//          temp = left-subtree
//          left-subtree = right-subtree
//          right-subtree = temp