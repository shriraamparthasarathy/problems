package binaryTree2;


import java.util.TreeMap; 
import java.util.Map;

class BottomView 
{ 

static class Node 
{ 
	int data; 
	Node left; 
	Node right; 
}; 
static class pair 
{ 
	int data, height; 
	public pair(int data, int height) 
	{ 
		this.data = data; 
		this.height = height; 
	} 
} 

static Node newNode(int data) 
{ 
	Node node = new Node(); 
	node.data = data; 
	node.left = null; 
	node.right = null; 
	return node; 
} 

static void printTopViewUtil(Node root, int height, 
					int hd, Map<Integer, pair > m) 
{ 
	 if(root==null)
		 return;
	 if(!m.containsKey(hd))
		 m.put(hd,new pair(root.data,height));
	 else
	 {
		 pair temp=m.get(hd);
		 if(temp.height<=height)
		 {
			 m.remove(hd);
			 m.put(hd,new pair(root.data,height));
		 }
	 }
//	 System.out.println(root.data+" "+height+" "+hd+" ");
	 printTopViewUtil(root.left,height+1,hd-1,m);
	 printTopViewUtil(root.right,height+1,hd+1,m);
} 

static void printTopView(Node root) 
{ 
	Map<Integer, pair > m = new TreeMap<>(); 
	printTopViewUtil(root, 0, 0, m); 
	for (Map.Entry<Integer,pair> it : m.entrySet()) 
	{ 
		pair p = it.getValue(); 
		System.out.print(p.data+ " "); 
	} 
} 

public static void main(String[] args) 
{ 
	Node root = newNode(20); 
    root.left =newNode(8); 
    root.right = newNode(22); 
    root.left.left = newNode(5); 
    root.left.right = newNode(3); 
    root.right.left = newNode(4); 
    root.right.right = newNode(25); 
    root.left.right.left = newNode(10); 
    root.left.right.right =newNode(14); 
//	      20
//     /     \
//   8        22
//  /   \    /   \
// 5     3  4     25
//      / \      
//    10   14 
	System.out.print("Top View : "); 
	printTopView(root); 
} 
} 
//algo
//same as top view but if condition is temp.height<=height