package linkedList;

import java.util.HashSet; 
public class DuplicatesinUnsortedLinkedList  
{ 
    static class node  
    { 
        int val; 
        node next; 
  
        public node(int val)  
        { 
            this.val = val; 
        } 
    } 
      

    static void removeDuplicate(node temp)  
    { 
        HashSet<Integer> hs=new HashSet<>();
        node prev=temp;
        while(temp!=null)
        {
        	if(!hs.contains(temp.val))
        	{
        		hs.add(temp.val);
        		prev=temp;
        		temp=temp.next;
        	}
        	else
        	{
        		prev.next=temp.next;
        		temp=temp.next;
        	}
        }
    } 
      

    static void printList(node head)  
    { 
        while (head != null)  
        { 
            System.out.print(head.val + " "); 
            head = head.next; 
        } 
    } 
  
    public static void main(String[] args)  
    { 

        node start = new node(10); 
        start.next = new node(12); 
        start.next.next = new node(11); 
        start.next.next.next = new node(11); 
        start.next.next.next.next = new node(12); 
        start.next.next.next.next.next = new node(11); 
        start.next.next.next.next.next.next = new node(10); 
  
        System.out.println("Linked list before removing duplicates :"); 
        printList(start); 
  
        removeDuplicate(start); 
  
        System.out.println("\nLinked list after removing duplicates :"); 
        printList(start); 
    } 
} 

//using hashset