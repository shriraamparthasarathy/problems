package binaryHeap;


class Is_BinaryTree_MaxHeap 
{ 
	static class Node 
	{ 
		int key; 
		Node left, right; 

		Node(int k) 
		{ 
			key = k; 
			left = right = null; 
		} 
	} 

	int countNodes(Node root)
	{
		if(root==null)
			return 0;
		return 1 + countNodes(root.left) + countNodes(root.right);
	}
	boolean isCompleteUtil(Node root,int index,int node_count)
	{
		if(root==null)
			return true;
		if(index >= node_count)
			return false;
		return isCompleteUtil(root.left,2*index+1,node_count)&&isCompleteUtil(root.right,2*index+2,node_count);
	}
	boolean isHeapUtil(Node root)
	{
		if(root.left==null&&root.right==null)
			return true;
		if(root.right==null)
			return root.key>=root.left.key;
		else
		{
			if(root.key>=root.left.key&&root.key>=root.right.key)
				return isHeapUtil(root.left)&&isHeapUtil(root.right);
			else
				return false;
		}
	}
	boolean isHeap(Node root) 
	{ 
		if(root == null) 
			return true;  
		int node_count = countNodes(root); 
		
		if(isCompleteUtil(root, 0 , node_count)==true && isHeapUtil(root)==true) 
			return true; 
		return false; 
	} 
	public static void main(String args[]) 
	{ 
		Is_BinaryTree_MaxHeap bt = new Is_BinaryTree_MaxHeap(); 
		
		Node root = new Node(10); 
		root.left = new Node(9); 
		root.right = new Node(8); 
		root.left.left = new Node(7); 
		root.left.right = new Node(6); 
		root.right.left = new Node(5); 
		root.right.right = new Node(4); 
		root.left.left.left = new Node(3); 
		root.left.left.right = new Node(2); 
		root.left.right.left = new Node(1); 

		if(bt.isHeap(root) == true) 
			System.out.println("Given binary tree is a Heap"); 
		else
			System.out.println("Given binary tree is not a Heap"); 
	} 
} 
//algo
//Given a binary tree, we need to check it has heap property or not, Binary tree need to
//fulfill the following two conditions for being a heap –
//
//It should be a complete tree (i.e. all levels except last should be full).
//Every node’s value should be greater than or equal to its child node (considering max-heap).

//isHeapUtil function is written considering the following things –
//
//Every Node can have 2 children, 0 child (last level nodes) or 1 child (there can be at most one 
//		such node).
//If Node has No child then it’s a leaf node and returns true (Base case)
//If Node has one child (it must be left child because it is a complete tree) then we need to
//compare this node with its single child only.
//If the Node has both child then check heap property at Node at recur for both subtrees.
//Complete code.