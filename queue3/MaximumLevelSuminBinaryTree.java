package queue3;
import java.util.LinkedList;
import java.util.Queue;
//Given a Binary Tree having positive and negative nodes, the task is to find maximum sum level in
//it.
//
//Examples:
//
//Input :               4
//                    /   \
//                   2    -5
//                  / \    /\
//                -1   3 -2  6
//Output: 6
//Explanation :
//Sum of all nodes of 0'th level is 4
//Sum of all nodes of 1'th level is -3
//Sum of all nodes of 0'th level is 6
//Hence maximum sum is 6
//
//Input :          1
//               /   \
//             2      3
//           /  \      \
//          4    5      8
//                    /   \
//                   6     7  
//Output :  17
public class MaximumLevelSuminBinaryTree 
{
	static class Node
	{
		int data;
		Node left,right;
		Node(int data)
		{
			this.data=data;
			this.left=this.right=null;
		}
	};
	static int findMaxLevelSum(Node root)
	{
		Queue<Node> q=new LinkedList<>();
		if(root==null)
		{
			System.out.println("No nodes");
			return -1;
		}
		int res=root.data;
		q.add(root);
		while(!q.isEmpty())
		{
			int count=q.size();
			int sum=0;
			while(count-->0)
			{
				Node temp=q.poll();
				sum+=temp.data;
				if(temp.left!=null)
					q.add(temp.left);
				if(temp.right!=null)
					q.add(temp.right);
			}
			res=Math.max(res, sum);
		}
		return res;
	}
	public static void main(String args[])
	{
		Node root = new Node(1);  
	    root.left = new Node(2);  
	    root.right = new Node(3);  
	    root.left.left = new Node(4);  
	    root.left.right = new Node(5);  
	    root.right.right=new Node(8);
	    root.right.right.left=new Node(6);
	    root.right.right.right=new Node(7);
	    /*   Constructed Binary tree is: 
        1 
      /   \ 
    2      3 
  /  \      \ 
 4    5      8 
           /   \ 
          6     7    */
	    System.out.println("Maximum level sum: "+findMaxLevelSum(root));
	}
}
//algo
//This problem is a variation of maximum width problem. The idea is to do level order traversal
//of tree. While doing traversal, process nodes of different level separately. For every level
//being processed, compute sum of nodes in the level and keep track of maximum sum.