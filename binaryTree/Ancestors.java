package binaryTree;

//Given a Binary Tree and a key, write a function that prints all the ancestors of the key in the
//given binary tree.
//For example, if the given tree is following Binary Tree and key is 7, then your function 
//should print 4, 2 and 1.
//
//
//              1
//            /   \
//          2      3
//        /  \
//      4     5
//     /
//    7
class Ancestors 
{
 
	static class Node 
	{ 
		int data; 
		Node left, right, nextRight; 

		Node(int item) 
		{ 
			data = item; 
			left = right = nextRight = null; 
		} 
	} 
	Node root; 


	boolean printAncestors(Node node, int target) 
	{ 
		if(node==null)
			return false;
		if(node.data==target)
			return true;
		if(printAncestors(node.left,target)||printAncestors(node.right,target))
		{
			System.out.print(node.data+" ");
			return true;
		}
		return false;
	} 

	public static void main(String args[]) 
	{ 
		Ancestors tree = new Ancestors(); 
		
		/* Construct the following binary tree 
				1 
				/ \ 
			2	 3 
			/ \ 
			4 5 
			/ 
		7 
		*/
		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
		tree.root.left.left = new Node(4); 
		tree.root.left.right = new Node(5); 
		tree.root.left.left.left = new Node(7); 

		tree.printAncestors(tree.root, 7); 

	} 
} 

