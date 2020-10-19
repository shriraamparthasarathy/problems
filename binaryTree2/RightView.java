package binaryTree2;


class RightView
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
	static int max_level = 0; 

	void rightViewUtil(Node node, int level) 
	{ 
		if(node==null)
			return;
		if(max_level<level)
		{
			System.out.print(node.data+" ");
			max_level=level;
		}

		rightViewUtil(node.right,level+1);
		rightViewUtil(node.left,level+1);
	} 

	void rightView() 
	{ 
		rightViewUtil(root, 1); 
	} 

	public static void main(String args[]) 
	{ 
			RightView tree = new RightView(); 
	        tree.root = new Node(1); 
	        tree.root.left = new Node(2); 
	        tree.root.right = new Node(3); 
	        tree.root.left.left = new Node(4); 
	        tree.root.left.right = new Node(5); 
	        tree.root.right.left = new Node(6); 
	        tree.root.right.right = new Node(7); 
	        tree.root.right.left.right = new Node(8); 
	          
	        tree.rightView(); 
	} 
} 
//algo
//same as left view
//we first check rightViewUtil(node.right,level+1); before rightViewUtil(node.left,level+1);