package arrayMatrix;

class SetMatrix0or1 
{
    static void setMatrix(int a[][])
    {
        boolean row1=false,col1=false;
        int r=a.length,c=a[0].length;
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(i==0&&a[i][j]==1)
                    row1=true;
                if(j==0&&a[i][j]==1)
                    col1=true;
                if(a[i][j]==1)
                {
                    a[i][0]=1;
                    a[0][j]=1;
                }
            }
        }
        for(int i=1;i<r;i++)
        {
            for(int j=1;j<c;j++)
            {
                if(a[i][0]==1||a[0][j]==1)
                    a[i][j]=1;
            }
        }
        if(row1)
            for(int i=0;i<r;i++)
                a[i][0]=1;
        if(col1)
            for(int i=0;i<c;i++)
                a[0][i]=1;
    }
	public static void main (String[] args) 
	{
		int a[][] = {{1, 0, 0, 1}, 
                {0, 0, 1, 0}, 
                {0, 0, 0, 0}}; 
        	setMatrix(a);        
       	 	System.out.println("The changed array:");
        	for(int i=0;i<a.length;i++)
        	{
            		for(int j=0;j<a[0].length;j++)
                		System.out.print(a[i][j]+" ");
            		System.out.println();    
        	}
	}
}
