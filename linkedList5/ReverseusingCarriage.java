package linkedList5;

public class ReverseusingCarriage
{
	Node head; 
	class Node 
	{ 
		int data; 
		Node next; 
		Node(int d) {data = d; next = null; } 
	} 
	void push(int new_data) 
	{ 
		Node new_node = new Node(new_data);
		new_node.next = head; 
		head = new_node; 
	} 

	void reverse(int n)
	{
		int j=0;
		Node curr=head;
		while(curr!=null)
		{
			for(int i=0;i<2*(n-j);i++)
				System.out.print(" ");
			System.out.print(curr.data+"\r");
			curr=curr.next;
			j++;
		}
	}

	int printList() 
	{ 
		Node temp = head; 
		int i=0;
		while (temp != null) 
		{ 
		System.out.print(temp.data+" "); 
		temp = temp.next; 
		i++;
		} 
		System.out.println(); 
		return i;
	} 

	public static void main(String args[]) 
	{ 
		ReverseusingCarriage llist1 = new ReverseusingCarriage();
		llist1.push(6); 
		llist1.push(5); 
		llist1.push(4); 
		llist1.push(3); 
		llist1.push(2); 
		llist1.push(1); 

		System.out.println("Linked List:"); 
		int n=llist1.printList(); 

		llist1.reverse(n); 

//		System.out.println("Modified linked list:"); 
//		n=llist1.printList(); 
	} 
}
