package arrayorderstatistics;

public class SmallerElementsontheRight 
{
	static class Node
	{
		int data;
		Node left,right;
		int size;
		public Node(int data)
		{
			this.data=data;
			this.left=null;
			this.right=null;
			this.size=1;
		}
	}
	
	static class BST
	{
		int size(Node root)
		{
			if(root==null)
				return 0;
			else
				return root.size;
		}
		
		Node insert(Node root,int data,int count[],int i)
		{
			if(root==null)
				return new Node(data);
			else if(data<root.data)
				root.left=insert(root.left,data,count,i);
			else
			{
				root.right=insert(root.right,data,count,i);
				count[i]+=size(root.left)+1;
			}
			root.size=size(root.left)+size(root.right)+1;
			return root;
		}
	}
	
	
	public static void main(String[] args)
	{
		int[] a = {12, 1, 2, 3, 0, 11, 4}; //5, 4, 3, 2, 1 // 1, 2, 3, 4, 5
		int count[]=new int[a.length];
		BST b=new BST();
		Node root=null;
		for(int i=a.length-1;i>=0;i--)
			root=b.insert(root, a[i], count, i);
		for(int i: count)
			System.out.print(i+" ");
	}
}
