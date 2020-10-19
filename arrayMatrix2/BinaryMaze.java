package arrayMatrix2;

import java.util.Queue;
import java.util.LinkedList;
class BinaryMaze
{
    static class Point
    {
        int x,y;
        Point(int x,int y)
        {
            this.x=x;
            this.y=y;
        }
    }
    
    static class Queuenode
    {
        Point p;
        int dist;
        Queuenode(Point p,int dist)
        {
            this.p=p;
            this.dist=dist;
        }
    }
    static boolean isValid(int row,int col,int m,int n)
    {
        return ((row>=0&&row<m)&&(col>=0&&col<n));
    }
    static int findDistance(int a[][],Point s,Point d)
    {
        int rowArr[]={-1,0,1,0};
        int colArr[]={0,-1,0,1};
        boolean vis[][]=new boolean[a.length][a[0].length];
        Queue<Queuenode> q=new LinkedList<>();
        Queuenode qn= new Queuenode(s,0);
        q.add(qn);
        vis[s.x][s.y]=true;
        while(!q.isEmpty())
        {
            Queuenode cur=q.peek();
            Point pt=cur.p;
            if(pt.x==d.x&&pt.y==d.y)
                return cur.dist;
            q.remove();
            for(int i=0;i<4;i++)
            {
                int row=pt.x+rowArr[i];
                int col=pt.y+colArr[i];
                if(isValid(row,col,a.length,a[0].length)&&a[row][col]==1&&!vis[row][col])
                {
                    vis[row][col]=true;
                    Queuenode adjacent=new Queuenode(new Point(row,col),cur.dist+1);
                    q.add(adjacent);
                }
            }
        }
        
        return -1; //if there is no path
    }
    
    public static void main(String[] args)
    {
        int a[][] = {{ 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 }, 
                   { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 }, 
                   { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 }, 
                   { 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 }, 
                   { 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 }, 
                   { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 }, 
                   { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, 
                   { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 }, 
                   { 1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }};
                   
        Point s=new Point(0,0);
        Point d=new Point(3,4);
        System.out.println("The minimum distance to reach the destination: \n"+findDistance(a,s,d));           
    }
}

 
