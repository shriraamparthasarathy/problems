package linkedList5;

class AddingAfterMiddle 
{ 
	static Node head; 
	static class Node { 
		int data; 
		Node next; 
		
		Node(int d) { 
			data = d; 
			next = null; 
		} 
	} 
	static void insertAtMid(int x) 
	{ 
		Node slow=head;
		Node fast=head.next;
		Node temp=new Node(x);
		while(fast!=null&&fast.next!=null)
		{
			slow=slow.next;
			fast=fast.next.next;
		}
		
		temp.next=slow.next;
		slow.next=temp;
		
	}  
	static void display() 
	{ 
		Node temp = head; 
		while (temp != null) 
		{ 
			System.out.print(temp.data + " "); 
			temp = temp.next; 
		} 
	} 

	public static void main (String[] args) 
	{ 
		head = null; 
		head = new Node(1); 
		head.next = new Node(2); 
		head.next.next = new Node(4); 
		head.next.next.next = new Node(5); 
		
		System.out.println("Linked list before"+ 
						" insertion: "); 
		display(); 

		int x = 3; 
		insertAtMid(x); 

		System.out.println("\nLinked list after"+ 
						" insertion: "); 
		display(); 
	} 
} 
