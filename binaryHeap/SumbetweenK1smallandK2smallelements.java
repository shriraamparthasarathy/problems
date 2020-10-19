package binaryHeap;
//Given an array of integers and two numbers k1 and k2. Find the sum of all elements
//between given two k1’th and k2’th smallest elements of the array. It may be assumed that
//(1 <= k1 < k2 <= n) and all elements of array are distinct.
//Examples :
//
//Input : arr[] = {20, 8, 22, 4, 12, 10, 14},  k1 = 3,  k2 = 6  
//Output : 26          
//         3rd smallest element is 10. 6th smallest element 
//         is 20. Sum of all element between k1 & k2 is
//         12 + 14 = 26
//
//Input : arr[] = {10, 2, 50, 12, 48, 13}, k1 = 2, k2 = 6 
//Output : 73 
class SumbetweenK1smallandK2smallelements 
{ 
	
static int n = 6; 

static void minheapify(int []a, int index) 
{ 

	int small=index;
	int l=2*index+1;
	int r=2*index+2;
	if(l<n&&a[l]<a[small])
		small=l;
	if(r<n&&a[r]<a[small])
		small=r;
	if(small!=index)
	{
		int t=a[index];
		a[index]=a[small];
		a[small]=t;
		minheapify(a,small);
	}
} 

//Driver code 
public static void main (String[] args) 
{ 
	int i = 0; 
	int k1 = 2; 
	int k2 = 6; 

	int []a = { 10, 2, 50, 12, 48, 13 }; 

	int ans = 0; 

	for (i = (n / 2) - 1; i >= 0; i--) 
	{ 
		minheapify(a, i); 
	} 

	for (i = 0; i < k1; i++) 
	{ 
		a[0] = a[n - 1]; 
		n--; 
		minheapify(a, 0); 
	} 
	
	for (i = k1 + 1; i < k2; i++) 
	{ 
		ans += a[0]; 
		a[0] = a[n - 1]; 
		n--; 
		minheapify(a, 0); 
	} 

	System.out.println(ans); 
} 
} 
//algo
//1) Create a min heap of all array elements. (This step takes O(n) time)
//2) Do extract minimum k1 times (This step takes O(K1 Log n) time)
//3) Do extract minimum k2 – k1 – 1 time and sum all extracted elements. 
//(This step takes O ((K2 – k1) * Log n) time)
