package dynamicProgramming;

//0-1 knapsack problem refer geeksforgeeks dp10

class KnapSackProblem 
{ 
 
	static int max(int a, int b) 
	{ 
		return (a > b) ? a : b; 
	} 

	// Returns the maximum value that can 
	// be put in a knapsack of capacity W 
	static int knapSack(int W, int wt[], int val[], int n) 
	{ 
		int i, j; 
		int K[][] = new int[n + 1][W + 1];  
		for(i=0;i<=n;i++)
		{
			for(j=0;j<=W;j++)
			{
				if(i==0||j==0)
					K[i][j]=0;
				else if(wt[i-1]<=j)
					K[i][j]=max(val[i-1]+K[i-1][j-wt[i-1]],K[i-1][j]);
				else
					K[i][j]=K[i-1][j];
			}
		}
		return K[n][W]; 
	} 

	public static void main(String args[]) 
	{ 
		int val[] = new int[] { 60, 100, 120 }; 
		int wt[] = new int[] { 10, 20, 30 }; 
		int W = 50; 
		int n = val.length; 
		System.out.println(knapSack(W, wt, val, n)); 
	} 
} 
//algo
//In the Dynamic programming we will work considering the same cases as mentioned in the 
//recursive approach. In a DP[][] table let’s consider all the possible weights from ‘1’ to ‘W’ 
//as the columns and weights that can be kept as the rows.
//The state DP[i][j] will denote maximum value of ‘j-weight’ considering all values from ‘1 to ith’.
//So if we consider ‘wi’ (weight in ‘ith’ row) we can fill it in all columns which have ‘weight 
//values > wi’. Now two possibilities can take place:
//
//Fill ‘wi’ in the given column.
//Do not fill ‘wi’ in the given column.
//Now we have to take a maximum of these two possibilities, formally if we do not fill ‘ith’
//weight in ‘jth’ column then DP[i][j] state will be same as DP[i-1][j] but if we fill the weight,
//DP[i][j] will be equal to the value of ‘wi’+ value of the column weighing ‘j-wi’ in the previous 
//row. So we take the maximum of these two possibilities to fill the current state.

//representation
//	capacity = 50
//	0	10	20	30	40	50	
//
//	0	0	0	0	0	0	0
//
//	1	0	60	60	60	60	60
//
//	2	0	60	100	160	160	160	
//		            (30>2) so we take max(value[i-1]+ k[i-1][j-wt[i]],k[i-1][j])=160
//
//	3	0	60	100	120	180	220
//
//
//
//60
//100
//120
