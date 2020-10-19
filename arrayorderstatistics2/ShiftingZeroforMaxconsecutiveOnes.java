package arrayorderstatistics2;

public class ShiftingZeroforMaxconsecutiveOnes
{
	static void flipZero(int a[],int m)
	{
		int wR=0,wL=0,bestWindow=0,bestL=0,zeroCount=0;
		while(wR<a.length)
		{
			if(zeroCount<=m)
			{
				if(a[wR]==0)
					zeroCount++;
				wR++;
			}	
			if(zeroCount>m)
			{
				if(a[wL]==0)
					zeroCount--;
				wL++;
			}
			if(wR-wL>bestWindow && zeroCount<=m )
			{
				bestWindow=wR-wL;
				bestL=wL;
			}
		}
		for(int i=0;i<bestWindow;i++)
		{
			if(a[bestL+i]==0)
				System.out.print(bestL+i+" ");
		}
		System.out.print("\nThe maximum 1 is: "+bestWindow); 
	}
	public static void main(String[] args)
	{
		int a[]= {1, 0, 0, 1, 1, 0, 1, 0, 1, 1},m=2;
		System.out.print("The positions to be flipped is: " );
		flipZero(a,m);
	}
}
