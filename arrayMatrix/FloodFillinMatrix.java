package arrayMatrix;

//A recursive function to replace previous color 'prevC' at  '(x, y)' 
//and all surrounding pixels of (x, y) with new color 'newC'
//1) If x or y is outside the screen, then return.
//2) If color of screen[x][y] is not same as prevC, then return
//3) Recur for north, south, east and west.
//  floodFillUtil(screen, x+1, y, prevC, newC);
//  floodFillUtil(screen, x-1, y, prevC, newC);
//  floodFillUtil(screen, x, y+1, prevC, newC);
//  floodFillUtil(screen, x, y-1, prevC, newC); 


//"number of islands", "flood fill", "rotten oranges".....etc basically bfs n dfs algos
import java.util.Arrays;
class FloodFillinMatrix 
{
 static void floodFillMatrix(int screen[][],int x,int y,int prevC,int newC)
 {
     if(x<0||x>=screen.length||y<0||y>=screen[0].length)
         return;
     if(screen[x][y]!=prevC)
         return;
     
     screen[x][y]=newC;
     floodFillMatrix(screen,x,y+1,prevC,newC);
     floodFillMatrix(screen,x,y-1,prevC,newC);
     floodFillMatrix(screen,x+1,y,prevC,newC);
     floodFillMatrix(screen,x-1,y,prevC,newC);
     
 }
	public static void main (String[] args) 
	{
		 int screen[][] = {{1, 1, 1, 1, 1, 1, 1, 1}, 
                 {1, 1, 1, 1, 1, 1, 0, 0}, 
                 {1, 0, 0, 1, 1, 0, 1, 1}, 
                 {1, 2, 2, 2, 2, 0, 1, 0}, 
                 {1, 1, 1, 2, 2, 0, 1, 0}, 
                 {1, 1, 1, 2, 2, 2, 2, 0}, 
                 {1, 1, 1, 1, 1, 2, 1, 1}, 
                 {1, 1, 1, 1, 1, 2, 2, 1}, 
                 }; 
     int x = 4, y = 4, newC = 3; 
     floodFillMatrix(screen,x,y,screen[x][y],newC);
     for(int a[]:screen)
         System.out.println(Arrays.toString(a));
	}
}