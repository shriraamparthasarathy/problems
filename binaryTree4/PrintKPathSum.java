package binaryTree4;
//A binary tree and a number k are given. Print every path in the tree with sum of the nodes in the
//path as k.
//A path can start from any node and end at any node and must be downward only, i.e.
//they need not be root node and leaf node; and negative numbers can also be there in the tree.
//
//Examples:
//
//Input : k = 5  
//        Root of below binary tree:
//           1
//        /     \
//      3        -1
//    /   \     /   \
//   2     1   4     5                        
//        /   / \     \                    
//       1   1   2     6    
//                       
//Output :
//3 2 
//3 1 1 
//1 3 1 
//4 1 
//1 -1 4 1 
//-1 4 2 
//5 
//1 -1 5 

import java.util.Vector; 

class PrintKPathSum 
{ 

static void printVector( Vector<Integer> v, int i) 
{ 
	for (int j = i; j < v.size(); j++) 
		System.out.print( v.get(j) + " "); 
		System.out.println(); 
} 

static class Node 
{ 
	int data; 
	Node left,right; 
	Node(int x) 
	{ 
		data = x; 
		left = right = null; 
	} 
}; 
static Vector<Integer> path = new Vector<Integer>(); 

static void printKPathUtil(Node root, int k) 
{ 
	if(root==null)
		return;
	path.add(root.data);
	printKPathUtil(root.left,k);
	printKPathUtil(root.right,k);
	int f=0;
	for(int j=path.size()-1;j>=0;j--)
	{
		f+=path.get(j);
		if(f==k)
			printVector(path,j);
	}
	path.remove(path.size()-1);
} 

static void printKPath(Node root, int k) 
{ 
	path = new Vector<Integer>(); 
	printKPathUtil(root, k); 
} 


public static void main(String args[]) 
{ 
	Node root = new Node(1); 
	root.left = new Node(3); 
	root.left.left = new Node(2); 
	root.left.right = new Node(1); 
	root.left.right.left = new Node(1); 
	root.right = new Node(-1); 
	root.right.left = new Node(4); 
	root.right.left.left = new Node(1); 
	root.right.left.right = new Node(2); 
	root.right.right = new Node(5); 
	root.right.right.right = new Node(2); 

	int k = 5; 
	printKPath(root, k); 
} 
} 
//algo 
//this problem is significantly different from finding k-sum path from root to leaves.
//Here each node can be treated as root, hence the path can start and end at any node.
//The basic idea to solve the problem is to do a preorder traversal of the given tree.
//We also need a container (vector) to keep track of the path that led to that node.
//At each node we check if there are any path that sums to k, if any we print the path and
//proceed recursively to print each path.