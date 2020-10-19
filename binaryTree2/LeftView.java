package binaryTree2;

//Given a Binary Tree, print left view of it. Left view of a Binary Tree is set of nodes visible 
//when tree is visited from left side.
//
//left-view
//
//Examples:
//
//Input : 
//                 1
//               /   \
//              2     3
//             / \     \
//            4   5     6             
//Output : 1 2 4
//
//Input :
//        1
//      /   \
//    2       3
//      \   
//        4  
//          \
//            5
//             \
//               6
//Output :1 2 4 5 6

class LeftView
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

	void leftViewUtil(Node node, int level) 
	{ 
		if(node==null)
			return;
		if(max_level<level)
		{
			System.out.print(node.data+" ");
			max_level=level;
		}
		leftViewUtil(node.left,level+1);
		leftViewUtil(node.right,level+1);
	} 

	void leftView() 
	{ 
		leftViewUtil(root, 1); 
	} 

	public static void main(String args[]) 
	{ 
		LeftView tree = new LeftView(); 
		tree.root = new Node(12); 
		tree.root.left = new Node(10); 
		tree.root.right = new Node(30); 
		tree.root.right.left = new Node(25); 
		tree.root.right.right = new Node(40); 

		tree.leftView(); 
	} 
} 
//algo
//We can keep track of the level of a node by passing a parameter to all recursive calls. 
//The idea is to keep track of the maximum level also. Whenever we see a node whose level is
//more than maximum level so far, we print the node because this is the first node in its level 
//(Note that we traverse the left subtree before right subtree). 