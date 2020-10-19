package binaryTree4;
//Given a Binary Tree, check whether the Binary tree contains a duplicate sub-tree of size 2 or more.
//Note : Two same leaf nodes are not considered as subtree size of a leaf node is one.
//
//Input :  Binary Tree 
//               A
//             /    \ 
//           B        C
//         /   \       \    
//        D     E       B     
//                     /  \    
//                    D    E
//Output : Yes
import java.util.HashSet; 
public class CheckDuplicateSubtrees
{ 

	static class Node
	{ 
		int data; 
		Node left,right; 
		Node(int data) 
		{ 
			this.data=data; 
		} 
	}; 
	static char MARKER = '$'; 


	public static String dupSubUtil(Node root, HashSet<String> subtrees) 
	{ 
		String s = ""; 
		if (root == null) 
			return s + MARKER; 
	
		String lstr=dupSubUtil(root.left,subtrees);
		if(lstr.equals(s))
			return s;
		String rstr=dupSubUtil(root.right,subtrees);
		if(rstr.equals(s))
			return s;
		s=s+root.data+lstr+rstr;
		if(s.length()>3&&subtrees.contains(s))
			return "";
		subtrees.add(s);
		return s;
	} 

	public static String dupSub(Node root) 
	{ 
		HashSet<String> subtrees=new HashSet<>(); 
		return dupSubUtil(root,subtrees); 
	} 

	public static void main(String args[]) 
	{ 
		Node root = new Node('A'); 
		root.left = new Node('B'); 
		root.right = new Node('C'); 
		root.left.left = new Node('D'); 
		root.left.right = new Node('E'); 
		root.right.right = new Node('B'); 
		root.right.right.right = new Node('E'); 
		root.right.right.left= new Node('D'); 
		String str = dupSub(root); 
		if(str.equals("")) 
			System.out.print(" Yes "); 
		else	
			System.out.print(" No "); 
	} 
} 
//algo	
//The idea is to serialize subtrees as strings and store the strings in hash table. 
//Once we find a serialized tree (which is not a leaf) already existing in hash-table, 
//we return true.


