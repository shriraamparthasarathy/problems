package dynamicProgramming;

//Given an array p[] which represents the chain of matrices such that the ith matrix Ai is of
//dimension p[i-1] x p[i]. We need to write a function MatrixChainOrder() that should return 
//		the minimum number of multiplications needed to multiply the chain.
//
//
//Input: p[] = {40, 20, 30, 10, 30}   
//Output: 26000  
//There are 4 matrices of dimensions 40x20, 20x30, 30x10 and 10x30.
//Let the input 4 matrices be A, B, C and D.  The minimum number of 
//multiplications are obtained by putting parenthesis in following way
//(A(BC))D --> 20*30*10 + 40*20*10 + 40*10*30
//
//Input: p[] = {10, 20, 30, 40, 30} 
//Output: 30000 
//There are 4 matrices of dimensions 10x20, 20x30, 30x40 and 40x30. 
//Let the input 4 matrices be A, B, C and D.  The minimum number of 
//multiplications are obtained by putting parenthesis in following way
//((AB)C)D --> 10*20*30 + 10*30*40 + 10*40*30
//
//Input: p[] = {10, 20, 30}  
//Output: 6000  
//There are only two matrices of dimensions 10x20 and 20x30. So there 
//is only one way to multiply the matrices, cost of which is 10*20*30

public class MatrixChainMultiplication 
{
    public int findCost(int arr[])
    {
        int temp[][] = new int[arr.length][arr.length];
        int q = 0;
        for(int l=2; l < arr.length; l++)
        {
            for(int i=0; i < arr.length - l; i++)
            {
                int j = i + l;
                temp[i][j] = Integer.MAX_VALUE;
                for(int k=i+1; k < j; k++)
                {
                    q = temp[i][k] + temp[k][j] + arr[i]*arr[k]*arr[j];
                    if(q < temp[i][j])
                    {
                        temp[i][j] = q;
                    }
                }
            }
        }
        return temp[0][arr.length-1];
    }
    
    public static void main(String args[])
    {
    	MatrixChainMultiplication mmc = new MatrixChainMultiplication();
        int arr[] = {1, 2, 3, 4};
        int cost = mmc.findCost(arr);
        System.out.print(cost);
    }
}
//algo time O(n^3) space O(n^2)
//https://www.youtube.com/watch?v=vgLJZMUfnsU