package binaryTree4;

class KthAncestor 
{ 

static class Node 
{ 
	int data; 
	Node left, right; 
}; 

//temporary node to keep track of Node returned 
//from previous recursive call during backtrack 
static Node temp = null; 
static int k; 


static Node kthAncestorDFS(Node root, int node ) 
{ 
	if(root==null)
		return null;
	if(root.data==node||kthAncestorDFS(root.left,node)!=null||kthAncestorDFS(root.right,node)!=null)
	{
		if(k>0)
			k--;
		else if(k==0)
		{
			System.out.println("The ancestor is: "+root.data);
			return null;
		}
		return root;
	}
	return null;
} 

static Node newNode(int data) 
{ 
	Node temp = new Node(); 
	temp.data = data; 
	temp.left = temp.right = null; 
	return temp; 
} 

public static void main(String args[]) 
{ 
	Node root = newNode(1); 
	root.left = newNode(2); 
	root.right = newNode(3); 
	root.left.left = newNode(4); 
	root.left.right = newNode(5); 

	k = 2; 
	int node = 5; 

	Node parent = kthAncestorDFS(root,node); 
	

	if (parent != null) 
		System.out.println("-1"); 
} 
} 
//algo
//The idea of using DFS is to first find the given node in the tree, and then 
//backtrack k times to reach to kth ancestor, once we have reached to the kth parent,
//we will simply print the node and return NULL.

