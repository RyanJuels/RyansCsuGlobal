public class SearchArray 
{	
	public static int search() 
{
		int[] arr = new int[]{3, 6, 5, 1, 4};
		boolean foundNum = false;	
		for (int i = 1; i <= arr.length + 1; i++) 
{
			System.out.println("Checking for " + i);
			for (int j = 0; j < arr.length; j++) 
{
				if (i == arr[j]) 
{
					System.out.println("Found " + i + " at location " + j + "!");
					foundNum = true;
					break;
				}
			}
			if (foundNum == false) 
{
				System.out.println("Could not find " + i + " in array.");
				return i;
			}
			foundNum = false;
		}
		
		//default return, should never execute
		return -1;
	}
	
	public static void main(String args[]) 
{		
		System.out.println(search());
	}
}
