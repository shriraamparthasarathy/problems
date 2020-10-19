package queue2;

import java.util.LinkedList; 
import java.util.Queue; 
  
public class CompletenessOfBinaryTree  
{ 
    
    static class Node 
    { 
        int data; 
        Node left; 
        Node right; 

        Node(int d) 
        { 
            data = d; 
            left = null; 
            right = null; 
        } 
    }
    static boolean isCompleteBT(Node root) 
    { 
    	if(root==null)
    		return true;
        boolean flag=false;
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
        	Node temp=q.poll();
        	if(temp.left!=null)
        	{
        		if(flag==true)
        			return false;
        		q.add(temp.left);
        	}
        	else
        		flag=true;
        	if(temp.right!=null)
        	{
        		if(flag==true)
        			return false;
        		q.add(temp.right);
        	}
        	else
        		flag=true;
        }
        return true;
    } 

    public static void main(String[] args)  
    { 
          
        /* Let us construct the following Binary Tree which 
          is not a complete Binary Tree 
                1 
              /   \ 
             2     3 
            / \     \ 
           4   5     6 
        */
       
        Node root = new Node(1); 
        root.left = new Node(2); 
        root.right = new Node(3); 
        root.left.left = new Node(4); 
        root.left.right = new Node(5); 
        root.right.right = new Node(6); 
          
        if(isCompleteBT(root) == true) 
            System.out.println("Complete Binary Tree"); 
        else
            System.out.println("NOT Complete Binary Tree"); 
     } 
  
} 