package binaryTree;
//Given a Binary Tree where each node has the following structure, write a function to
//populate the next pointer for all nodes. The next pointer for every node should be set
//to point to inorder successor.
//
//filter_none
//edit
//play_arrow
//
//brightness_4
//struct node 
//{ 
//  int data; 
//  struct node* left; 
//  struct node* right; 
//  struct node* next; 
//} 
//Initially, all next pointers have NULL values. Your function should fill these next
//pointers so that they point to inorder successor.
class InOrderSuccessorinBST 
{ 
	static class Node 
	{ 
		int data; 
		Node left, right, next; 

		Node(int item) 
		{ 
			data = item; 
			left = right = next = null; 
		} 
	}
	Node root; 
	Node next = null; 
	void populateNext(Node root)
	{
		populateNextRecurs(root);
	}
	void populateNextRecurs(Node p)
	{
		if(p!=null)
		{
			populateNextRecurs(p.right);
			p.next=next;
			next=p;
			populateNextRecurs(p.left);
		}	
	}
	public static void main(String args[]) 
	{ 
		/* Constructed binary tree is 
			10 
		/ \ 
		8	 12 
		/ 
		3 */
		InOrderSuccessorinBST tree = new InOrderSuccessorinBST(); 
		tree.root = new Node(10); 
		tree.root.left = new Node(8); 
		tree.root.right = new Node(12); 
		tree.root.left.left = new Node(3); 

		tree.populateNext(tree.root); 
		Node ptr = tree.root.left.left; 
		while (ptr != null) 
		{ 
			// -1 is printed if there is no successor 
			int print = ptr.next != null ? ptr.next.data : -1; 
			System.out.println("Next of " + ptr.data + " is: " + print); 
			ptr = ptr.next; 
		} 
	} 
} 
//algo
//Traverse the given tree in reverse inorder traversal and keep track of
//previously visited node. When a node is being visited, assign previously visited node as next.
