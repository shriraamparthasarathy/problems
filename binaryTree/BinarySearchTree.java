package binaryTree;

public class BinarySearchTree
{
	class Node
	{
		int data;
		Node left,right;
		Node(int data)
		{
			this.data=data;
			left=right=null;
		}
	}
	Node root;
	BinarySearchTree()
	{
		root=null;
	}
	void insert(int x)
	{
		root=insertElement(root,x);
	}
	Node insertElement(Node root,int x)
	{
		if(root==null)
		{
			root=new Node(x);
			return root;
		}
		if(x<root.data)
			root.left=insertElement(root.left,x);
		else
			root.right=insertElement(root.right,x);
		return root;
	}
	void inorder()
	{
		inOrder(root);
	}
	void inOrder(Node root)
	{
		if(root!=null)
		{
			inOrder(root.left);
			System.out.print(root.data+" ");
			inOrder(root.right);
		}
	}
	void deleteTree()
	{
		root=null;
	}
	void delete(Node noderef)
	{
		deleteTree();
		noderef=null;
	}
	int diameter()
	{
		return diameter(root);
	}
	int diameter(Node root)
	{
		if(root==null)
			return 0;
		int lheight=height(root.left);
		int rheight=height(root.right);
		int ldiameter=diameter(root.left);
		int rdiameter=diameter(root.right);
		return Math.max(lheight+rheight, Math.max(ldiameter, rdiameter));
	}
	int height(Node node)
	{
		if(node==null)
			return 0;
		return(1+Math.max(height(node.left), height(node.right)));
	}
	void printPaths()
	{
		int path[]=new int[100];
		printPathsRecurs(root,path,0);
	}
	void printPathsRecurs(Node node,int path[],int len)
	{
		if(node==null)
			return;
		path[len]=node.data;
		len++;
		if(node.left==null&&node.right==null)
			printArray(path,len);
		else
		{
			printPathsRecurs(node.left,path,len);
			printPathsRecurs(node.right,path,len);
		}
	}
	void printArray(int temp[],int len)
	{
		for(int i=0;i<len;i++)
			System.out.print(temp[i]+" ");
		System.out.println();
	}
	public static void main(String[] args)
	{ 
		BinarySearchTree tree = new BinarySearchTree(); 

		/* Let us create following BST 
		  50 
		/	 \ 
	   30	 70 
	  / \    / \ 
	 20 40  60 80 */
		tree.insert(50); 
		tree.insert(30); 
		tree.insert(20); 
		tree.insert(40); 
		tree.insert(70); 
		tree.insert(60); 
		tree.insert(80); 

		// print inorder traversal of the BST 
		tree.inorder(); 
		System.out.println("\nDiameter of the tree is:"+tree.diameter());
		tree.printPaths();
		tree.delete(tree.root);
		System.out.println("Tree is deleted");
	} 
}
//algo

//delete a tree: deleting the root and a reference to that root will remove the tree in 
//java as the others will be taken care by the java garbage collector

//diameter of the tree: Find the largest between diameter of left, diameter of right and
//sum left height and right height and 1
//diameter is the longest path in the tree

//Path from root to leaves: 
//Use a path array path[] to store current root to leaf path. Traverse from
//root to all leaves in top-down fashion. While traversing, store data of all
//nodes in current path in array path[]. When we reach a leaf node, print the path array.


//understanding of the path from root to leaves program
//the elements are not getting appending they getting over written on the same path array !!! A simple dry run will make you understand this. Let me explain you with the example given here :-
//10
/// \
//8 2
/// \ /
//3 5 2
//The first function call:
//printPathrecur(10, {}, 0) // i will represent array in brackets so that you will understand how it changes :)
//path[0] = 10; //{10}
//printPathrecur(8, {10}, 1)
//path[1] = 8; // {10, 8}
//printPathRecur{3, {10, 8}, 2)
//path[2] = 3; // {10, 8, 3}
//pathLen = 3;
//// now array gets printed :- 10 8 3
////backTracks to previous call
//printPathRecur{5, {10, 8, 3}, 2)
//path[2] = 5; // {10, 8, 5} here is where your doubt gets cleared. we can see that 5 overwrites 3 Giving us
//the path we required
//pathLen = 3;
////now array gets printed :- 10 8 5
//printPathRecur{2, {10, 8, 5}, 1}
//path[1] = 2; // {10, 2, 5} here 2 overwrites 8
//pathLen = 2; // what if two is a leafNode.. now we will print path array but upto the length given in the
//pathLen so the output will be :- 10 2
//printPathRecur{2, {10, 2, 5}, 2}
//path[2] = 2;
//pathLen = 3;
//// now the array gets printed:- 10 2 2
