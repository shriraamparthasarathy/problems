package binarySearchTree;
//Given a Binary Tree, convert it to a Binary Search Tree. The conversion must be done in such a 
//way that keeps the original structure of Binary Tree.
//Examples.
//
//Example 1
//Input:
//          10
//         /  \
//        2    7
//       / \
//      8   4
//Output:
//          8
//         /  \
//        4    10
//       / \
//      2   7
//
//
//Example 2
//Input:
//          10
//         /  \
//        30   15
//       /      \
//      20       5
//Output:
//          15
//         /  \
//       10    20
//       /      \
//      5        30
import java.util.Arrays;

public class BTtoBST 
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
	static int iterator=0;// a static iterator variable to iterate in a recursive function
	
	BTtoBST()
	{
		this.root=null;
	}
	
	void inorder()
	{
		inOrderRec(root);
	}
	void inOrderRec(Node root)
	{
		if(root!=null)
		{
			inOrderRec(root.left);
			System.out.print(root.data+" ");
			inOrderRec(root.right);
		}
	}
	int countNodes(Node root)
	{
		if(root==null)
			return 0;
		return countNodes(root.left) + countNodes(root.right)+1;
	}
	void inOrderStore(Node root,int arr[]) //stores the Inorder traversal of binary tree in array
	{
		if(root==null)
			return;
		inOrderStore(root.left,arr);
		arr[iterator]=root.data;
		iterator++;
		inOrderStore(root.right,arr);
	}
	void arrayToBST(Node root,int arr[]) //stores the sorted array values in the binary tree(makes it BST)
	{
		if(root==null)
			return;
		arrayToBST(root.left,arr);
		root.data=arr[iterator];
		iterator++;
		arrayToBST(root.right,arr);
	}
	void convertBTtoBST(Node root)
	{
		if(root==null)
			return;
		int n=countNodes(root);
		int arr[]=new int[n];
		inOrderStore(root,arr);
		Arrays.sort(arr);
		iterator=0;
		arrayToBST(root,arr);
	}
	public static void main(String args[])
	{
		BTtoBST tree=new BTtoBST();
		tree.root=new Node(10);
		tree.root.left=new Node(30);
		tree.root.left.left=new Node(20);
		tree.root.right=new Node(15);
		tree.root.right.right=new Node(5);
		tree.inorder();
		tree.convertBTtoBST(tree.root);
		System.out.println("\nAFter conversion:");
		tree.inorder();
	}
	
}
//algo
//1. Counting nodes to find the size of array : O(n)
//2. Populating the array using inOrderTraversal: O(n)
//3. Sorting the array: O(nlogn)
//4. Creating the BST using inOrderTraversal: O(n)
//
//Overall complexity: O(n) + O(n) + O(nlogn)+ O(n)
//= O(nlogn)

//MAIN ALGO
//Following is a 3 step solution for converting Binary tree to Binary Search Tree.
//1) Create a temp array arr[] that stores inorder traversal of the tree. This step takes O(n) time.
//2) Sort the temp array arr[]. Time complexity of this step depends upon the sorting algorithm. 
//In the following implementation, Quick Sort is used which takes (n^2) time. This can be done in 
//O(nLogn) time using Heap Sort or Merge Sort.
//3) Again do inorder traversal of tree and copy array elements to tree nodes one by one. This
//step takes O(n) time.
