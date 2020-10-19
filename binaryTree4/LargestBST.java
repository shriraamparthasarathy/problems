package binaryTree4;
//Given a Binary Tree, write a function that returns the size of the largest subtree which is
//also a Binary Search Tree (BST). If the complete Binary Tree is BST, then return the size
//		of the whole tree.
//Examples:
//
//Input: 
//      5
//    /  \
//   2    4
// /  \
//1    3
//
//Output: 3 
//The following subtree is the 
//maximum size BST subtree 
//   2  
// /  \
//1    3
//
//
//Input: 
//       50
//     /    \
//  30       60
// /  \     /  \ 
//5   20   45    70
//              /  \
//            65    80
//Output: 5
//The following subtree is the
//maximum size BST subtree 
//      60
//     /  \ 
//   45    70
//        /  \
//      65    80
public class LargestBST 
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
	// Information to be returned by every 
	// node in bottom up traversal. 
	static class Info
	{
		int siz;// Size of subtree 
		int max;// Min value in subtree 
		int min; // Max value in subtree
		int ans;// Size of largest BST which is subtree of current node 
		boolean isBST;// If subtree is BST 
		Info(int size,int max,int min,int ans,boolean isBST)
		{
			this.siz=size;
			this.max=max;
			this.min=min;
			this.ans=ans;
			this.isBST=isBST;
		}
		Info()
		{
			this.siz=0;
			this.max=0;
			this.min=0;
			this.ans=0;
			this.isBST=false;
		}
		
	}
	Node root;
	Info largestBSTBT(Node node)
	{
		if(node==null)
			return new Info(0,Integer.MIN_VALUE,Integer.MAX_VALUE,0,true);
		if(node.left==null&&node.right==null)
			return new Info(1,node.data,node.data,1,true);
		Info l=largestBSTBT(node.left);
		Info r=largestBSTBT(node.right);
		Info ret=new Info();
		ret.siz=1+l.siz+r.siz;
		// If whole tree rooted under current root is 
	    // BST. 
		if(l.isBST&&r.isBST&&l.max<node.data&&r.min>node.data)
		{
			// Update answer for tree rooted under 
	        // current 'root' 
			ret.min=Math.min(l.min, Math.min(r.min, node.data));
			ret.max=Math.max(r.max, Math.max(l.max, node.data));
			ret.ans=ret.siz;
			ret.isBST=true;
			return ret;
		}
		// If whole tree is not BST, return maximum 
	    // of left and right subtrees 
		ret.ans=Math.max(l.ans, r.ans);
		ret.isBST=false;
		return ret;
	}
	public static void main(String args[])
	{
		LargestBST tree=new LargestBST();
		tree.root=new Node(60);
		tree.root.left=new Node(65);
		tree.root.right=new Node(70);
		tree.root.left.left=new Node(50);
//					60
//				   /   \
//				  65  	 70
//			     /
//			    50 
		System.out.println("Largest BST size: "+tree.largestBSTBT(tree.root).ans);
	}
}
//algo
//A Tree is BST if following is true for every node x.
//
//The largest value in left subtree (of x) is smaller than value of x.
//The smallest value in right subtree (of x) is greater than value of x.