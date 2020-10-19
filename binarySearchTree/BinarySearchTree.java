package binarySearchTree;

public class BinarySearchTree 
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
	BinarySearchTree()
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
	void deleteKey(int key)
	{
		root=deleteKeyRec(root,key);
	}
	Node deleteKeyRec(Node root,int key)
	{
		if(root==null)
			return root;
		if(key<root.data)
			root.left=deleteKeyRec(root.left,key);
		else if(key>root.data)
			root.right=deleteKeyRec(root.right,key);
		else
		{
			if(root.left==null)
				return root.right;
			else if(root.right==null)
				return root.left;
			root.data=minVal(root.right);
			root.right=deleteKeyRec(root.right,root.data);
		}
		return root;
	}
	int minVal(Node root)
	{
		int x=root.data;
		while(root.left!=null)
		{
			x=root.left.data;
			root=root.left;
		}
		return x;
	}
	void inorder()
	{
		inOrderRec(root);
	}
	void inOrderRec(Node root)
	{
		if(root!=null)
		{
			inOrderRec(root.left);
			System.out.print(root.data+" ");
			inOrderRec(root.right);
		}
	}
	public static void main(String args[])
	{
		BinarySearchTree tree=new BinarySearchTree();
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

		// print inorder traversal of the BST 
		tree.inorder(); 
		System.out.println("\nDelete 20"); 
        tree.deleteKey(20); 
        System.out.println("Inorder traversal of the modified tree"); 
        tree.inorder(); 
  
        System.out.println("\nDelete 30"); 
        tree.deleteKey(30); 
        System.out.println("Inorder traversal of the modified tree"); 
        tree.inorder(); 
  
        System.out.println("\nDelete 50"); 
        tree.deleteKey(50); 
        System.out.println("Inorder traversal of the modified tree"); 
        tree.inorder(); 
	}
}
//algo
//insert: left node should be < root and right node should be>node
//delete: replace the deleted element with the minimum element from the right subtree
//When we delete a node, three possibilities arise.
//1) Node to be deleted is leaf: Simply remove from the tree.
//
//              50                            50
//           /     \         delete(20)      /   \
//          30      70       --------->    30     70 
//         /  \    /  \                     \    /  \ 
//       20   40  60   80                   40  60   80
//2) Node to be deleted has only one child: Copy the child to the node and delete the child
//
//              50                            50
//           /     \         delete(30)      /   \
//          30      70       --------->    40     70 
//            \    /  \                          /  \ 
//            40  60   80                       60   80
//3) Node to be deleted has two children: Find inorder successor of the node. Copy contents of the 
//inorder successor to the node and delete the inorder successor. Note that inorder predecessor
//can also be used.
//
//              50                            60
//           /     \         delete(50)      /   \
//          40      70       --------->    40    70 
//                 /  \                            \ 
//                60   80                           80
//The important thing to note is, inorder successor is needed only when right child is not empty.
//In this particular case, inorder successor can be obtained by finding the minimum value in right 
//child of the node.