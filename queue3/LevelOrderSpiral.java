package queue3;
import java.util.Deque;
import java.util.LinkedList;
//Input: 
//    1
//   / \
//  3   2
//Output :
//1 3 2
//
//Input :
//       10
//      /  \
//     20  30
//    / \  
//   40 60
//Output :
//10 20 30 60 40
public class LevelOrderSpiral 
{
	static class Node
	{
		int data;
		Node left,right;
		Node(int data)
		{
			this.data=data;
			this.left=this.right=null;
		}
	};
	static void spiralOrder(Node root)
	{
		Deque<Node> d=new LinkedList<>();
		int dir=0;
		d.addLast(root);
		while(d.size()>0)
		{
			int size=d.size();
			while(size-->0)
			{
				if(dir==0)
				{
					Node temp=d.pollLast();
					System.out.print(temp.data+" ");
					if(temp.right!=null)
						d.addFirst(temp.right);
					if(temp.left!=null)
						d.addFirst(temp.left);
				}
				else
				{
					Node temp=d.pollFirst();
					System.out.print(temp.data+" ");
					if(temp.left!=null)
						d.addLast(temp.left);
					if(temp.right!=null)
						d.addLast(temp.right);
				}
			}
			dir=1-dir;
		}
	}
	public static void main(String args[])
	{
		Node root = new Node(10);  
	    root.left = new Node(20);  
	    root.right = new Node(30);  
	    root.left.left = new Node(40);  
	    root.left.right = new Node(60);  
	  
	    // Call the Function  
	    spiralOrder(root);  
	}
}
//algo
//The idea is to use a direction variable and decide whether to pop elements from the front
//or from the rear based on the value of this direction variable.