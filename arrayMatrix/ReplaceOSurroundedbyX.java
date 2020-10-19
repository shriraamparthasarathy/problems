package arrayMatrix;
import java.util.Arrays;
public class ReplaceOSurroundedbyX 
{
	static void floodFillMatrix(char M[][],int x,int y,char prevC,char newC)
	 {
	     if(x<0||x>=M.length||y<0||y>=M[0].length)
	         return;
	     if(M[x][y]!=prevC)
	         return;
	     
	     M[x][y]=newC;
	     floodFillMatrix(M,x,y+1,prevC,newC);
	     floodFillMatrix(M,x,y-1,prevC,newC);
	     floodFillMatrix(M,x+1,y,prevC,newC);
	     floodFillMatrix(M,x-1,y,prevC,newC);
	     
	 }
	static void replaceO(char[][] M)
	{
		for(int i=0;i<M.length;i++)
			for(int j=0;j<M[0].length;j++)
				if(M[i][j]=='O')
					M[i][j]='-';
		for(int i=0;i<M.length;i++)
			if(M[i][0]=='-')
				floodFillMatrix(M,i,0,'-','O');
		for(int i=0;i<M.length;i++)
			if(M[i][M[0].length-1]=='-')
				floodFillMatrix(M,i,M[0].length-1,'-','O');
		for(int i=0;i<M[0].length;i++)
			if(M[0][i]=='-')
				floodFillMatrix(M,0,i,'-','O');
		for(int i=0;i<M[0].length;i++)
			if(M[M.length-1][i]=='-')
				floodFillMatrix(M,0,M.length-1,'-','O');
		
		for(int i=0;i<M.length;i++)
			for(int j=0;j<M[0].length;j++)
				if(M[i][j]=='-')
					M[i][j]='X';
	}
	
	public static void main(String args[])
	{
		char M[][] =  {{'X', 'O', 'X', 'O', 'X', 'X'}, 
                {'X', 'O', 'X', 'X', 'O', 'X'}, 
                {'X', 'X', 'X', 'O', 'X', 'X'}, 
                {'O', 'X', 'X', 'X', 'X', 'X'}, 
                {'X', 'X', 'X', 'O', 'X', 'O'}, 
                {'O', 'O', 'X', 'O', 'O', 'O'}, 
               }; 
		for(char[] c: M)
			System.out.println(Arrays.toString(c));
		System.out.println("\n");
		replaceO(M);
		for(char[] c: M)
			System.out.println(Arrays.toString(c));
	}
}
