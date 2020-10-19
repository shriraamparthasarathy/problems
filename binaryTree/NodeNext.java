package binaryTree;
//Given a Binary tree and a key in the binary tree, find the node right to the given key. 
//If there is no node on right side, then return NULL. Expected time complexity is O(n)
//		where n is the number of nodes in the given binary tree.
//
//For example, consider the following Binary Tree. Output for 2 is 6, output for 4 is 5. 
//Output for 10, 6 and 5 is NULL.
//10 
/// \ 
//2	  6 
/// \   \ 
//8   4	 5  

import java.util.LinkedList;
import java.util.Queue;

public class NodeNext 
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
	node root;
	node nextRight(node root,int k) 
	{ 
		if(root==null)
			return null;
		Queue<node> q=new LinkedList<>();
		q.add(root);
		while(!q.isEmpty())
		{
			int count=q.size();
			while(count-->0)
			{
				node temp=q.poll();
				if(temp.data==k)
				{
					if(q.isEmpty()||count==0)
						return null;
					return q.peek();
				}
				if(temp.left!=null)
					q.add(temp.left);
				if(temp.right!=null)
					q.add(temp.right);
			}
		}
		return null;
	} 
	void test(node node, int k)  
    { 
        node nr = nextRight(root, k); 
        if (nr != null) 
            System.out.println("Next Right of " + k + " is " + nr.data); 
        else
            System.out.println("No next right node found for " + k); 
    } 

	public static void main(String[] args) 
	{ 
		NodeNext tree=new NodeNext();
		tree.root = new node(10); 
        tree.root.left = new node(2); 
        tree.root.right = new node(6); 
        tree.root.right.right = new node(5); 
        tree.root.left.left = new node(8); 
        tree.root.left.right = new node(4); 

		/* Constructed Binary tree is: 
			10 
		   / \ 
		  2	  6 
		 / \   \ 
		8   4	5  */
					
        tree.test(tree.root, 10); 
        tree.test(tree.root, 2); 
        tree.test(tree.root, 6); 
        tree.test(tree.root, 5); 
        tree.test(tree.root, 8); 
        tree.test(tree.root, 4); 
	} 
}
//algo level order traversing like the maxwidth program