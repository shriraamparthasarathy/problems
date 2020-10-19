package binarySearchTree2;

import java.util.Stack; 
class PrintCommonNodes
{ 

static class Node 
{ 
	int key; 
	Node left, right; 
} 

static Node newNode(int ele) 
{ 
	Node temp = new Node(); 
	temp.key = ele; 
	temp.left = null; 
	temp.right = null; 
	return temp; 
} 

static void printCommon(Node root1, Node root2) 
{ 
	
	Stack<Node> s1 = new Stack<Node> (); 
	Stack<Node> s2 = new Stack<Node> (); 
	while(true)
	{
		if(root1!=null)
		{
			s1.push(root1);
			root1=root1.left;
		}
		else if(root2!=null)
		{
			s2.push(root2);
			root2=root2.left;
		}
		else if(!s1.isEmpty()&&!s2.isEmpty())
		{
			root1=s1.peek();
			root2=s2.peek();
			if(root1.key==root2.key)
			{
				System.out.print(root1.key+" ");
				s1.pop();
				s2.pop();
				root1=root1.right;
				root2=root2.right;
			}
			else if(root1.key<root2.key)
			{
				s1.pop();
				root1=root1.right;
				root2=null;
			}
			else if(root1.key>root2.key)
			{
				s2.pop();
				root1=null;
				root2=root2.right;
			}
		}
		else
			break;
		
	}
} 

static void inorder(Node root) 
{ 
	if (root != null) 
	{ 
		inorder(root.left); 
		System.out.print(root.key + " "); 
		inorder(root.right); 
	} 
} 

static Node insert(Node node, int key) 
{ 
	if (node == null) return newNode(key); 
	if (key < node.key) 
		node.left = insert(node.left, key); 
	else if (key > node.key) 
		node.right = insert(node.right, key);  
	return node; 
} 

public static void main(String[] args) 
{ 
	Node root1 = null; 
	root1 = insert(root1, 5); 
	root1 = insert(root1, 1); 
	root1 = insert(root1, 10); 
	root1 = insert(root1, 0); 
	root1 = insert(root1, 4); 
	root1 = insert(root1, 7); 
	root1 = insert(root1, 9); 

	Node root2 = null; 
	root2 = insert(root2, 10); 
	root2 = insert(root2, 7); 
	root2 = insert(root2, 20); 
	root2 = insert(root2, 4); 
	root2 = insert(root2, 9); 

	System.out.print("Tree 1 : " + "\n"); 
	inorder(root1); 
	System.out.println(); 
	System.out.print("Tree 2 : " + "\n"); 
	inorder(root2); 
	System.out.println(); 
	System.out.println("Common Nodes: "); 

	printCommon(root1, root2); 

} 
} 
//algo
//We can find common elements in O(n) time and O(h1 + h2) extra space where h1 and h2 are 
//heights of first and second BSTs respectively.
//The idea is to use iterative inorder traversal. We use two auxiliary stacks for
//two BSTs. Since we need to find common elements, whenever we get same element, we print it.