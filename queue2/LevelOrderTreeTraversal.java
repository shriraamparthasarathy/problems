package queue2;
import java.util.Queue;
import java.util.LinkedList;
public class LevelOrderTreeTraversal 
{
	static class Node
	{
		int item;
		Node left;
		Node right;
		public Node(int item)
		{
			this.item=item;
			left=null;
			right=null;
		}
	}
	Node root=null;
	void printLevelOrder()
	{
		Queue<Node> q=new LinkedList<>();
		q.add(root);
		while(!q.isEmpty())
		{
			Node temp=q.poll();
			System.out.print(temp.item+" ");
			if(temp.left!=null)
				q.add(temp.left);
			if(temp.right!=null)
				q.add(temp.right);
		}
	}
	public static void main(String args[])
	{ 
        /* creating a binary tree and entering  
         the nodes */
		LevelOrderTreeTraversal tree_level = new LevelOrderTreeTraversal(); 
        tree_level.root = new Node(1); 
        tree_level.root.left = new Node(2); 
        tree_level.root.right = new Node(3); 
        tree_level.root.left.left = new Node(4); 
        tree_level.root.left.right = new Node(5); 
  
        System.out.println("Level order traversal of binary tree is - "); 
        tree_level.printLevelOrder(); 
    } 
}
