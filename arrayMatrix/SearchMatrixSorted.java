package arrayMatrix;


//Binary search solution treats the entire matrix as a single array with index trick
//[0..n*m]
//[row,col] = row*n +col
//i -> [i/n][i%n]
class SearchMatrixSorted 
{
	static boolean findElement(int arr[][],int l,int h,int x,int c)
	{
		while(l<=h)
		{
			//get the middle index
			int mid=(l+h)/2;
			//get the corresponding row and column for middle element
			// since index_1D_array=TotalColumns*(current row)+(current column)
			int i=mid/c;
			int j=mid%c;
			//cout<<mid<<" "<<arr[i][j]<<" ";
			if(x==arr[i][j]) 
			{
				System.out.println("Found at "+i+" "+j);
				return true;
			}
			if(x<arr[i][j])
				h=mid-1;
			else 
				l=mid+1;
		}
		return false;
	}
	public static void main (String[] args) 
	{
		int r=5,c=5;
		int arr[][]={{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
		int l=0,h=r*c-1;
	    int x=8;
	    if(!findElement(arr,l,h,x,c))
	        System.out.println("Not found");
	}
}