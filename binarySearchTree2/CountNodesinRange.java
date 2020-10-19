package binarySearchTree2;


class CountNodesinRange
{ 

	static class Node 
	{ 
		int data; 
		Node left, right; 

		public Node(int item) { 
			data = item; 
			left = right = null; 
		} 
	} 

	Node root; 

	CountNodesinRange() 
	{ 
		this.root = null; 
	} 
	
	
	int getCount(Node node, int low, int high) 
	{ 
		if(node==null)
			return 0;
		if(low<=node.data&&high>=node.data)
			return 1 + getCount(node.left,low,high) + getCount(node.right,low,high);
		if(node.data<low)
			return getCount(node.right,low,high);
		else
			return getCount(node.left,low,high);
	} 

	public static void main(String[] args) { 
		CountNodesinRange tree = new CountNodesinRange(); 
		
		tree.root = new Node(10); 
		tree.root.left	 = new Node(5); 
		tree.root.right	 = new Node(50); 
		tree.root.left.left = new Node(1); 
		tree.root.right.left = new Node(40); 
		tree.root.right.right = new Node(100); 
		/* Let us construct BST shown in above example 
		10 
		/ \ 
	   5  50 
	  /	 /  \ 
	 1	 40 100 */
	int l=5; 
	int h=45; 
	System.out.println("Count of nodes between [" + l + ", "
					+ h+ "] is " + tree.getCount(tree.root, 
												l, h)); 
	} 
} 
//algo
//The idea is to traverse the given binary search tree starting from root. For every node being
//visited, check if this node lies in range, if yes, then add 1 to result and recur for both of
//its children. If current node is smaller than low value of range, then recur for right child, 
//else recur for left child.