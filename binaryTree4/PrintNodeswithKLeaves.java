package binaryTree4;
//Given a binary tree and a integer value K, the task is to find all nodes in given 
//binary tree having K leaves in subtree rooted with them.

class PrintNodeswithKLeaves
{ 

static class Node 
{ 
	int data ; 
	Node left, right ; 
	Node(int data) 
	{ 
		this.data = data; 
	} 
	Node() 
	{ 
		
	} 
} 


static Node newNode(int data) 
{ 
	Node node = new Node(); 
	node.data = data; 
	node.left = null; 
	node.right = null; 
	return (node); 
} 


static int kLeaves(Node ptr,int k) 
{ 
	if(ptr==null)
		return 0;
	if(ptr.left==null&&ptr.right==null)
		return 1;
	int total=kLeaves(ptr.left,k)+kLeaves(ptr.right,k);
	if(total==k)
		System.out.print(ptr.data+" ");
	return total;
} 

public static void main(String[] args) 
{ 
	Node root = newNode(1); 
	root.left	 = newNode(2); 
	root.right	 = newNode(4); 
	root.left.left = newNode(5); 
	root.left.right = newNode(6); 
	root.left.left.left = newNode(9); 
	root.left.left.right = newNode(10); 
	root.right.right = newNode(8); 
	root.right.left = newNode(7); 
	root.right.left.left = newNode(11); 
	root.right.left.right = newNode(12); 

	kLeaves(root, 2); 

} 
} 
//algo
//Here any node having K leaves means sum of leaves in left subtree and in right subtree
//must be equal to K. So to solve this problem we use Postorder traversal of tree. First 
//we calculate leaves in left subtree then in right subtree and if sum is equal to K, then 
//print current node. In each recursive call we return sum of leaves of left subtree and right
//		subtree to it’s ancestor.