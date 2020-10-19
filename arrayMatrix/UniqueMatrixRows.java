package arrayMatrix;
import java.util.HashSet;
class UniqueMatrixRows 
{
    static void findUnique(int a[][])
    {
        HashSet<String> hs=new HashSet<>();
        for(int i=0;i<a.length;i++)
        {
            String s="";
            for(int j=0;j<a[0].length;j++)
                s+=a[i][j];
            if(!hs.contains(s))
            {
                hs.add(s);
                System.out.println(s);
            }
        }
    }
	public static void main (String[] args) 
	{
		int a[][] = { {0, 1, 0, 0, 1}, 
                        {1, 0, 1, 1, 0}, 
                        {0, 1, 0, 0, 1}, 
                        {1, 1, 1, 0, 0} };   
        findUnique(a);
	}
}