package binaryTree2;
//Initially, all the nextRight pointers point to garbage values. Your function should set these 
//pointers to point next right for each node.
//
//Example:
//
//Input Tree
//       A
//      / \
//     B   C
//    / \   \
//   D   E   F
//
//
//Output Tree
//       A--->NULL
//      / \
//     B-->C-->NULL
//    / \   \
//   D-->E-->F-->NULL
import java.util.LinkedList;
import java.util.Queue;


public class ConnectRightNodes 
{
	static class node 
	{ 
		int data; 
		node left, right; 
		node next;

		public node(int data) 
		{ 
			this.data = data; 
		} 
	} 
	node root;
	void connectRight(node root) 
	{ 
		if(root==null)
			return;
		Queue<node> q=new LinkedList<>();
		q.add(root);
		while(!q.isEmpty())
		{
			int count=q.size();
			while(count-->0)
			{
				node temp=q.poll();
				if(count==0||q.isEmpty())
					temp.next=null;
				else
					temp.next=q.peek();
				if(temp.left!=null)
					q.add(temp.left);
				if(temp.right!=null)
					q.add(temp.right);
			}
		}
	} 
	

	public static void main(String[] args) 
	{ 
		ConnectRightNodes tree=new ConnectRightNodes();
		tree.root = new node(10); 
        tree.root.left = new node(8); 
        tree.root.right = new node(2); 
        tree.root.left.left = new node(3); 

		/* Constructed Binary tree is: 
			10 
		   / \ 
		  8	  2 
		 /     
		3       */
        tree.connectRight(tree.root);
        System.out.println("Following are populated nextRight pointers in "
                + "the tree"
                + "(-1 is printed if there is no nextRight)"); 
        int a = tree.root.next != null ? tree.root.next.data : -1; 
        System.out.println("nextRight of " + tree.root.data + " is "
                           + a); 
        int b = tree.root.left.next != null ? tree.root.left.next.data : -1; 
        System.out.println("nextRight of " + tree.root.left.data + " is "
                           + b); 
        int c = tree.root.right.next != null ? tree.root.right.next.data : -1; 
        System.out.println("nextRight of " + tree.root.right.data + " is "
                           + c); 
        int d = tree.root.left.left.next != null ? tree.root.left.left.next.data : -1; 
        System.out.println("nextRight of " + tree.root.left.left.data + " is "
                           + d);      
        
	} 
}
//algo time complexity O(n)
//using level order traversal we connect the next node in the same level