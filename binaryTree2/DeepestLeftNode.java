package binaryTree2;
//Given a Binary Tree, find the deepest leaf node that is left child of its parent. 
//For example, consider the following tree. The deepest left leaf node is the node with value 9.
//1
///   \
//2     3
///      /  \  
//4      5    6
// \     \
//  7     8
// /       \
//9         10

class Node 
{ 
	int data; 
	Node left, right; 

	public Node(int data) 
	{ 
		this.data = data; 
		left = right = null; 
	} 
} 


class Level 
{ 
	// maxlevel: gives the 
	// value of level of 
	// maximum left leaf 
	int maxlevel;
	Level()
	{
		this.maxlevel=0;
	}
} 

class DeepestLeftNode 
{ 
	Node root; 
	Node result; 

	void deepestLeftLeafUtil(Node node, int lvl, Level level, boolean isLeft) 
	{ 
		if(node ==null)
			return;
		if(isLeft==true&&node.left==null&&node.right==null&&lvl>level.maxlevel)
		{
			result=node;
			level.maxlevel=lvl;
		}
		deepestLeftLeafUtil(node.left,lvl+1,level,true);
		deepestLeftLeafUtil(node.right,lvl+1,level,false);
	} 

	void deepestLeftLeaf(Node node) 
	{ 
		Level level = new Level(); 
		deepestLeftLeafUtil(node, 0, level, false); 
	} 
	
	public static void main(String[] args) 
	{ 
		DeepestLeftNode tree = new DeepestLeftNode(); 
		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
		tree.root.left.left = new Node(4); 
		tree.root.right.left = new Node(5); 
		tree.root.right.right = new Node(6); 
		tree.root.right.left.right = new Node(7); 
		tree.root.right.right.right = new Node(8); 
		tree.root.right.left.right.left = new Node(9); 
		tree.root.right.right.right.right = new Node(10); 

		tree.deepestLeftLeaf(tree.root); 
		if (tree.result != null) 
			System.out.println("The deepest left child"+ 
							" is " + tree.result.data); 
		else
			System.out.println("There is no left leaf in"+ 
							" the given tree"); 
	} 
} 
//algo
//The idea is to recursively traverse the given binary tree and while traversing,
//maintain “level” which will store the current node’s level in the tree. If current
//node is left leaf, then check if its level is more than the level of deepest left leaf seen
//so far. If level is more then update the result. If current node is not leaf, then recursively
//find maximum depth in left and right subtrees, and return maximum of the two depths. 
