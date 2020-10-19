package stack2;

public class TowerOfHanoi 
{
	static void towerOfHanoi(int n,char from,char to,char aux)
	{
		if(n==1)
		{
			System.out.println("Moved disk 1 "+from+" to "+to);// a to c
			return;
		}
		towerOfHanoi(n-1,from,aux,to);	// a to b
		System.out.println("Moved disk "+n+" "+from+" to "+to);
		towerOfHanoi(n-1,aux,to,from); // b to c
	}
	public static void main(String args[]) 
    { 
        int n = 4; // Number of disks 
        towerOfHanoi(n, 'A', 'C', 'B');  // A, B and C are names of rods 
    } 
}
//Take an example for 2 disks :
//Let rod 1 = 'A', rod 2 = 'B', rod 3 = 'C'.
//
//Step 1 : Shift first disk from 'A' to 'B'.
//Step 2 : Shift second disk from 'A' to 'C'.
//Step 3 : Shift first disk from 'B' to 'C'.
//
//The pattern here is :
//Shift 'n-1' disks from 'A' to 'B'.
//Shift last disk from 'A' to 'C'.
//Shift 'n-1' disks from 'B' to 'C'.
