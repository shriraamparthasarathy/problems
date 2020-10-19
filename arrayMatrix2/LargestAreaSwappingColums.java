package arrayMatrix2;
//Input: bool mat[][] = { {0, 1, 0, 1, 0},
//        {0, 1, 0, 1, 1},
//        {1, 1, 0, 1, 0}
//      };
//Output: 6
//The largest rectangle's area is 6. The rectangle 
//can be formed by swapping column 2 with 3
//The matrix after swapping will be
//0 0 1 1 0
//0 0 1 1 1
//1 0 1 1 0


class LargestAreaSwappingColums 
{
    static int findMaxArea(int a[][])
    {
        int r=a.length,c=a[0].length,area=0;
     // An auxiliary array to store count of consecutive 1's 
        // in every column. 
        int h[][]=new int[r][c];
        
        for(int i=0;i<c;i++)
        {
        	// First row in hist[][] is copy of first row in mat[][] 
            h[0][i]=a[0][i];
            for(int j=1;j<r;j++)
            {
                
                h[j][i]=a[j][i]==0?0:h[j-1][i]+1;
            }
        }
       
     // Step 2: Sort rows of hist[][] in non-increasing order 
        
        for(int i=0;i<r;i++)
        {
            int count[]=new int[c];
            for(int j=0;j<c;j++)
                count[h[i][j]]++;
            
         // Traverse the count array from right side 
            
            int col=0;
            for(int j=c-1;j>=0;j--)
            {
                if(count[j]!=0)
                {
                    while(count[j]!=0)
                    {
                        h[i][col]=j;
                        col++;
                        count[j]--;
                    }
                }
            }
        
        }
        
     // Step 3: Traverse the sorted hist[][] to find maximum area 
        int curarea=0;
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
            	// Since values are in decreasing order, 
                // The area ending with cell (i, j) can 
                // be obtained by multiplying column number 
                // with value of hist[i][j] 
       	
            	curarea=(j+1)*h[i][j];
                area=curarea>area?curarea:area;
            }
        }
        
        return area;    
    }
	public static void main (String[] args) 
	{
	    int a[][]={{0, 1, 0, 1, 0}, 
                       {0, 1, 0, 1, 1}, 
                       {1, 1, 0, 1, 0}}; 
		System.out.println("Max area is: "+findMaxArea(a));
	}
}