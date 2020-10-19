package linkedList;


class IntersectionofTwoLinkedList 
{ 
	Node head;
	class Node 
	{ 
		int data; 
		Node next; 
		Node(int d) {data = d; next = null; } 
	} 

			
	public void push(int new_data) 
	{ 
		Node new_node = new Node(new_data); 
		new_node.next = head; 
		head = new_node; 
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
	IntersectionofTwoLinkedList findIntersection(IntersectionofTwoLinkedList l1,IntersectionofTwoLinkedList l2)
	{
		IntersectionofTwoLinkedList l3=new IntersectionofTwoLinkedList();
		Node temp1=l1.head;
		Node temp2=l2.head;
		while(temp1!=null&&temp2!=null)
		{
			if(temp1.data==temp2.data)
			{
				l3.push(temp1.data);
				temp1=temp1.next;
				temp2=temp2.next;
			}
			else
			{
				if(temp1.data<temp2.data)
					temp1=temp1.next;
				else
					temp2=temp2.next;
			}
		}
		return l3;
	}
	public static void main(String args[]) 
	{ 
//		First linked list: 1->2->3->4->6
//		Second linked list be 2->4->6->8,
		IntersectionofTwoLinkedList llist1 = new IntersectionofTwoLinkedList(); 
		llist1.push(6); 
		llist1.push(4); 
		llist1.push(3); 
		llist1.push(2); 
		llist1.push(1);
		IntersectionofTwoLinkedList llist2 = new IntersectionofTwoLinkedList();
		llist2.push(8); 
		llist2.push(6); 
		llist2.push(4); 
		llist2.push(2); 
		System.out.println("Linked list 1:");
		llist1.printList();
		System.out.println("Linked list 2:");
		llist2.printList();
		IntersectionofTwoLinkedList inter=new IntersectionofTwoLinkedList();
		inter=inter.findIntersection(llist1,llist2);
		System.out.println("Itersection:"); 
		inter.printList(); 
		
		

	} 
}	