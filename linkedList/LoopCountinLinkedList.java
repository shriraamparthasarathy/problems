package linkedList;

public class LoopCountinLinkedList 
{
	static class Node  
	{  
	    int data; 
	    Node next; 
	    Node(int data) 
	    { 
	        this.data =data; 
	        next =null; 
	    } 
	} 

	static int countNodes( Node n)  
	{  
	int res = 1;  
	Node temp = n;  
	while (temp.next != n)  
	{  
	    res++;  
	    temp = temp.next;  
	}  
	return res;  
	}  
	  
	/* This function detects and counts loop  
	nodes in the list. If loop is not there  
	in then returns 0 */
	static int countNodesinLoop( Node list)  
	{  
	    Node slow = list, fast = list;  
	    while (fast!=null && fast.next!=null)  
	    {  
	        slow = slow.next; 
	        fast = fast.next.next;
	        if (slow == fast)  
	            return countNodes(slow);  
	    }
	    return 0;  
	}  
	  
	static Node newNode(int key)  
	{  
	    Node temp = new Node(key); 
	      
	    return temp;  
	}  
	    public static void main (String[] args) { 
	        Node head = newNode(1);  
	    head.next = newNode(2);  
	    head.next.next = newNode(3);  
	    head.next.next.next = newNode(4);  
	    head.next.next.next.next = newNode(5);  
	  
	    /* Create a loop for testing */
	    head.next.next.next.next.next = head.next;  
	  
	    System.out.println( countNodesinLoop(head));  
	    } 


}
