package binarySearchTree;
//A binary search tree (BST) is a node based binary tree data structure which has the following
//properties.
//• The left subtree of a node contains only nodes with keys less than the node’s key.
//• The right subtree of a node contains only nodes with keys greater than the node’s key.
//• Both the left and right subtrees must also be binary search trees.
//
//From the above properties it naturally follows that:
//• Each node (item in the tree) has a distinct key.
public class CheckBST 
{
	static class Node
	{
		int data;
		Node left,right;
		Node(int d)
		{
			this.data=d;
			this.left=this.right=null;
		}
	}
	Node root;
	CheckBST()
	{
		this.root=null;
	}
	boolean isBST(Node root,Node l,Node r)
	{
		if(root==null)
			return true;
		if(l!=null&&root.data<=l.data)
			return false;
		if(r!=null&&root.data>=r.data)
			return false;
		return isBST(root.left,l,root)&& isBST(root.right,root,r);
	}
	public static void main(String args[]) 
	{  
		CheckBST tree=new CheckBST();
	    tree.root = new Node(3);  
	    tree.root.left = new Node(2);  
	    tree.root.right = new Node(5);  
	    tree.root.left.left = new Node(1);  
	    tree.root.left.right = new Node(4);  
	  
	    if (tree.isBST(tree.root,null,null))  
	        System.out.print("Is BST");  
	    else
	        System.out.print("Not a BST");  
	} 
}
//algo
//The trick is to write a utility helper function isBSTUtil(struct node* node, int min, int max) 
//that traverses down the tree keeping track of the narrowing min and max allowed values as it
//goes, looking at each node only once. The initial values for min and max should be INT_MIN and
//INT_MAX — they narrow from there.
//We can simplify above method  using NULL pointers instead of INT_MIN and INT_MAX values.