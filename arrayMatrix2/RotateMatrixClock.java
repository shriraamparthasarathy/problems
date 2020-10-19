package arrayMatrix2;

import java.util.Arrays;
class RotateMatrixClock 
{
        static void rotateMatrix(int a[][])
	    {
	        int m=a.length,n=a[0].length;
	        int row=0,col=0;
	        while(row<m&&col<n)
	        {
	            if(row+1==m||col+1==n)
	             break;
	            int prev=a[row+1][col];
	            for(int i=col;i<n;i++)
	            {
	                int cur=a[row][i];
	                a[row][i]=prev;
	                prev=cur;
	            }
	            row++;
	            for(int i=row;i<m;i++)
	            {
	                int cur=a[i][n-1];
	                a[i][n-1]=prev;
	                prev=cur;
	            }
	            n--;
	            if(row<m)
	            {
	                for(int i=n-1;i>=col;i--)
	                {
	                    int cur=a[m-1][i];
	                    a[m-1][i]=prev;
	                    prev=cur;
	                }
	            }
	            m--;
	            if(col<n)
	            {
	                for(int i=m-1;i>=row;i--)
	                {
	                    int cur=a[i][col];
	                    a[i][col]=prev;
	                    prev=cur;
	                }
	            }
	            col++;
	        }
	    }
	    public static void main (String[] args) 
    	{
	    
	    	int a[][] = { {1, 2, 3, 4}, 
                          {5, 6, 7, 8}, 
                          {9, 10, 11, 12}, 
                          {13, 14, 15, 16} };
            rotateMatrix(a);
            for(int i[]:a)
                System.out.println(Arrays.toString(i));
	    }
}