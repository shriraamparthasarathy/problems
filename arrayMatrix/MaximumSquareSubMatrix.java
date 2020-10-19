package arrayMatrix;


class MaximumSquareSubMatrix 
{
    static int min(int a,int b,int c)
    {
        if(a<b&&a<c)
            return a;
        else if(b<c)
            return b;
        else
            return c;
    }
    static void findMaxSqrSub(int a[][])
    {
        int r=a.length,c=a[0].length;
        int maxs=Integer.MIN_VALUE,maxr=-1,maxc=-1;
        int t[][]=new int[r][c];
        for(int i=0;i<r;i++)
            t[i][0]=a[i][0];
        for(int i=0;i<c;i++)
            t[0][i]=a[0][i];
        for(int i=1;i<r;i++)
        {
            for(int j=1;j<c;j++)
            {
                if(a[i][j]==0)
                    t[i][j]=0;
                else
                    t[i][j]=min(t[i][j-1],t[i-1][j],t[i-1][j-1]) + 1;
            }
        }
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(maxs<t[i][j])
                {
                    maxs=t[i][j];
                    maxr=i;
                    maxc=j;
                }
            }
        }
        for(int i=maxr;i>maxr-maxs;i--)
        {
            for(int j=maxc;j>maxc-maxs;j--)
                System.out.print(a[i][j]+ " ");
            System.out.println();    
        }
    }
	public static void main (String[] args) 
	{
		int M[][] = {{0, 1, 1, 0, 1},  
                    {1, 1, 0, 1, 0},  
                    {0, 1, 1, 1, 0}, 
                    {1, 1, 1, 1, 0}, 
                    {1, 1, 1, 1, 1}, 
                    {0, 0, 0, 0, 0}}; 
        findMaxSqrSub(M);            
	}
}