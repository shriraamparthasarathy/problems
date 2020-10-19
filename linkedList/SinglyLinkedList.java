package linkedList;

public class SinglyLinkedList 
{
	class Node
	{
		int d;
		Node next;
		Node(int d)
		{
			this.d=d;
			next=null;
		}
	}
	Node head;
	SinglyLinkedList()
	{
		head=null;
	}
	void append(int d) //to insert in the end
	{
		Node temp=new Node(d);
		if(head==null)
		{
			head=new Node(d);
		}
		else
		{
			Node last=head;
			while(last.next!=null)
				last=last.next;
			last.next=temp;	
		}
	}
	void push(int d)// to insert in front
	{
		Node temp=new Node(d);
		if(head==null)
		{
			head=new Node(d);
		}
		else
		{
			temp.next=head;
			head=temp;
		}
	}
	void insertAfter(SinglyLinkedList list,int index,int d)
	{
		if(list.size()<=index) // if size is lesser than the given index, we cant add
		{
			System.out.println("No such index");
		}
		else
		{
			int count=0;
			Node temp=new Node(d);
			Node last=head;
			while(count<index)
			{
				last=last.next;
				count++;
			}
			temp.next=last.next;
			last.next=temp;
		}
	}
	int size()
	{
		Node t=head;
		int size=0;
		for(;t!=null;t=t.next)
			size++;
		return size;
	}
	void printList()
	{
		Node t=head;
		for(;t.next!=null;t=t.next)
			System.out.print(t.d+" ");
		System.out.print(t.d+"\n");
	}
	void deleteElement(int data)
	{
		if(head!=null&&head.d==data) // if the element to be deleted is head
		{
			head=head.next;
			System.out.println(data+" is deleted");
		}
		else
		{
			Node prev=head;
			Node temp=head;
			while(temp!=null&&temp.d!=data)
			{
				prev=temp;  	//having prev to point to previous element
				temp=temp.next;
			}
			if(temp==null)  //if after traversing we cant find the element or if the list is empty
				System.out.println("No such element is found");
			else
			{
				prev.next=temp.next;	//point previous next as the element next to the deleted
				System.out.println(data+" is deleted");
			}
		}
	}
	
	int recursCount(Node temp)//to find size in recursive
	{
		if(temp==null)
			return 0;
		return 1+recursCount(temp.next);
	}
	int recursCountSize()	//to find size in recursive
	{
		Node temp=head;
		int size=recursCount(temp);
		return size;
	}
	
	void getNNode(SinglyLinkedList list,int n)
	{
		if(list.size()<=n) // if size is lesser than the given index, we cant add
		{
			System.out.println("No such index");
		}
		else
		{
			int count=1;
			Node last=head;
			while(count<n)
			{
				last=last.next;
				count++;
			}
			System.out.println("The "+n+" element is: "+last.d);
		}
	}
	
	void printNthFromLast(int n) 
	{
//		Maintain two pointers – reference pointer and main pointer. 
//		Initialize both reference and main pointers to head. First, move reference
//		pointer to n nodes from head. Now move both pointers one by one until the reference 
//		pointer reaches the end. Now the main pointer will point to nth node from the end.
//		Return the main pointer.
		int count=0;
		Node ref=head;
		if(head!=null)
		{
			while(count<n)
			{
				if(ref==null)
				{
					System.out.println("Index out of bound");
					return;
				}
				ref=ref.next;
				count++;
			}
			Node temp=head;
			while(ref!=null)
			{
				temp=temp.next;
				ref=ref.next;
			}
			System.out.println("The "+n+" element from end is: "+temp.d);
		}
	}
	void printMiddle() //check the below algo for algorithm
	{
		Node slow=head;
		Node fast=head;
		while(slow!=null&&fast!=null)
		{
			slow=slow.next;
			fast=fast.next.next;
		}
		System.out.println("The middle element is: "+slow.d);
	}
	void countFrequencyElement(int data)//counts frequency of a given element
	{
		int count=0;
		Node temp=head;
		while(temp!=null)
		{
			if(temp.d==data)
				count++;
			temp=temp.next;
		}
		System.out.println(data+ " occurred "+count+" times");
	}
	public static void main(String args[])
	{
		SinglyLinkedList list=new SinglyLinkedList();
		list.append(2);
		list.append(3);
		list.append(5);
		list.printList();
		list.push(1);
		list.printList();
		list.insertAfter(list,2,4);
		list.printList();
		System.out.println("Size is: "+list.size());
		System.out.println("Recursive count: "+list.recursCountSize());
		list.deleteElement(3);
		list.printList();
		list.getNNode(list, 3);
		list.printNthFromLast(2);
		list.printMiddle();
		list.countFrequencyElement(2);
	}
}
//algo
//mid element
//1 method
//Traverse linked list using two pointers. Move one pointer by one and other pointer by two.
//When the fast pointer reaches end slow pointer will reach middle of the linked list.
//
//another method
//Initialize mid element as head and initialize a counter as 0. Traverse the list from head, 
//while traversing increment the counter and change mid to mid->next whenever the counter is odd.
//So the mid will move only half of the total length of the list.
