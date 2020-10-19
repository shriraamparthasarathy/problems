package binaryHeap;
import java.util.Vector;
//Given a binary search tree which is also a complete binary tree. The problem is to convert the
//given BST into a Min Heap with the condition that all the values in the left subtree of a node
//should be less than all the values in the right subtree of the node. This condition is applied
//on all the nodes in the so converted Min Heap.
//
//Examples:
//
//Input :          4
//               /   \
//              2     6
//            /  \   /  \
//           1   3  5    7  
//
//Output :        1
//              /   \
//             2     5
//           /  \   /  \
//          3   4  6    7 
//
//The given BST has been transformed into a
//Min Heap.
//All the nodes in the Min Heap satisfies the given
//condition, that is, values in the left subtree of
//a node should be less than the values in the right
//subtree of the node. 
public class BSTtoMinHeap
{
	static class Node
	{
		int data;
		Node left,right;
	}
	static int i=0;
	static Node getNode(int data) 
	{ 
	    Node newNode = new Node(); 
	    newNode.data = data; 
	    newNode.left = newNode.right = null; 
	    return newNode; 
	} 
	static void inOrder(Vector<Integer> arr,Node root)
	{
		if(root!=null)
		{
			inOrder(arr,root.left);
			arr.add(root.data);
			inOrder(arr,root.right);
		}
	}
	static void bsttoMinHeapConv(Vector <Integer> arr,Node root)
	{
		if(root==null)
			return;
		root.data=arr.get(i);
		i++;
		bsttoMinHeapConv(arr,root.left);
		bsttoMinHeapConv(arr,root.right);
	}
	static void convertToMinHeapUtil(Node root)
	{
		Vector<Integer> arr=new Vector<>();
		inOrder(arr,root);
		System.out.println(arr.toString());
		bsttoMinHeapConv(arr,root);
	}
	static void preOrder(Node root)
	{
		if(root==null)
			return;
		System.out.print(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
	}
	public static void main(String args[])
	{
		Node root = getNode(4); 
	    root.left = getNode(2); 
	    root.right = getNode(6); 
	    root.left.left = getNode(1); 
	    root.left.right = getNode(3); 
	    root.right.left = getNode(5); 
	    root.right.right = getNode(7); 
	    preOrder(root);
	    System.out.println();
	    convertToMinHeapUtil(root); 
	    System.out.println("PreorderTraversal"); 
	    preOrder(root); 
	}
}
//algo
//Create an array arr[] of size n, where n is the number of nodes in the given BST.
//Perform the inorder traversal of the BST and copy the node values in the arr[] in sorted order.
//Now perform the preorder traversal of the tree.
//While traversing the root during the preorder traversal, one by one copy the values from
//the array arr[] to the nodes.