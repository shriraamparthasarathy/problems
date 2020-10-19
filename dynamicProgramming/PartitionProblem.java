package dynamicProgramming;



class PartitionProblem 
{ 
 
	static boolean findPartition (int arr[], int n) 
	{ 
		int sum = 0; 
		int i, j;  
		for (i = 0; i < n; i++) 
			sum += arr[i]; 

		if (sum%2 != 0) 
			return false; 

		boolean part[][]=new boolean[sum/2+1][n+1]; 
		for (i = 0; i <= n; i++) 
			part[0][i] = true; 
		for (i = 1; i <= sum/2; i++) 
			part[i][0] = false; 
		for (int k = 0; k <= sum/2; k++) 
		{ 
			for (int l = 0; l <= n; l++) 
				System.out.print(part[k][l]+" "); 
			System.out.println(); 
		} 
		System.out.println(); 
		for (i = 1; i <= sum/2; i++) 
		{ 
			for (j = 1; j <= n; j++) 
			{ 
				part[i][j] = part[i][j-1]; 
				if (i >= arr[j-1]) 
					part[i][j] = part[i][j] || 
								part[i - arr[j-1]][j-1]; 
			} 
			for (int k = 0; k <= sum/2; k++) 
			{ 
				for (int l = 0; l <= n; l++) 
					System.out.print(part[k][l]+" "); 
				System.out.println(); 
			} 
			System.out.println(); 
		} 
	

		return part[sum/2][n]; 
	} 

	public static void main (String[] args) 
	{ 
		int arr[] = {3, 1, 1, 2, 2,1}; 
		int n = arr.length; 
		if (findPartition(arr, n) == true) 
			System.out.println("Can be divided into two subsets of equal sum"); 
		else
			System.out.println("Can not be divided into two subsets of equal sum"); 

	} 
} 
