package binaryTree3;
//Given a binary tree, delete a node from it by making sure that tree shrinks from the bottom 
//(i.e. the deleted node is replaced by bottom most and rightmost node). This different from BST
//deletion. Here we do not have any order among elements, so we replace with last element.
//
//Examples :
//
//Delete 10 in below tree
//       10
//     /    \         
//    20     30
//Output :    
//       30
//     /             
//    20     
//
//
//Delete 20 in below tree
//       10
//     /    \         
//    20     30
//            \
//            40
//Output :    
//       10
//     /   \             
//    40    30   
import java.util.LinkedList;
import java.util.Queue;


public class DeletioninBtRightMost 
{ 
	
	static class node 
	{ 
		int data; 
		node left, right; 

		public node(int data) 
		{ 
			this.data = data; 
		} 
	} 
	static void deleteDeepest(node root,node value)
	{
		Queue<node> q=new LinkedList<>();
		q.add(root);
		while(!q.isEmpty())
		{
			node temp=q.poll();
			if(temp==value)
			{
				temp=null;
				return;
			}	
			if(temp.right!=null)
			{
				if(temp.right==value)
				{
					temp.right=null;
					return;
				}
				else
					q.add(temp.right);
			}
			if(temp.left!=null)
			{
				if(temp.left==value)
				{
					temp.left=null;
					return;
				}
				else
					q.add(temp.left);
			}	
			
		}
	}
	static node delete(node root,int data) 
	{ 
		if(root==null)
			return null;
		if(root.left==null&&root.right==null)
			return root;
		Queue<node> q=new LinkedList<>();
		q.add(root);
		node temp=null,key_node=null;
		while(!q.isEmpty())
		{
			temp=q.poll();
			if(temp.data==data)
				key_node=temp;
			if(temp.left!=null)
				q.add(temp.left);
			if(temp.right!=null)
				q.add(temp.right);
		}
		if(key_node!=null)
		{
			int x=temp.data;
			deleteDeepest(root,temp); // to delete the deepest right value from tree
			key_node.data=x;
		}
		return root;
	} 
	static void inorder(node curr)
	{
		if(curr==null)
			return;
		inorder(curr.left);
		System.out.print(curr.data+" ");
		inorder(curr.right);
	}
	public static void main(String[] args) 
	{ 
		node root = new node(10); 
		root.left = new node(11); 
		root.right = new node(9); 
		root.left.left = new node(7); 
		root.left.right = new node(12); 
		root.right.right = new node(8); 
		root.right.left = new node(15); 
		inorder(root);
 

		int data=11;			
		root=delete(root,data);
		System.out.println("\nAfter deletion");
		inorder(root);
	} 
} 
//algo
//1. Starting at root, find the deepest and rightmost node in binary tree and node which we 
//want to delete.
//2. Replace the deepest rightmost node’s data with node to be deleted.
//3. Then delete the deepest rightmost node.