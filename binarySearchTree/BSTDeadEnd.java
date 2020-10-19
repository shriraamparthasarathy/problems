package binarySearchTree;
import java.util.HashSet;

//Given a Binary search Tree that contains positive integer values greater then 0. The task is 
//to check whether the BST contains a dead end or not. Here Dead End means, we are not able to
//insert any element after that node.
//
//Examples:
//
//Input :        8
//             /   \ 
//           5      9
//         /   \
//        2     7
//       /
//      1               
//Output : Yes
//Explanation : Node "1" is the dead End because
//         after that we cant insert any element.       
//
//Input :       8
//            /   \ 
//           7     10
//         /      /   \
//        2      9     13
//
//Output : Yes
//Explanation : We can't insert any element at 
//              node 9.  
public class BSTDeadEnd
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
	BSTDeadEnd()
	{
		this.root=null;
	}
	void insert(int d)
	{
		root=insertRec(root,d);
	}
	Node insertRec(Node root,int d)
	{
		if(root==null)
		{
			root=new Node(d);
			return root;
		}
		if(d<root.data)
			root.left=insertRec(root.left,d);
		else if(d>root.data)
			root.right=insertRec(root.right,d);
		return root;
	}

	void storeElements(Node root,HashSet<Integer> all,HashSet<Integer> leaf)
	{
		if(root==null)
			return;
		all.add(root.data);
		if(root.left==null&&root.right==null)
			leaf.add(root.data);
		storeElements(root.left,all,leaf);
		storeElements(root.right,all,leaf);
	}
	boolean isDeadEnd(Node root)
	{
		if(root==null)
			return false;
		HashSet<Integer> all=new HashSet<>();
		HashSet<Integer> leaf=new HashSet<>();
		all.add(0);// since we need to check x-1 for leaf, if 1 is in leaf, x-1 =0 which will not be present in positive non zero integer
		storeElements(root,all,leaf);
		System.out.println(all.toString()+"\n"+leaf.toString());
		for(int x:leaf)
		{
			if(all.contains(x-1)&&all.contains(x+1))
				return true;
		}
		return false;
	}
	public static void main(String args[])
	{
		BSTDeadEnd tree=new BSTDeadEnd();
//			8
//        /   \ 
//      5      9
//    /   \
//   2     7
//  /
// 1              
		tree.insert(8); 
		tree.insert(5); 
		tree.insert(9); 
		tree.insert(2); 
		tree.insert(1); 
		tree.insert(7); 
		if(tree.isDeadEnd(tree.root))
			System.out.println("Dead End is present");
		else
			System.out.println("There is no dead end");
	}
}
//algo
//If we take a closer look at problem, we can notice that we basically need to check if there
//is leaf node with value x such that x+1 and x-1 exist in BST with exception of x = 1. For x = 1,
//we can’t insert 0 as problem statement says BST contains positive integers only.
//
//To implement above idea we first traverse whole BST and store all nodes in a hash_map. We also 
//store all leaves in a separate hash to avoid re-traversal of BST. Finally we check for every leaf
//node x, if x-1 and x+1 are present in hash_map or not.