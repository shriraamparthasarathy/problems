package linkedList5;

public class Sort012sLL 
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

	Node Sort(Node temp)
	{
		Node curr=temp;
		Node zeroD=new Node(0);
		Node oneD=new Node(0);
		Node twoD=new Node(0);
		Node zero=zeroD,one=oneD,two=twoD;
		while(curr!=null)
		{
			if(curr.data==0)
			{
				zero.next=curr;
				zero=zero.next;
			}
			else if(curr.data==1)
			{
				one.next=curr;
				one=one.next;
			}
			else if(curr.data==2)
			{
				two.next=curr;
				two=two.next;
			}
			curr=curr.next;
		}
		zero.next=(oneD.next!=null?oneD.next:twoD.next);
		one.next=twoD.next;
		two.next=null;
		return zeroD.next;
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
		Sort012sLL llist1 = new Sort012sLL(); 
		llist1.push(1); 
		llist1.push(0); 
		llist1.push(2); 
		llist1.push(1); 

		System.out.println("Linked List:"); 
		llist1.printList(); 
		Sort012sLL llist2 = new Sort012sLL();
		llist2.head=llist2.Sort(llist1.head); 

		System.out.println("Modified first linked list:"); 
		llist2.printList(); 

	} 
}
//algo
//Iterate through the linked list. Maintain 3 pointers named zero, one and two to point
//to current ending nodes of linked lists containing 0, 1, and 2 respectively. For every
//traversed node, we attach it to the end of its corresponding list. Finally, we link all 
//three lists. To avoid many null checks, we use three dummy pointers zeroD, oneD and twoD 
//that work as dummy headers of three lists.