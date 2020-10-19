package linkedList5;


public class SegregateVowelsConsonants 	
{
	Node head; 
	class Node 
	{ 
		char data; 
		Node next; 
		Node(char d) {data = d; next = null; } 
	} 
	void push(char new_data) 
	{ 
		Node new_node = new Node(new_data);
		new_node.next = head; 
		head = new_node; 
	} 

	boolean isVowel(char c)
	{
		return (c=='a'||c=='e'||c=='i'||c=='o'||c=='u');
	}
	void arrange()
	{
		Node newHead = head;   
	    Node latestVowel; 
	    Node curr = head;  
	    if (head == null)  
	        return;  
	    if (isVowel(head.data) == true)  
	        latestVowel = head;   
	    else
	    {  
	        while (curr.next != null &&  
	            !isVowel(curr.next.data))  
	            curr = curr.next;  
	        if (curr.next == null)  
	            return;   
	        latestVowel  = curr.next;  
	        newHead=curr.next;
	        curr.next = curr.next.next;  
	        latestVowel.next = head;  
	    }  
	    while(curr!=null&&curr.next!=null)
	    {
	    	if(isVowel(curr.next.data))
	    	{
	    		if(curr==latestVowel)
	    		{
	    			latestVowel=curr.next;
	    			curr=curr.next;
	    		}
	    		else
	    		{
	    			Node temp=latestVowel.next;
	    			latestVowel.next=curr.next;
	    			latestVowel=latestVowel.next;
	    			curr.next=curr.next.next;
	    			latestVowel.next=temp;
	    		}
	    	}
	    	else
	    		curr=curr.next;
	    }
	    head=newHead;
	}
	
	void printList() 
	{ 
		Node temp = head; 
		while (temp != null) 
		{ 
		System.out.print(temp.data+" "); 
		temp = temp.next; 
		} 
		System.out.println(); 
	} 

	public static void main(String args[]) 
	{ 
		SegregateVowelsConsonants llist1 = new SegregateVowelsConsonants();
		llist1.push('i'); 
		llist1.push('x'); 
		llist1.push('o'); 
		llist1.push('d'); 
		llist1.push('e'); 
		llist1.push('c'); 
		llist1.push('b'); 
		llist1.push('a'); 
		System.out.println("Linked List:"); 
		llist1.printList();

		llist1.arrange();

		System.out.println("Modified list:"); 
		llist1.printList();
	}
} 