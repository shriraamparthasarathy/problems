package linkedList4;
//https://www.geeksforgeeks.org/convert-given-binary-tree-doubly-linked-list-set-3/
class TreetoDLL 
{ 
	static class Node 
	{ 
		int data; 
		Node left, right; 

		public Node(int data) 
		{ 
			this.data = data; 
			left = right = null; 
		} 
	} 
	Node root; 
	Node head; 
	static Node prev = null; 
	void BinaryTree2DoubleLinkedList(Node root) 
	{ 
		if(root==null)
			return;
		BinaryTree2DoubleLinkedList(root.left);
		if(prev==null)
			head=root;
		else
		{
			root.left=prev;
			prev.right=root;
		}
		prev=root;
		BinaryTree2DoubleLinkedList(root.right);
	} 
	void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.right; 
		} 
	} 
	public static void main(String[] args) 
	{ 
		TreetoDLL tree = new TreetoDLL(); 
		tree.root = new Node(10); 
		tree.root.left = new Node(12); 
		tree.root.right = new Node(15); 
		tree.root.left.left = new Node(25); 
		tree.root.left.right = new Node(30); 
		tree.root.right.left = new Node(36); 
		tree.BinaryTree2DoubleLinkedList(tree.root); 
		tree.printList(tree.head); 

	} 
} 
//algo
//In this post, a third solution is discussed which seems to be the simplest of all. 
//The idea is to do inorder traversal of the binary tree. While doing inorder traversal, 
//keep track of the previously visited node in a variable say prev. For every visited node, 
//make it next of prev and previous of this node as prev.