package binarySearchTree2;
 
import java.util.Stack; 


class IterativeInOrder 
{ 
	static class Node 
	{ 
		int data; 
		Node left, right; 

		public Node(int item) 
		{ 
			data = item; 
			left = right = null; 
		} 
	} 

	Node root; 
	void inorder() 
	{ 
		if(root==null)
			return;
		Stack<Node> s=new Stack<>();
		Node curr=root;
		while(curr!=null||s.size()>0)
		{
			while(curr!=null)
			{
				s.push(curr);
				curr=curr.left;
			}
			curr=s.pop();
			System.out.print(curr.data+" ");
			curr=curr.right;
		}
	} 

	public static void main(String args[]) 
	{ 

		/* creating a binary tree and entering 
		the nodes */
		IterativeInOrder tree = new IterativeInOrder(); 
		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
		tree.root.left.left = new Node(4); 
		tree.root.left.right = new Node(5); 
		tree.inorder(); 
	} 
} 
//algo
//1) Create an empty stack S.
//2) Initialize current node as root
//3) Push the current node to S and set current = current->left until current is NULL
//4) If current is NULL and stack is not empty then 
//     a) Pop the top item from stack.
//     b) Print the popped item, set current = popped_item->right 
//     c) Go to step 3.
//5) If current is NULL and stack is empty then we are done.