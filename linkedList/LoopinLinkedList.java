package linkedList;
//detect loop:
//example 1->2->3->4->5->3 
//this contains a loop from 3 to 5
//in loops that are present in linked list, no node will end with node.next as null
public class LoopinLinkedList 
{
	Node head;
    class Node { 
        int data; 
        Node next; 
        Node(int d) 
        { 
            data = d; 
            next = null; 
        } 
    } 
  
    public void push(int new_data) 
    { 
        Node new_node = new Node(new_data); 
        new_node.next = head; 
        head = new_node; 
    } 
  
    void detectLoop() 
    {
    	boolean flag=false;
    	Node slow=head;
    	Node fast=head;
    	while(fast!=null&&fast.next!=null) //if anyone is null then there is no loop not checking slow!=null since fast will reach null sooner
    	{
    		slow=slow.next;
    		fast=fast.next.next;
    		if(slow==fast)
    		{
    			flag=true;
    			break;
    		}
    	}
    	if(flag)
    		System.out.println("Loop is present");
    	else
    		System.out.println("There is no loop present");
    }
    public static void main(String args[]) 
    { 
        LoopinLinkedList llist = new LoopinLinkedList(); 
  
        llist.push(20); 
        llist.push(4); 
        llist.push(15); 
        llist.push(10); 
        llist.head.next.next.next.next = llist.head;  
        llist.detectLoop(); 
    } 
}
//Floyd’s Cycle-Finding Algorithm time O(n) space O(1)
//Approach: This is the fastest method and has been described below:
//
//Traverse linked list using two pointers.
//Move one pointer(slow_p) by one and another pointer(fast_p) by two. 
//If these pointers meet at the same node then there is a loop. If pointers do not meet then
//linked list doesn’t have a loop.