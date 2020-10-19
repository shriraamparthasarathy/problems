package binarySearchTree2;


class MedianofBST
{ 

static class Node 
{ 
	int data; 
	Node left, right; 
} 

static Node newNode(int item) 
{ 
	Node temp = new Node(); 
	temp.data = item; 
	temp.left = null; 
	temp.right = null; 
	return temp; 
} 

static Node insert(Node node, int key) 
{ 

	if (node == null) return newNode(key); 

	if (key < node.data) 
		node.left = insert(node.left, key); 
	else if (key > node.data) 
		node.right = insert(node.right, key); 
	return node; 
} 

static int counNodes(Node root) 
{ 
	Node current, prev; 
	int count = 0; 

	if (root == null) 
		return count; 
	current=root;
	while(current!=null)
	{
		if(current.left==null)
		{
			count++;
			current=current.right;
		}
		else
		{
			prev=current.left;
			while(prev.right!=null&&prev.right!=current)
				prev=prev.right;
			if(prev.right==null)
			{
				prev.right=current;
				current=current.left;
			}
			else
			{
				prev.right=null;
				count++;
				current=current.right;
			}
		}
	}
	return count;
} 



static int findMedian(Node root) 
{ 
if (root == null) 
		return 0; 

	int count = counNodes(root); 
	int currCount = 0; 
	Node current = root, pre = null, prev = null; 

	while (current != null) 
	{ 
		if (current.left == null) 
		{ 
			currCount++;  
			// Odd case 
			if (count % 2 != 0 && currCount == (count+1)/2) 
				return prev.data; 

			// Even case 
			else if (count % 2 == 0 && currCount == (count/2)+1) 
				return (prev.data + current.data)/2;
			prev = current; 
			current = current.right; 
		} 
		else
		{ 
			pre = current.left; 
			while (pre.right != null && pre.right != current) 
				pre = pre.right; 
			if (pre.right == null) 
			{ 
				pre.right = current; 
				current = current.left; 
			} 
			else
			{ 
				pre.right = null; 
				prev = pre; 
				currCount++; 
				if (count % 2 != 0 && currCount == (count+1)/2 ) 
					return current.data; 
				else if (count%2==0 && currCount == (count/2)+1) 
					return (prev.data+current.data)/2; 
				prev = current; 
				current = current.right; 
			} 
		} 
	}
	return -1; 
} 


public static void main(String[] args) 
{ 

	/* Let us create following BST 
			50 
			/ \ 
		 30    70 
		/ \    / \ 
		20 40 60 80 */
	Node root = null; 
	root = insert(root, 50); 
	insert(root, 30); 
	insert(root, 20); 
	insert(root, 40); 
	insert(root, 70); 
	insert(root, 60); 
	insert(root, 80); 

	System.out.println("Median of BST is " + findMedian(root)); 
} 
} 
//algo
//Implementation:
//1- Count the no. of nodes in the given BST
//   using Morris Inorder Traversal.
//2- Then Perform Morris Inorder traversal one 
//   more time by counting nodes and by checking if 
//   count is equal to the median point.
//   To consider even no. of nodes an extra pointer
//   pointing to the previous node is used.