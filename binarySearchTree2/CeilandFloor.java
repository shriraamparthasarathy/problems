package binarySearchTree2;


public class CeilandFloor 
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
    CeilandFloor()
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
			pre=succ=root;
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
		CeilandFloor tree=new CeilandFloor();
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
		int key=60;
		tree.findPreSucc(tree.root,key);
		if(pre!=null)
			System.out.println("Floor to "+key+" is: "+pre.data);
		else
			System.out.println("No Floor");
		if(succ!=null)
			System.out.println("Ceil to "+key+" is: "+succ.data);
		else
			System.out.println("No Ceil");
	}
}
//algo
//same as fiding predecessor and successor except
//when the key is present the ceil and floor will be the key