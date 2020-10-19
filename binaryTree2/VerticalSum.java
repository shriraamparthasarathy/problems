package binaryTree2;
//Given a Binary Tree, find the vertical sum of the nodes that are in the same vertical line. 
//Print all sums through different vertical lines.
//Examples:
//
//      1
//    /   \
//  2      3
// / \    / \
//4   5  6   7
//The tree has 5 vertical lines
//
//Vertical-Line-1 has only one node 4 => vertical sum is 4
//Vertical-Line-2: has only one node 2=> vertical sum is 2
//Vertical-Line-3: has three nodes: 1,5,6 => vertical sum is 1+5+6 = 12
//Vertical-Line-4: has only one node 3 => vertical sum is 3
//Vertical-Line-5: has only one node 7 => vertical sum is 7
//
//So expected output is 4, 2, 12, 3 and 7
import java.util.TreeMap; 
import java.util.Map;

class VerticalSum 
{ 

static class Node 
{ 
	int data; 
	Node left; 
	Node right; 
}; 


static Node newNode(int data) 
{ 
	Node node = new Node(); 
	node.data = data; 
	node.left = null; 
	node.right = null; 
	return node; 
} 

static void printTopViewUtil(Node root, int hd, Map<Integer, Integer > m) 
{ 
	 if(root==null)
		 return;
	 printTopViewUtil(root.left,hd-1,m);
	 int prev=m.get(hd)==null?0:m.get(hd);
	 m.put(hd,prev+root.data);
	 printTopViewUtil(root.right,hd+1,m);
} 

static void printTopView(Node root) 
{ 
	Map<Integer, Integer > m = new TreeMap<>(); 
	printTopViewUtil(root, 0, m); 
	for (Map.Entry<Integer,Integer> it : m.entrySet()) 
	{ 
		Integer p = it.getValue(); 
		System.out.print(p+ " "); 
	} 
} 

public static void main(String[] args) 
{ 
	Node root = newNode(1); 
	root.left = newNode(2); 
	root.right = newNode(3); 
	root.left.right = newNode(4); 
	root.left.right.right = newNode(5); 
	root.left.right.right.right = newNode(6); 
//	     1
//     /   \
//   2       3
//     \   
//       4  
//         \
//           5
//            \
//              6
	System.out.print("Top View : "); 
	printTopView(root); 
} 
} 
//algo
//same as finding the topview
//
//We need to check the Horizontal Distances from the root for all nodes. 
//If two nodes have the same Horizontal Distance (HD), then they are on the 
//same vertical line. The idea of HD is simple. HD for root is 0, a right edge
//(edge connecting to right subtree) is considered as +1 horizontal distance and a left edge
//is considered as -1 horizontal distance. For example, in the above tree, HD for Node 4 is at
//-2, HD for Node 2 is -1, HD for 5 and 6 is 0 and HD for node 7 is +2.
//We can do an in-order traversal of the given Binary Tree. While traversing the tree, we can 
//recursively calculate HDs. We initially pass the horizontal distance as 0 for root. For left
//subtree, we pass the Horizontal Distance as Horizontal distance of root minus 1. For right 
//subtree, we pass the Horizontal Distance as Horizontal Distance of root plus 1.