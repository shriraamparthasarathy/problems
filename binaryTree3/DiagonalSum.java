package binaryTree3;

import java.util.HashMap;
import java.util.Map.Entry;


public class DiagonalSum
{ 
	static class Node
	{ 
		int data; 
		Node left; 
		Node right; 
		
		Node(int data) 
		{ 
			this.data=data; 
			left = null; 
			right =null; 
		} 
	} 
	
	/* root - root of the binary tree 
	d - distance of current line from rightmost 
			-topmost slope. 
	diagonalPrint - HashMap to store Diagonal 
					elements (Passed by Reference) */
	static void diagonalPrintUtil(Node root,int d, HashMap<Integer,Integer> diagonalPrint)
	{ 
		if(root==null)
			return;
		int k=diagonalPrint.get(d)!=null?diagonalPrint.get(d):0;
		diagonalPrint.put(d,k+root.data);
		diagonalPrintUtil(root.left,d+1,diagonalPrint);
		diagonalPrintUtil(root.right,d,diagonalPrint);
	} 
	
	static void diagonalPrint(Node root) 
	{ 
		
		HashMap<Integer,Integer> diagonalPrint = new HashMap<>(); 
		diagonalPrintUtil(root, 0, diagonalPrint); 
		
		System.out.println("Diagonal Traversal of Binnary Tree"); 
		for (Entry<Integer, Integer> entry : diagonalPrint.entrySet()) 
		{ 
			System.out.println(entry.getValue()); 
		} 
	} 
	
	public static void main(String[] args) { 
		
		Node root = new Node(8); 
		root.left = new Node(3); 
		root.right = new Node(10); 
		root.left.left = new Node(1); 
		root.left.right = new Node(6); 
		root.right.right = new Node(14); 
		root.right.right.left = new Node(13); 
		root.left.right.left = new Node(4); 
		root.left.right.right = new Node(7); 
		
		diagonalPrint(root); 
	} 
} 
//algo
//diagonal traverse and add the numbers and store them in a map