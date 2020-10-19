package arrayMatrix;
//Let the given element be x, create two variable i = 0, j = n-1 as index of row and column
//Run a loop until i = 0
//Check if the current element is greater than x then decrease the count of j. Exclude the current column.
//Check if the current element is less than x then increase the count of i. Exclude the current row.
//If the element is equal then print the position and end.

class SearchMatrixRowandColumnwiseSorted 
{
    static void searchMatrix(int a[][],int m,int n,int x)
    {
        int i=0,j=n-1;
        while(i<m&&j>=0)
        {
            if(a[i][j]==x)
            {
                System.out.println("The element is in:row "+ i+" and column "+j);
                return;
            }    
            else if(a[i][j]<x)
                i++;
            else
                j--;
        }
        System.out.println("Not found!");
    }
	public static void main (String[] args) 
	{
		int a[][] = { { 10, 20, 30, 40 }, 
                        { 15, 25, 35, 45 }, 
                        { 27, 29, 37, 48 }, 
                        { 32, 33, 39, 50 } };
        int m=4,n=4;//n=column                
        searchMatrix(a,m,n,29);                
	}
}