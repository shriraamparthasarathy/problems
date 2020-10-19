package binarySearchTree2;
//Given an array of integers, replace every element with the least greater element on its right
//side in the array. If there are no greater element on right side, replace it with -1.
//
//Examples:
//
//Input: [8, 58, 71, 18, 31, 32, 63, 92, 
//         43, 3, 91, 93, 25, 80, 28]
//Output: [18, 63, 80, 25, 32, 43, 80, 93, 
//         80, 25, 93, -1, 28, -1, -1]

public class NextLeastGreatestElement 
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
	static Node succ;
	NextLeastGreatestElement()
	{
		this.root=null;
	}
	Node insertRec(Node root,int d)
	{
		if(root==null)
		{
			root=new Node(d);
			return root;
		}
		if(d<root.data)
		{
			succ=root;
			root.left=insertRec(root.left,d);
		}
		else if(d>root.data)
			root.right=insertRec(root.right,d);
		return root;
	}
	
	void replace(int arr[])
	{
		int n=arr.length;
		for(int i=n-1;i>=0;i--)
		{
			succ=null;
			root=insertRec(root,arr[i]);
			if(succ!=null)
				arr[i]=succ.data;
			else
				arr[i]=-1;
		}
	}
	public static void main(String args[])
	{
		int arr[] = { 8, 58, 71, 18, 31, 32, 63, 92,43, 3, 91, 93, 25, 80, 28 }; 
		NextLeastGreatestElement tree=new NextLeastGreatestElement();
		System.out.println("Original array:");
		for(int n:arr)
			System.out.print(n+" ");
		System.out.println();
		tree.replace(arr); 
		System.out.println("\nModified array: ");
		for(int n:arr)
			System.out.print(n+" ");
	}
}
//algo
//We start scanning the array from right to left and insert each element into the BST. 
//For each inserted element, we replace it in the array by its inorder successor in BST.
//If the element inserted is the maximum so far (i.e. its inorder successor doesn’t exists),
//we replace it by -1.