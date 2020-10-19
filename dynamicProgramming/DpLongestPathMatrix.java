package dynamicProgramming;
//Given a n*n matrix where all numbers are distinct, find the maximum length path (starting from
//any cell) such that all cells along the path are in increasing order with a difference
//of 1.
//
//We can move in 4 directions from a given cell (i, j), i.e., we can move to (i+1, j) or (i, j+1)
//or (i-1, j) or (i, j-1) with the condition that the adjacent cells have a difference of 1.
//
//Example:
//
//Input:  mat[][] = {{1, 2, 9}
//                   {5, 3, 8}
//                   {4, 6, 7}}
//Output: 4
//The longest path is 6-7-8-9. 

public class DpLongestPathMatrix 
{
	public static int n = 3; 
	static int findLongestFromACell(int i, int j, int mat[][], int dp[][]) 
	{ 
		if (i < 0 || i >= n || j < 0 || j >= n) 
			return 0; 
		if (dp[i][j] != -1) 
			return dp[i][j]; 
		int x = Integer.MIN_VALUE, y = Integer.MIN_VALUE, z = Integer.MIN_VALUE, w = Integer.MIN_VALUE; 
		if (j < n - 1 && ((mat[i][j] + 1) == mat[i][j + 1])) 
			x = dp[i][j] = 1 + findLongestFromACell(i, j + 1, mat, dp); 

		if (j > 0 && (mat[i][j] + 1 == mat[i][j - 1])) 
			y = dp[i][j] = 1 + findLongestFromACell(i, j - 1, mat, dp); 

		if (i > 0 && (mat[i][j] + 1 == mat[i - 1][j])) 
			z = dp[i][j] = 1 + findLongestFromACell(i - 1, j, mat, dp); 

		if (i < n - 1 && (mat[i][j] + 1 == mat[i + 1][j])) 
			w = dp[i][j] = 1 + findLongestFromACell(i + 1, j, mat, dp); 
		return dp[i][j] = Math.max(x, Math.max(y, Math.max(z, Math.max(w, 1)))); 
	} 

	static int finLongestOverAll(int mat[][]) 
	{ 
		int result = 1; 
		int[][] dp = new int[n][n]; 
		for (int i = 0; i < n; i++) 
			for (int j = 0; j < n; j++) 
				dp[i][j] = -1; 
		for (int i = 0; i < n; i++) { 
			for (int j = 0; j < n; j++) { 
				if (dp[i][j] == -1) 
					findLongestFromACell(i, j, mat, dp); 
				result = Math.max(result, dp[i][j]); 
			} 
		} 

		return result; 
	} 

	public static void main(String[] args) 
	{ 
		int mat[][] = { { 1, 2, 9 }, 
						{ 5, 3, 8 }, 
						{ 4, 6, 7 } }; 
		System.out.println("Length of the longest path is " + finLongestOverAll(mat)); 
	} 
} 
//algo
//The idea is simple, we calculate longest path beginning with every cell. Once we have computed
//longest for all cells, we return maximum of all longest paths. One important observation in 
//this approach is many overlapping subproblems. Therefore this problem can be optimally 
//solved using Dynamic Programming.