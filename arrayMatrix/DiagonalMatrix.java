package arrayMatrix;
//Algorithm:
//r = number of rows
//c = number of columns
//Then, number of diagonals will be = r + c - 1
//
//Step 1: Print first r diagonals 
//Print diagonals that start from the first column 
//elements.
//
//Step 2: Print next c - 1 diagonals 
//Print diagonals that start from the last row 
//elements.
//
//Step 1 Details: Print first r diagonals 
//Iterate to print diagonals from row k = 0 to r - 1.
//1: Start with row = k and col = 0
//2: Print the element matrix[row][col]
//3: Decrement row by 1 Increment col by 1 till row greater than or equal to 0 and  col less than c
//
//Step 2 Details: Print next c – 1 diagonals 
//Iterate to print diagonals from column k = 1 to c - 1
//1: Start with last row, row = r – 1 and col = k
//2: Print the element matrix[row][col]
//3: Decrement row by 1 Increment col by 1 till row greater than or equal to 0 and  col less than c
//
//Order of the Algorithm:
//Time Complexity: O(mn)
//Space Complexity: O(1)
class DiagonalMatrix 
{
    static void findDiagonal(int a[][])
    {
        int r=a.length,c=a[0].length;
        for(int k=0;k<r;k++)//based on all rows and first column
        {
            int j=0;//column count
            for(int i=k;i>=0&&j<c;i--,j++)
                System.out.print(a[i][j]+" ");
            System.out.println();    
        }
        for(int k=1;k<c;k++)//based on last row and all columns
        {
            int i=r-1;
            for(int j=k;i>=0&&j<c;i--,j++)
                System.out.print(a[i][j]+" ");
            System.out.println();    
        }
        
    }
	public static void main (String[] args) 
	{
		int M[][] = {{1, 2, 3, 4}, 
                       {5, 6, 7, 8}, 
                       {9, 10, 11, 12}, 
                       {13, 14, 15, 16}, 
                       {17, 18, 19, 20}, 
                      }; 
        findDiagonal(M);              
	}
}