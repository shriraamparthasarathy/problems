package linkedList5;
//Given a matrix. Convert it into a linked list matrix such that each node is connected to its 
//next right and down node.
//
//Example:
//
//Input : 2D matrix 
//1 2 3
//4 5 6
//7 8 9
//
//Output :
//1 -> 2 -> 3 -> NULL
//|    |    |
//v    v    v
//4 -> 5 -> 6 -> NULL
//|    |    |
//v    v    v
//7 -> 8 -> 9 -> NULL
//|    |    |
//v    v    v
//NULL NULL NULL
public class Matrix2dtoLinkedList { 

	static class Node { 
		int data; 
		Node right; 
		Node down; 
	}; 

	static Node construct(int arr[][], int i, int j,int m, int n) 
	{ 
		if(i>n-1||j>n-1)
			return null;
		Node temp=new Node();
		temp.data=arr[i][j];
		temp.right=construct(arr,i,j+1,m,n);
		temp.down=construct(arr,i+1,j,m,n);
		return temp;
	} 

	static void display(Node head) 
	{ 		
		Node Rp; 
		Node Dp = head; 
		while (Dp != null) { 
			Rp = Dp; 
			while (Rp != null) { 
				System.out.print(Rp.data + " "); 
				Rp = Rp.right; 
			} 
			System.out.println(); 
			Dp = Dp.down; 
		} 
	} 

	public static void main(String args[])
	{ 
		int arr[][] = { { 1, 2, 3 }, 
						{ 4, 5, 6 }, 
					{ 7, 8, 9 } }; 

		int m = 3, n = 3; 
		Node head = construct(arr, 0, 0, m, n); 
		display(head); 
	} 

} 
//algo
//The idea is to construct a new node for every element of matrix and 
//recursively create its down and right nodes.