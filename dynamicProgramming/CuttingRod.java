package dynamicProgramming;

public class CuttingRod 
{

//    public int maxValue(int price[]){
//        int max[] = new int[price.length+1];
//        for(int i=1; i <= price.length; i++)
//        {
//            for(int j=i; j <= price.length; j++)
//            {
//                max[j] = Math.max(max[j], max[j-i] + price[i-1]);
//            }
//        }
//        return max[price.length];
//    }
    
    public int maxValue1(int price[])
    {
        int max[] = new int[price.length+1];
        for(int i=1; i <= price.length; i++)
        {
            max[i] = price[i-1];
        }
        for(int i=1 ; i <= price.length; i++)
        {
            for(int j=1; j < i ; j++)
            {
                max[i] = Math.max(max[i], max[i-j] + max[j]);
            }
        }
        return max[price.length];
    }
    
//    public int recursiveMaxValue(int price[],int len)
//      {
//        if(len <= 0)
//    	  {
//            return 0;
//        }
//        int maxValue = 0;
//        for(int i=0; i < len;i++)
//    		{
//            int val = price[i] + recursiveMaxValue(price, len-i-1);
//            if(maxValue < val)
//    		  {
//                maxValue = val;
//            }
//        }
//        return maxValue;
//    }
    public static void main(String args[])
    {
        CuttingRod cr =new CuttingRod();
        int[] price = {1,5,8,9,10,17,17,20};		//{3,5,8,9,10,20,22,25};
        int r = cr.maxValue1(price);
        System.out.println(r);
    }
}
//algo
//https://www.youtube.com/watch?v=IRwVmTmN6go