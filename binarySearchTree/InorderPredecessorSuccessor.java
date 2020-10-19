package binarySearchTree;



public class InorderPredecessorSuccessor 
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
    static Node pre=null,succ=null;
	InorderPredecessorSuccessor()
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
	void findPreSucc(Node root,int key)
	{
		if(root==null)
			return;
		if(root.data==key)
		{
			if(root.left!=null)
			{
				Node temp=root.left;
				while(temp.right!=null)
					temp=temp.right;
				pre=temp;
			}
			if(root.right!=null)
			{
				Node temp=root.right;
				while(temp.left!=null)
					temp=temp.left;
				succ=temp;
			}
			return;
		}
		if(key<root.data)
		{
			succ=root;
			findPreSucc(root.left,key);
		}
		else
		{
			pre=root;
			findPreSucc(root.right,key);
		}
	}
	public static void main(String args[])
	{
		InorderPredecessorSuccessor tree=new InorderPredecessorSuccessor();
			/* Let us create following BST 
        	50 
     	  /     \ 
    	30      70 
   	   /  \    /  \ 
 	  20   40  60   80 */
		tree.insert(50); 
		tree.insert(30); 
		tree.insert(20); 
		tree.insert(40); 
		tree.insert(70); 
		tree.insert(60); 
		tree.insert(80); 
		int key=65;
		tree.findPreSucc(tree.root,key);
		if(pre!=null)
			System.out.println("Predecessor to "+key+" is: "+pre.data);
		else
			System.out.println("No predecessor");
		if(succ!=null)
			System.out.println("Successor to "+key+" is: "+succ.data);
		else
			System.out.println("No successor");
	}
}
//algo
//Input: root node, key
//output: predecessor node, successor node
//
//1. If root is NULL
//      then return
//2. if key is found then
//    a. If its left subtree is not null
//        Then predecessor will be the right most 
//        child of left subtree or left child itself.
//    b. If its right subtree is not null
//        The successor will be the left most child 
//        of right subtree or right child itself.
//    return
//3. If key is smaller then root node
//        set the successor as root
//        search recursively into left subtree
//    else
//        set the predecessor as root
//        search recursively into right subtree