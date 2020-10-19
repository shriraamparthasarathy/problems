package binaryTree3;



 class LowestCommonAncestor 
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
	static boolean v1 = false, v2 = false; 

	// This function returns pointer to LCA of two given 
	// values n1 and n2. 
	// v1 is set as true by this function if n1 is found 
	// v2 is set as true by this function if n2 is found 
	Node findLCAUtil(Node node, int n1, int n2) 
	{ 
		if(node==null)
			return null;
		Node temp=null;
		if(node.data==n1)
		{
			v1=true;
			temp=node;
		}
		if(node.data==n2)
		{
			v2=true;
			temp=node;
		}
		Node leftLCA=findLCAUtil(node.left,n1,n2);
		Node rightLCA=findLCAUtil(node.right,n1,n2);
		if(temp!=null)
			return temp;
		if(leftLCA!=null&&rightLCA!=null)
			return node;
		return(leftLCA!=null)?leftLCA:rightLCA;
	} 

	Node findLCA(int n1, int n2) 
	{ 
		v1 = false; 
		v2 = false; 
		Node lca = findLCAUtil(root, n1, n2); 

		if (v1 && v2) 
			return lca; 
		return null; 
	} 

	/* Driver program to test above functions */
	public static void main(String args[]) 
	{ 
		LowestCommonAncestor tree = new LowestCommonAncestor(); 
		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
		tree.root.left.left = new Node(4); 
		tree.root.left.right = new Node(5); 
		tree.root.right.left = new Node(6); 
		tree.root.right.right = new Node(7); 

		Node lca = tree.findLCA(4, 5); 
		if (lca != null) 
			System.out.println("LCA(4, 5) = " + lca.data); 
		else
			System.out.println("Keys are not present"); 

		lca = tree.findLCA(4, 10); 
		if (lca != null) 
			System.out.println("LCA(4, 10) = " + lca.data); 
		else
			System.out.println("Keys are not present"); 
	} 
} 
// algo
// The method 1 finds LCA in O(n) time, but requires three tree traversals plus extra spaces for path arrays. If we assume that the keys n1 and n2 are present in Binary Tree, we can find LCA using single traversal of Binary Tree and without extra storage for path arrays.
// The idea is to traverse the tree starting from root. If any of the given keys (n1 and n2) matches with root, then root is LCA (assuming that both keys are present). If root doesn’t match with any of the keys, we recur for left and right subtree. The node which has one key present in its left subtree and the other key present in right subtree is the LCA. If both keys lie in left subtree, then left subtree has LCA also, otherwise LCA lies in right subtree.
//
//
// If one key is present and other is absent, then it returns the present key as LCA (Ideally should have returned NULL).
// We can extend this method to handle all cases by passing two boolean variables v1 and v2. v1 is set as true when n1 is present in tree and v2 is set as true if n2 is present in tree.