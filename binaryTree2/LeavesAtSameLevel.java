package binaryTree2;

import java.util.*; 



class LeavesAtSameLevel 
{ 
	static class Node
	{ 
		int data; 
		Node left, right; 
		Node(int key) 
		{ 
			this.data = key; 
			left = right = null; 
		} 
	} 

	static boolean checkLevelLeafNode(Node root) 
	{ 
			if(root==null)
				return true;
			Queue<Node> q=new LinkedList<>();
			q.add(root);
			int result=Integer.MIN_VALUE,level=0;
			while(!q.isEmpty())
			{
				int size=q.size();
				level++;
				while(size-->0)
				{
					Node temp=q.poll();
					if(temp.left!=null)
					{
						q.add(temp.left);
						if(temp.left.left==null&&temp.left.right==null)
						{
							if(result==Integer.MIN_VALUE)
								result=level;
							else if(result!=level)
								return false;
						}
					}
					if(temp.right!=null)
					{
						q.add(temp.right);
						if(temp.right.left==null&&temp.right.right==null)
						{
							if(result==Integer.MIN_VALUE)
								result=level;
							else if(result!=level)
								return false;
						}
					}
				}
			}
			return true;
	} 

	public static void main(String args[]) 
	{ 
			// construct a tree 
			Node root = new Node(1); 
			root.left = new Node(2); 
			root.right = new Node(3); 
			root.left.right = new Node(4); 
			root.right.left = new Node(5); 
			root.right.right = new Node(6); 

			boolean result = checkLevelLeafNode(root); 
			if (result == true) 
				System.out.println("All leaf nodes are at same level"); 
			else
				System.out.println("Leaf nodes not at same level"); 
	} 
} 
//algo
//The idea is to iteratively traverse the tree, and when you encounter the first leaf node,
//store it’s level in result variable, now whenever you encounter any leaf node, compare it’s 
//level with previously stored result, it they are same then proceed for rest of the tree, else 
//	return false.