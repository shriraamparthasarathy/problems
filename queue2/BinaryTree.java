package queue2;
import java.util.LinkedList;
import java.util.Queue;
public class BinaryTree 
{ 
	class ListNode  
	{ 
	    int data; 
	    ListNode next; 
	    ListNode(int d) 
	    { 
	        data = d; 
	        next = null; 
	    } 
	} 
	class BinaryTreeNode  
	{ 
	    int data; 
	    BinaryTreeNode left, right = null; 
	    BinaryTreeNode(int data) 
	    { 
	        this.data = data; 
	        left = right = null; 
	    } 
	} 
	ListNode head; 
    BinaryTreeNode root; 
   
    void push(int new_data)  
    { 
        ListNode new_node = new ListNode(new_data); 
        new_node.next = head; 
        head = new_node; 
    } 
    BinaryTreeNode convertList2Binary(BinaryTreeNode node)
    {
    	Queue<BinaryTreeNode> q=new LinkedList<>();
    	if(head==null)
    	{
    		node=null;
    		return node;
    	}
    	node=new BinaryTreeNode(head.data);
    	q.add(node);
    	head=head.next;
    	while(head!=null)
    	{
    		BinaryTreeNode parent=q.poll();
    		BinaryTreeNode leftchild=null,rightchild=null;
    		leftchild=new BinaryTreeNode(head.data);
    		q.add(leftchild);
			head=head.next;
    		if(head!=null)
    		{
    			rightchild=new BinaryTreeNode(head.data);
    			q.add(rightchild);
    			head=head.next;
    		}
    		parent.left=leftchild;
    		parent.right=rightchild;
    	}
    	return node;
    }
	void inorderTraversal(BinaryTreeNode node)  
    { 
        if (node != null)  
        { 
            inorderTraversal(node.left); 
            System.out.print(node.data + " "); 
            inorderTraversal(node.right); 
        } 
    } 

    public static void main(String[] args)  
    { 
        BinaryTree tree=new BinaryTree(); 
        tree.push(36); /* Last node of Linked List */
        tree.push(30); 
        tree.push(25); 
        tree.push(15); 
        tree.push(12); 
        tree.push(10); /* First node of Linked List */
        BinaryTreeNode node = tree.convertList2Binary(tree.root); 
   
        System.out.println("Inorder Traversal of the"+ 
                        " constructed Binary Tree is:"); 
        tree.inorderTraversal(node); 
    } 
}
//finish only the convertList2Binary function